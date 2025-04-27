package ru.Balakireva.others;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheUtil {
    public static <T> T cache(T obj) {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Cache.class)) {
            return obj; // Если аннотация отсутствует, возвращаем оригинальный объект
        }

        Cache cacheAnnotation = clazz.getAnnotation(Cache.class);
        String[] methodsToCache = cacheAnnotation.value();

        InvocationHandler handler = new CacheInvocationHandler(obj, methodsToCache);

        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                handler
        );
    }

    private static class CacheInvocationHandler implements InvocationHandler {
        private final Object originalObject;
        private final Map<Method, Object> cache = new HashMap<>();

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
            for (String methodName : methodsToCache) {
                if (method.getName().equals(methodName)) {
                    // Проверяем наличие кэша для данного метода
                    if (cache.containsKey(method)) {
                        return cache.get(method); // Возвращаем закэшированное значение
                    }

                    // Вызываем оригинальный метод и сохраняем результат в кэше
                    Object result = method.invoke(originalObject);
                    cache.put(method, result);
                    return result; // Возвращаем результат вызова метода
                }
            }
            return method.invoke(originalObject); // Если метод не подлежит кэшированию - просто вызываем его
        }
    }
}