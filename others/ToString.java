package ru.Balakireva.others;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;


// Определение аннотации @ToString
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {
    String value() default "YES";// Значение по умолчанию - "YES"
}

// Класс Person с аннотацией @ToString
class Person {
    @ToString(value = "YES")
    private String name;

    @ToString(value = "NO")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Метод для получения строкового представления объекта
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getSimpleName() + "{");

        // Получаем поля класса
        Field[] fields = getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // Игнорируем инкапсуляцию

            // Проверяем наличие аннотации @ToString
            if (field.isAnnotationPresent(ToString.class)) {
                ToString annotation = field.getAnnotation(ToString.class);
                if ("YES".equals(annotation.value())) {
                    try {
                        Object value = field.get(this);
                        result.append(field.getName()).append("=").append(value);
                        if (i < fields.length - 1) {
                            result.append(", ");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        result.append("}");
        return result.toString();
    }
}
