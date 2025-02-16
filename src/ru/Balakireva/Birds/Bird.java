package ru.Balakireva.Birds;

import java.util.Random;

// Базовый класс для птиц
abstract class Bird {
    // Метод для пения, который будет переопределен в подклассах
    public abstract void sing();
}

// Класс Воробей
class Sparrow extends Bird {
    @Override
    public void sing() {
        System.out.println("чирик");
    }
}

// Класс Кукушка
class Cuckoo extends Bird {
    private Random random = new Random();

    @Override
    public void sing() {
        int times = random.nextInt(10) + 1; // Случайное число от 1 до 10
        for (int i = 0; i < times; i++) {
            System.out.print("ку-ку");
            if (i < times - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Переход на новую строку
    }
}

// Класс Попугай
class Parrot extends Bird {
    private final String text;
    private Random random = new Random();

    public Parrot(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не может быть пустым.");
        }
        this.text = text;
    }

    @Override
    public void sing() {
        int n = random.nextInt(text.length()) + 1; // Случайное число от 1 до длины текста
        System.out.println(text.substring(0, n));
    }
}

// Основной класс для тестирования
/* public class Main {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird cuckoo = new Cuckoo();
        Bird parrot = new Parrot("Привет, я попугай!");

        System.out.println("Воробей:");
        sparrow.sing();

        System.out.println("Кукушка:");
        cuckoo.sing();

        System.out.println("Попугай:");
        parrot.sing();
    }
}
 */