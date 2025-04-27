package ru.Balakireva.others;

@Default(value = String.class) // Аннотируем класс
public class MyClass {

    @Default(value = Integer.class) // Аннотируем поле
    private int myField;

    public MyClass() {
        this.myField = 10; // Пример значения поля
    }

    public int getMyField() {
        return myField;
    }
}