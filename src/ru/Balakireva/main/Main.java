package ru.Balakireva.main; // Класс Main находится в отдельном пакете

import ru.Balakireva.geometry.Point;
import ru.Balakireva.geometry.Line;
import ru.Balakireva.people.Person;
import ru.Balakireva.math.MathUtils;

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(10, 15);
        Line line = new Line(point1, point2);
        System.out.println("Длина линии: " + line.getLength());

        Person person = new Person("Иван");
        System.out.println(person);
    }
}
public class Main {
    public static void main(String[] args) {
        // Создаем людей
        Person ivan = new Person("Иван");                  // Чудов Иван
        Person petr = new Person("Чудов", "Петр");        // Чудов Петр, отец Иван
        Person boris = new Person(petr, "Борис"); // Борис, отец Петр

        // Выводим на экран строковое представление всех троих людей
        System.out.println(ivan);  // Иван
        System.out.println(petr);  // Петр Чудов
        System.out.println(boris); // Борис Чудов
    }
}
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // Сложение 2 + 3/5 + 2.3
        double result1 = MathUtils.sumNumbers(2, 3.0 / 5, 2.3);
        System.out.println("Результат 1: " + result1);

        // Сложение 3.6 + 49/12 + 3 + 3/2
        double result2 = MathUtils.sumNumbers(3.6, 49.0 / 12, 3, 3.0 / 2);
        System.out.println("Результат 2: " + result2);

        // Сложение 1/3 + 1
        double result3 = MathUtils.sumNumbers(1.0 / 3, 1);
        System.out.println("Результат 3: " + result3);

        // Сложение 7 + 11/3 + 3.21 + 12345678912345678912
        BigInteger bigNumber = new BigInteger("12345678912345678912");
        double result4 = MathUtils.sumNumbers(7, 11.0 / 3, 3.21, bigNumber);
        System.out.println("Результат 4: " + result4);
    }
}
package ru.Balakireva.main;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Необходимо передать два числа в качестве аргументов.");
            return;
        }

        String xStr = args[0];
        String yStr = args[1];

        try {
            double result = power(xStr, yStr);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: одно из значений не является числом.");
        }
    }

    private static double power(String x, String y) {
        int base = Integer.parseInt(x);
        int exponent = Integer.parseInt(y);
        return Math.pow(base, exponent);
    }
}