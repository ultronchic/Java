package ru.Balakireva.others;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

public class AnnotationUtils {

    @Autowired
    private ApplicationContext applicationContext; // Внедряем контекст

    public void reset(Object... objects) {
        for (Object obj : objects) {
            Class<?> clazz = obj.getClass();

            // Проверяем аннотацию на классе
            if (clazz.isAnnotationPresent(Default.class)) {
                Default classDefault = clazz.getAnnotation(Default.class);
                setDefaults(obj, classDefault.value());
            }

            // Обрабатываем все поля объекта, включая унаследованные
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Default.class)) {
                    Default fieldDefault = field.getAnnotation(Default.class);
                    setFieldValue(obj, field, fieldDefault.value());
                }
            }
        }
    }

    private void setDefaults(Object obj, String defaultBeanName) {
        Object defaultBean = applicationContext.getBean(defaultBeanName);
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            setFieldValue(obj, field, defaultBean);
        }
    }

    private void setFieldValue(Object obj, Field field, String defaultBeanName) {
        try {
            field.setAccessible(true); // Игнорируем инкапсуляцию
            Object value = applicationContext.getBean(defaultBeanName); // Получаем значение из контекста
            field.set(obj, value); // Устанавливаем значение поля
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}