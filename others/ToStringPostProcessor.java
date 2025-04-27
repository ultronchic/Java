package ru.Balakireva.others;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class ToStringPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();

        // Проверяем наличие полей с аннотацией @ToString
        Field[] fields = clazz.getDeclaredFields();
        boolean hasToStringAnnotation = false;

        for (Field field : fields) {
            if (field.isAnnotationPresent(ToString.class)) {
                hasToStringAnnotation = true;
                break;
            }
        }

        // Если есть хотя бы одно поле с аннотацией @ToString, создаем прокси-объект
        if (hasToStringAnnotation) {
            return Proxy.newProxyInstance(
                    clazz.getClassLoader(),
                    new Class<?>[]{clazz},
                    new ToStringInvocationHandler(bean)
            );
        }

        return bean; // Возвращаем оригинальный бин, если аннотация не найдена
    }

    private static class ToStringInvocationHandler implements InvocationHandler {
        private final Object target;

        public ToStringInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
            if ("toString".equals(method.getName())) {
                return generateToString(target);
            }
            return method.invoke(target, args);
        }

        private String generateToString(Object obj) {
            StringBuilder result = new StringBuilder(obj.getClass().getSimpleName() + "{");
            Field[] fields = obj.getClass().getDeclaredFields();
            boolean allFieldsExcluded = true; // Флаг для проверки, все ли поля исключены

            for (Field field : fields) {
                field.setAccessible(true); // Игнорируем инкапсуляцию

                // Проверяем наличие аннотации @ToString на поле
                if (field.isAnnotationPresent(ToString.class)) {
                    ToString annotation = field.getAnnotation(ToString.class);
                    if ("NO".equals(annotation.value())) {
                        continue; // Пропускаем поле с @ToString(NO)
                    } else {
                        allFieldsExcluded = false; // Есть хотя бы одно поле с @ToString(YES)
                    }
                } else {
                    allFieldsExcluded = false; // Поле не помечено, значит оно включается
                }

                try {
                    Object value = field.get(obj);
                    result.append(field.getName()).append("=").append(value).append(", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Удаляем последнюю запятую и пробел
            if (result.length() > 1) {
                result.setLength(result.length() - 2);
            }

            result.append("}");

            // Если все поля исключены, возвращаем пустое представление
            return allFieldsExcluded ? obj.getClass().getSimpleName() + "{}" : result.toString();
        }
    }
}