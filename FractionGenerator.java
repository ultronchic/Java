// задача 7.1.2
package ru.Balakireva.math;
import java.util.Random;
// задача 7.1.3 синглтон
public class FractionGenerator {
    // Статический экземпляр самого себя
    private static FractionGenerator instance;

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    private FractionGenerator() {
    }

    // Метод для получения единственного экземпляра генератора
    public static FractionGenerator getInstance() {
        if (instance == null) {
            instance = new FractionGenerator();
        }
        return instance;
    }
    // задача 7.1.2
    // Метод для создания объектов Fraction
    public Fraction createFraction(int numerator, int denominator) {
        return new Fraction(numerator, denominator);
    }
    // задача 7.1.2
    // Метод для создания случайной дроби
    public Fraction createRandomFraction(int maxNumerator, int maxDenominator) {
        Random random = new Random();
        int numerator = random.nextInt(maxNumerator + 1); // Генерируем случайный числитель
        int denominator = random.nextInt(maxDenominator) + 1; // Генерируем случайный знаменатель (не может быть 0)
        return new Fraction(numerator, denominator);
    }
    // задача 7.1.2
    // Метод для создания дроби из целого числа
    public Fraction createFractionFromInteger(int integer) {
        return new Fraction(integer, 1); // Создаем дробь с целым числом как числитель и 1 как знаменатель
    }
    // задача 7.1.2
    // Метод для создания дроби с заданным числителем и знаменателем
    public Fraction createFractionWithProperties(int numerator, int denominator) {
        return new Fraction(numerator, denominator);
    }
    // задача 7.1.4
    // Статический метод для сравнения дробей
    public static boolean compareFractions(Fraction f1, Fraction f2) {
        return f1.equals(f2);
    }
}