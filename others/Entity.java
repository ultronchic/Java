package ru.Balakireva.others;

import java.lang.reflect.Field;

// Абстрактный класс Entity
public abstract class Entity {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getSimpleName() + "{");

        Field[] fields = getClass().getDeclaredFields();
        boolean allFieldsExcluded = true; // Флаг для проверки, все ли поля исключены

        for (Field field : fields) {
            field.setAccessible(true); // Игнорируем инкапсуляцию

            // Проверяем наличие аннотации @ToString на поле
            if (field.isAnnotationPresent(ToString.class)) {
                ToString annotation = field.getAnnotation(ToString.class);
                if ("NO".equals(annotation.value())) {
                    continue; // Пропускаем поле с @ToString(NO)
                } else if ("YES".equals(annotation.value())) {
                    allFieldsExcluded = false; // Есть хотя бы одно поле с @ToString(YES)
                }
            } else {
                allFieldsExcluded = false; // Поле не помечено, значит оно включается
            }

            try {
                Object value = field.get(this);
                result.append(field.getName()).append("=").append(value);
                result.append(", ");
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
        return allFieldsExcluded ? getClass().getSimpleName() + "{}" : result.toString();
    }
}

// Класс A, наследующий от Entity
class A extends Entity {
    private String s = "hello";
    @ToString(value = "NO") // Поле x не будет включено в строковое представление
    private int x = 42;

    // Конструктор по умолчанию
    public A() {}
}


// Класс B, наследующий от A
class B extends A {
    private String text = "B"; // Это поле будет включено в строковое представление

    // Конструктор по умолчанию
    public B() {}
}



// Класс Main для тестирования
//public class Main {
//    public static void main(String[] args) {
//        B b = new B();
//        System.out.println(b); // Вывод: B{text=B, s=hello, x=42}
//    }
//}