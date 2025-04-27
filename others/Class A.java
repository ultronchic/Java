package ru.Balakireva.models;
import ru.Balakireva.others.ToString;

public class A {
    private String s = "hello";

    @ToString(value = "NO") // Поле x не будет включено в строковое представление
    private int x = 42;

    public A() {}
}

class B extends A {
    @ToString(value = "YES") // Это поле будет включено в строковое представление
    private String text = "B";

    public B() {}
}