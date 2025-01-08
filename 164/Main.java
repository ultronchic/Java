public class Main {
    public static void main(String[] args) {
        // Создание дробей
        Fraction f1 = new Fraction(1, 3); // 1/3
        Fraction f2 = new Fraction(2, 3); // 2/3
        Fraction f3 = new Fraction(1, 2); // 1/2
        Fraction f4 = new Fraction(5, 1); // 5

        // Примеры выполнения операций
        Fraction result1 = f1.multiply(f2); // 1/3 * 2/3 = 2/9
        System.out.println(f1 + " * " + f2 + " = " + result1);

        Fraction result2 = f1.sum(f2); // 1/3 + 2/3 = 1
        System.out.println(f1 + " + " + f2 + " = " + result2);

        Fraction result3 = f3.minus(1); // 1/2 - 1 = -1/2
        System.out.println(f3 + " - 1 = " + result3);

        Fraction result4 = f3.divide(f2); // 1/2 / 2/3 = 3/4
        System.out.println(f3 + " / " + f2 + " = " + result4);

        // Вычисление f1.sum(f2).div(f3).minus(5)
        Fraction finalResult = f1.sum(f2).divide(f3).minus(5);
        System.out.println("Результат вычисления f1.sum(f2).div(f3).minus(5) = " + finalResult);
    }
}