package ru.Balakireva.others;

public class A {
    @Invoke
    public String m1() {
        return "text";
    }

    public String m2() {
        return "place";
    }

    @Invoke
    public Integer m3() {
        return 42;
    }
}