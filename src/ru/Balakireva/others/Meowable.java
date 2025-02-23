package ru.Balakireva.others;

// Интерфейс для объектов, которые могут мяукать
interface Meowable {
    void meow(); // Метод мяуканья
}

// Класс Кот
public class Cat implements Meowable {
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

    // Реализация метода мяуканья один раз
    @Override
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

    public static void main(String[] args) {
        // Создаем котов
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");

        // Тестируем мяуканье
        cat1.meow(); // Мяукаем один раз
        cat2.meow(3); // Мяукаем три раза

        // Создание объекта класса, который также может мяукать
        Dog dog = new Dog("Шарик");
        Meowable[] animals = { cat1, cat2, dog };

        // Вызываем метод мяуканья для каждого мяукающего объекта
        makeThemMeow(animals);
    }

    // Метод для того, чтобы заставить всех мяукать
    public static void makeThemMeow(Meowable[] meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow(); // Вызываем метод мяуканья
        }
    }
}

// Пример другого класса, который может мяукать (например, Собака, но для демонстрации)
class Dog implements Meowable {
    private String name; // Имя собаки

    public Dog(String name) {
        this.name = name;
    }

    // Реализация метода мяуканья в классе Собака
    @Override
    public void meow() {
        System.out.println(name + ": гав-гав, но я могу тоже мяукать!");
    }
}