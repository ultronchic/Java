public class Fraction {
    private int numerator;   // Числитель
    private int denominator; // Знаменатель

    // Конструктор для инициализации числителя и знаменателя
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); // Упрощаем дробь при создании
    }

    // Метод для упрощения дроби
    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Метод для нахождения наибольшего общего делителя
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Метод для получения строкового представления дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Метод для сложения дробей
    public Fraction sum(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для вычитания дробей
    public Fraction minus(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для умножения дробей
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для деления дробей
    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для сложения дроби и целого числа
    public Fraction sum(int integer) {
        return this.sum(new Fraction(integer, 1));
    }

    // Метод для вычитания целого числа из дроби
    public Fraction minus(int integer) {
        return this.minus(new Fraction(integer, 1));
    }

    // Метод для умножения дроби на целое число
    public Fraction multiply(int integer) {
        return new Fraction(this.numerator * integer, this.denominator);
    }

    // Метод для деления дроби на целое число
    public Fraction div(int integer) {
        if (integer == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return new Fraction(this.numerator, this.denominator * integer);
    }

    public static void main(String[] args) {
        // Создаем несколько экземпляров дробей
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(1, 2);

        // Примеры использования методов
        Fraction sumResult = f1.sum(f2);
        Fraction minusResult = f1.minus(f3);
        Fraction multiplyResult = f1.multiply(f2);
        Fraction divResult = f1.div(f3);

        // Выводим примеры и результаты
        System.out.println(f1 + " + " + f2 + " = " + sumResult);
        System.out.println(f1 + " - " + f3 + " = " + minusResult);
        System.out.println(f1 + " * " + f2 + " = " + multiplyResult);
        System.out.println(f1 + " / " + f3 + " = " + divResult);

        // Выполняем задачу: f1.sum(f2).div(f3).minus(5)
        Fraction finalResult = f1.sum(f2).div(f3).minus(5);
        System.out.println("Результат f1.sum(f2).div(f3).minus(5) = " + finalResult);
    }
}