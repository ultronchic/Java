import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class NameFieldPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // Проверяем, есть ли у бина поле "name"
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ("name".equals(field.getName()) && field.getType() == String.class) {
                field.setAccessible(true); // Делаем поле доступным для изменения
                try {
                    // Если значение поля null, присваиваем "vasia"
                    if (field.get(bean) == null) {
                        field.set(bean, "vasia");
                    }
                } catch (IllegalAccessException e) {
                    throw new BeansException("Failed to access field 'name'", e) {};
                }
            }
        }
        return bean; // Возвращаем измененный или неизмененный бин
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean; // Не изменяем бин после инициализации
    }
}