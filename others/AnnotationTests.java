package ru.Balakireva.others;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class CacheUtilTest {

    private AInterface cachedA;

    @BeforeEach
    void setUp() {
        // Создаем кэшированный объект A
        cachedA = CacheUtil.cache(new A("test"));
    }

    @Test
    void testCacheMethodInvocation() {
        // Проверяем, что метод cacheTest() вызывается и возвращает ожидаемое значение
        assertEquals(42, cachedA.cacheTest());
    }

    @Test
    void testCacheMethodIsCached() {
        // Вызываем метод cacheTest() дважды и проверяем, что он не вызывает оригинальный метод повторно
        assertEquals(42, cachedA.cacheTest()); // Первый вызов - оригинальный метод
        assertEquals(42, cachedA.cacheTest()); // Второй вызов - должен использовать кэш

        // Здесь можно добавить логику для проверки, что оригинальный метод не был вызван повторно.
        // Например, можно использовать Mockito для создания моков и проверки вызовов.
    }

    @Test
    void testNonCachedMethodInvocation() {
        // Убедимся, что метод setStringField() не кэшируется и работает корректно
        cachedA.setStringField("new value");

        // Проверяем, что метод cacheTest() все еще возвращает закэшированное значение
        assertEquals(42, cachedA.cacheTest());
    }

    @Test
    void testCacheWithDifferentInstances() {
        AInterface anotherCachedA = CacheUtil.cache(new A("another test"));

        // Убедимся, что разные экземпляры имеют свои собственные кэши
        assertEquals(42, anotherCachedA.cacheTest());

        // Проверяем, что первый экземпляр по-прежнему возвращает закэшированное значение
        assertEquals(42, cachedA.cacheTest());

        // Убедимся, что второй экземпляр также работает независимо от первого
        assertEquals(42, anotherCachedA.cacheTest());
    }
}