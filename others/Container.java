package ru.Balakireva.main;

import ru.Balakireva.models.A;
import ru.Balakireva.others.CacheUtil;

public class Container {

    public static void main(String[] args) {
        A a1 = new A("first");
        A a2 = new A("second");

        A a1Proxy = CacheUtil.cache(a1);
        A a2Proxy = CacheUtil.cache(a2);

        System.out.println(a1Proxy.cacheTest()); // вывод: original method 42
        System.out.println(a1Proxy.cacheTest()); // вывод: 42 (метод закэширован)

        a1.setStringField("changed"); // Изменяем поле у оригинального объекта

        System.out.println(a1Proxy.cacheTest()); // вывод: 42 (метод все еще закэширован)

        System.out.println(a2Proxy.cacheTest()); // вывод: original method 42 (для другого объекта)
    }
}