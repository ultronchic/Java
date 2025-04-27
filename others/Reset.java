package ru.Balakireva.others;

import java.lang.reflect.Field;

public class AnnotationUtils {

    public static void reset(Object... objects) {
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

    private static void setDefaults(Object obj, Class<?> defaultType) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            setFieldValue(obj, field, defaultType);
        }
    }

    private static void setFieldValue(Object obj, Field field, Class<?> type) {
        try {
            field.setAccessible(true); // Игнорируем инкапсуляцию

            Object value;
            if (type.equals(String.class)) {
                value = "hello"; // Значение по умолчанию для String
            } else if (type.equals(int.class)) {
                value = 42; // Значение по умолчанию для int
            } else if (type.equals(Integer.class)) {
                value = 42; // Значение по умолчанию для Integer
            } else if (type.equals(Object.class)) {
                value = new Object(); // Значение по умолчанию для Object
            } else {
                value = null; // Для других типов используем null или можно добавить другие типы.
            }

            field.set(obj, value); // Устанавливаем значение поля

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}