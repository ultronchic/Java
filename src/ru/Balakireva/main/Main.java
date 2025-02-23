package ru.Balakireva.main; // Класс Main находится в отдельном пакете

import ru.Balakireva.geometry.*;
import ru.Balakireva.others.Shooter;
import ru.Balakireva.people.EvenNumberValidator;
import ru.Balakireva.people.Person;
import ru.Balakireva.math.MathUtils;
import ru.Balakireva.people.Student;
import ru.Balakireva.people.ZeroOneValidator;

import ru.ermakov.geometry.Point3D; // Импортируем класс Point3D
import java.awt.Point; // Импортируем класс Point из java.awt

import static ru.Balakireva.math.PowerCalculator.raiseToPower;

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
public class Main {
    private static double power(String x, String y) {
        int base = Integer.parseInt(x);
        int exponent = Integer.parseInt(y);
        return Math.pow(base, exponent);
    }
public static void main(String[] args) {
        // Вася: позволяет только 0 и 1
        Student vasya = new Student("Вася", new ZeroOneValidator(), 1, 0, 1);
        System.out.println(vasya.getName() + " оценки: " + vasya.getGrades() + ", средняя: " + vasya.getAverageGrade());

        // Петя: позволяет любые четные числа
        Student petya = new Student("Петя", new EvenNumberValidator(), 2, 4, 6);
        System.out.println(petya.getName() + " оценки: " + petya.getGrades() + ", средняя: " + petya.getAverageGrade());
    }
public static void main(String[] args) {
        // Создание стрелков
        Shooter shooterWithoutWeapon = new Shooter("Стрелок без оружия");
        Shooter shooterWithPistol = new Shooter("Стрелок с пистолетом");
        Shooter shooterWithAutomatic = new Shooter("Стрелок с автоматом");

        // Создание оружия
        Pistol pistol = new Pistol(5);
        Automatic automatic = new Automatic(3);

        // Назначаем оружие стрелкам
        shooterWithPistol.setWeapon(pistol);
        shooterWithAutomatic.setWeapon(automatic);

        // Стрельба
        shooterWithoutWeapon.shoot(); // Ожидаемый выход: "не могу участвовать в перестрелке"
        shooterWithPistol.shoot();     // Ожидаемый выход: "Выстрел из пистолета. Осталось патронов: 4"
        shooterWithAutomatic.shoot();   // Ожидаемый выход: "Выстрел из автомата. Осталось патронов: 2"

        // Стрельба еще раз
        shooterWithPistol.shoot();     // Ожидаемый выход: "Выстрел из пистолета. Осталось патронов: 3"
        shooterWithAutomatic.shoot();   // Ожидаемый выход: "Выстрел из автомата. Осталось патронов: 1"
    }
public static void main(String[] args) {
        // Создание нескольких квадратов
        Point topLeft1 = new Point(0, 0);
        Square square1 = new Square(topLeft1, 5);

        Point topLeft2 = new Point(6, 0);
        Square square2 = new Square(topLeft2, 5);

        // Массив объектов
        LengthMeasurable[] shapes = { square1, square2 };

        // Объединение в одну Polyline
        Polyline combinedPolyline = PolygonalChain.combinePolylines(shapes);

        System.out.println(combinedPolyline);
        System.out.println("Общая длина: " + combinedPolyline.getLength());

        ClosedPolyline closedPolyline = square.toClosedPolyline();
        System.out.println(closedPolyline); // Печатает информацию о замкнутой ломаной
        System.out.println("Длина замкнутого квадрата: " + closedPolyline.getLength());
}
    public static void main(String[] args) {
        // Проверяем, что передано два аргумента
        if (args.length < 2) {
            System.out.println("Пожалуйста, введите два числа: X и Y.");
            return;
        }
        // Вызываем метод и выводим результат
        double result = raiseToPower(args[0], args[1]);
        System.out.println("Результат: " + result);
    }
    //задача 3.2.1
        public static void main(String[] args) {
            // Создаем экземпляры Point и Point3D
            Point point2D = new Point(5, 10);
            Point3D point3D = new Point3D(5, 10, 15, "red", 2);

            // Выводим их на экран
            System.out.println("2D Point: " + point2D);
            System.out.println("3D Point: " + point3D);
        }
        package ru.Balakireva.others;

        public class Main {
            public static void main(String[] args) {
                Department sales = new Department("Продажи");
                Employee alice = new Employee("Алиса");
                Employee bob = new Employee("Боб");

                // Устанавливаем отдел для сотрудников
                alice.setDepartment(sales);
                bob.setDepartment(sales);

                // Устанавливаем менеджера
                sales.setManager(alice);

                // Выводим информацию о отделе и сотрудниках
                System.out.println(sales);
                System.out.println(alice);
                System.out.println(bob);
            }
        }
    //задача 4.1.1
    public static void main(String[] args) {
        GradeValidator validator = new GradeValidator() {
            @Override
            public boolean isValid(int grade) {
                return grade >= 1 && grade <= 10; // Пример валидатора
            }
        };

        Student student = new Student("Алиса", validator);

        try {
            student.addGrade(11); // Это вызовет исключение
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage()); // Выводим сообщение об ошибке
        }
    }
}

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        dataReader.readData();
    }
    public static void main(String[] args) {
        GradeValidator validator = new SimpleGradeValidator();

        Student student1 = new Student("Иван", validator);
        Student student2 = new Student("Петр", validator);
        Student student3 = new Student("Света", validator);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        String result = addRandomGrades(students);
        System.out.println(result);

        // Выводим оценки студентов
        for (Student student : students) {
            System.out.println(student.getName() + "'s grades: " + student.getGrades());
        }
    }

}
}