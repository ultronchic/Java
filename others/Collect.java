package ru.Balakireva.others;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationCollector {

    public static Map<String, Object> collect(Class<?>... classes) {
        Map<String, Object> result = new HashMap<>();

        for (Class<?> clazz : classes) {
            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                // Проверяем условия:
                // 1. Метод помечен аннотацией @Invoke
                // 2. Не имеет параметров
                // 3. Возвращает значение (не void)
                if (method.isAnnotationPresent(Invoke.class) &&
                        method.getParameterCount() == 0 &&
                        !method.getReturnType().equals(void.class)) {

                    try {
                        // Если метод статический, вызываем его без объекта,
                        // иначе создаем экземпляр класса для вызова метода.
                        Object value = method.getModifiers() & java.lang.reflect.Modifier.STATIC
                                ? method.invoke(null)
                                : method.invoke(clazz.getDeclaredConstructor().newInstance());

                        result.put(method.getName(), value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return result;
    }
}