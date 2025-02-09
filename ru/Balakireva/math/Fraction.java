package ru.Balakireva.math;

public class Fraction {
    private int numerator;   // Числитель
    private int denominator; // Знаменатель

    // Конструктор
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); // Упрощаем дробь при создании
    }

    // Метод для получения строкового представления
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Метод сложения
    public Fraction sum(Fraction other) {
        return new Fraction(
                this.numerator * other.denominator + other.numerator * this.denominator,
                this.denominator * other.denominator
        );
    }

    // Метод вычитания
    public Fraction minus(Fraction other) {
        return new Fraction(
                this.numerator * other.denominator - other.numerator * this.denominator,
                this.denominator * other.denominator
        );
    }

    // Метод умножения
    public Fraction multiply(Fraction other) {
        return new Fraction(
                this.numerator * other.numerator,
                this.denominator * other.denominator
        );
    }

    // Метод деления
    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на 0 не возможно.");
        }
        return new Fraction(
                this.numerator * other.denominator,
                this.denominator * other.numerator
        );
    }

    // Упрощение дроби
    private void reduce() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
    }

    // Метод для нахождения наибольшего общего делителя
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Операции с целым числом
    public Fraction sum(int integer) {
        return new Fraction(this.numerator + integer * this.denominator, this.denominator);
    }

    public Fraction minus(int integer) {
        return new Fraction(this.numerator - integer * this.denominator, this.denominator);
    }

    public Fraction multiply(int integer) {
        return new Fraction(this.numerator * integer, this.denominator);
    }

    public Fraction div(int integer) {
        if (integer == 0) {
            throw new IllegalArgumentException("Деление на 0 не возможно.");
        }
        return new Fraction(this.numerator, this.denominator * integer);
    }
}