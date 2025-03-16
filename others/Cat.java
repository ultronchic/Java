package ru.Balakireva.others;

public class Cat {
    private String name; // Имя кота

    // Конструктор для инициализации имени кота
    public Cat(String name) {
        this.name = name;
    }

    // Метод для возврата текстового представления кота
    @Override
    public String toString() {
        return "кот: " + name;
    }

    // Метод для мяуканья один раз
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    // Метод для мяуканья N раз
    public void meow(int times) {
        StringBuilder meowSound = new StringBuilder(name + ": ");
        for (int i = 0; i < times; i++) {
            meowSound.append("мяу");
            if (i < times - 1) {
                meowSound.append("-");
            }
        }
        System.out.println(meowSound.toString() + "!");
    }

    /* public static void main(String[] args) {
        // Создаем кота по имени "Барсик"
        Cat cat = new Cat("Барсик");

        // Пусть кот помяукает один раз
        cat.meow();

        // Пусть кот помяукает три раза
        cat.meow(3);
    }*/
}