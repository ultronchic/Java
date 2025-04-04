package ru.Balakireva.others;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

// 1. Определение аннотации @Cache
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target(ElementType.TYPE) // Цель - тип (класс)
public @interface Cache {
    String[] value() default {}; // Необязательное свойство value с пустым массивом по умолчанию
}

// Интерфейс AInterface
interface AInterface {
    int cacheTest();
}

// Класс A, который будет кэшироваться
@Cache(value = {"cacheTest"}) // Указываем, что метод cacheTest подлежит кэшированию
class A implements AInterface {
    private String stringField;

    public A(String str) {
        this.stringField = str;
    }

    public int cacheTest() {
        System.out.println("original method");
        return 42;
    }

    public void setStringField(String str) {
        this.stringField = str;
    }
}

// Утилитный класс для кэширования
public class CacheUtil {
    public static <T> T cache(T obj) {
        Class<?> clazz = obj.getClass();

        // Проверяем наличие аннотации @Cache
        if (!clazz.isAnnotationPresent(Cache.class)) {
            return obj; // Если аннотация отсутствует, возвращаем оригинальный объект
        }

        Cache cacheAnnotation = clazz.getAnnotation(Cache.class);
        String[] methodsToCache = cacheAnnotation.value(); // Получаем названия методов для кэширования

        InvocationHandler handler = new CacheInvocationHandler(obj, methodsToCache);

        // Создаем прокси-объект
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                handler
        );
    }

    private static class CacheInvocationHandler implements InvocationHandler {
        private final Object originalObject;
        private final Map<Method, Object> cache = new HashMap<>();
        private final Map<Method, Long> lastModified = new HashMap<>();
        private final String[] methodsToCache;

        public CacheInvocationHandler(Object originalObject, String[] methodsToCache) {
            this.originalObject = originalObject;
            this.methodsToCache = methodsToCache;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // Проверяем, что метод не имеет параметров и является публичным
            if (args != null && args.length > 0) {
                return method.invoke(originalObject, args);
            }

            // Проверяем, нужно ли кэшировать данный метод
            boolean shouldCache = false;
            for (String methodName : methodsToCache) {
                if (method.getName().equals(methodName)) {
                    shouldCache = true;
                    break;
                }
            }

            long currentModificationTime = System.currentTimeMillis(); // Здесь можно использовать более сложную логику для отслеживания изменений

            if (shouldCache) {
                // Проверяем наличие кэша для данного метода
                if (cache.containsKey(method)) {
                    if (lastModified.get(method).equals(currentModificationTime)) {
                        return cache.get(method); // Возвращаем закэшированное значение
                    }
                }

                // Вызываем оригинальный метод и сохраняем результат в кэше
                Object result = method.invoke(originalObject);
                cache.put(method, result);
                lastModified.put(method, currentModificationTime); // Обновляем время последнего изменения
                return result;
            } else {
                return method.invoke(originalObject); // Если метод не подлежит кэшированию - просто вызываем его
            }
        }
    }

    public static void main(String[] args) {
        A a = cache(new A("first"));

        System.out.println(a.cacheTest()); // вывод: original method 42
        a.setStringField("second");

        System.out.println(a.cacheTest()); // вывод: original method 42 (метод не закэширован)

        System.out.println(a.cacheTest()); // вывод: 42 (метод закэширован)
    }
}