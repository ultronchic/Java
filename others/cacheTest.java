package ru.Balakireva.models;

import ru.Balakireva.others.Cache;
import ru.Balakireva.others.AInterface;

@Cache(value = {"cacheTest"})
public class A implements AInterface {
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