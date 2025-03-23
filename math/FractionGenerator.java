package ru.Balakireva.math;

public final class Fraction extends Number {
    private final int numerator;   // Числитель
    private final int denominator; // Знаменатель

    // Скрытый конструктор
    private Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); // Упрощаем дробь при создании
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Остальные методы (sum, minus, multiply, div и т.д.) остаются без изменений

    private void reduce() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Переопределение методов equals, hashCode и других остается без изменений
}

class FractionGenerator {
    // Статический экземпляр для реализации Singleton
    private static FractionGenerator instance;

    // Приватный конструктор
    private FractionGenerator() {}

    // Метод для получения единственного экземпляра
    public static FractionGenerator getInstance() {
        if (instance == null) {
            instance = new FractionGenerator();
        }
        return instance;
    }

    // Метод для создания объектов Fraction
    public Fraction createFraction(int numerator, int denominator) {
        return new Fraction(numerator, denominator);
    }
}

