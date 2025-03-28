package ru.Balakireva.main; // Класс Main находится в отдельном пакете

import ru.Balakireva.Karate.ActionCommand;
import ru.Balakireva.Karate.Combo;
import ru.Balakireva.Karate.Karateka;
import ru.Balakireva.geometry.*;
import ru.Balakireva.math.*;
import ru.Balakireva.others.GenericStack;
import ru.Balakireva.others.Shooter;
import ru.Balakireva.people.EvenNumberValidator;
import ru.Balakireva.people.Person;
import ru.Balakireva.people.Student;
import ru.Balakireva.people.ZeroOneValidator;

import ru.ermakov.geometry.Point3D; // Импортируем класс Point3D
import java.awt.Point; // Импортируем класс Point из java.awt
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

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
// Класс для тестирования Box
public class Main {
    public static void main(String[] args) {
        // Создаем коробку для хранения целых чисел
        Box<Integer> box = new Box<>();

        // Помещаем число 3 в коробку
        box.put(3);

        // Извлекаем значение из коробки и выводим на экран
        Integer value = box.get();
        System.out.println("Извлеченное значение: " + value);

        // Проверяем, что коробка пуста
        System.out.println("Коробка пуста? " + box.isEmpty());
    }
}

// Класс для тестирования Storage
public class Main {
    public static void main(String[] args) {
        // Хранилище чисел, где значение null
        Storage<Integer> numberStorage1 = new Storage<>(null);
        Integer value1 = numberStorage1.getOrDefault(0);
        System.out.println("Извлеченное значение (null): " + value1); // Ожидаем 0

        // Хранилище чисел, где значение 99
        Storage<Integer> numberStorage2 = new Storage<>(99);
        Integer value2 = numberStorage2.getOrDefault(-1);
        System.out.println("Извлеченное значение (99): " + value2); // Ожидаем 99

        // Хранилище строк, где значение null
        Storage<String> stringStorage1 = new Storage<>(null);
        String stringValue1 = stringStorage1.getOrDefault("default");
        System.out.println("Извлеченное значение (null): " + stringValue1); // Ожидаем "default"

        // Хранилище строк, где значение "hello"
        Storage<String> stringStorage2 = new Storage<>("hello");
        String stringValue2 = stringStorage2.getOrDefault("hello world");
        System.out.println("Извлеченное значение (hello): " + stringValue2); // Ожидаем "hello"
    }
}
// Класс для тестирования Comparable
public class Main {
    public static void main(String[] args) {
        // Сравниваем числа
        NumberComparable numComp1 = new NumberComparable(10);
        NumberComparable numComp2 = new NumberComparable(20);

        System.out.println("Сравнение 10 и 20: " + numComp1.compare(numComp2.getValue())); // Ожидаем -1

        // Сравниваем строки
        StringComparable strComp1 = new StringComparable("apple");
        StringComparable strComp2 = new StringComparable("banana");

        System.out.println("Сравнение 'apple' и 'banana': " + strComp1.compare(strComp2.getValue())); // Ожидаем -1
    }
}

// Класс для тестирования StudentComparable
public class Main {
    public static void main(String[] args) {
        // Создаем двух студентов
        Student student1 = new Student("Alice", 85.5);
        Student student2 = new Student("Bob", 90.0);

        // Сравниваем студентов
        int comparisonResult = student1.compare(student2);

        // Выводим результаты сравнения
        if (comparisonResult > 0) {
            System.out.println(student1.getName() + " имеет более высокую среднюю оценку, чем " + student2.getName());
        } else if (comparisonResult < 0) {
            System.out.println(student1.getName() + " имеет более низкую среднюю оценку, чем " + student2.getName());
        } else {
            System.out.println(student1.getName() + " и " + student2.getName() + " имеют одинаковую среднюю оценку.");
        }
    }

    // Класс для тестирования Fulline
    public class Main {
        public static void main(String[] args) {
            ru.Balakireva.geometry.Point3D start3D = new ru.Balakireva.geometry.Point3D(1, 2, 3, "Red", 5);
            ru.Balakireva.geometry.Point3D end3D = new ru.Balakireva.geometry.Point3D(4, 5, 6, "Blue", 5);

            Line<ru.Balakireva.geometry.Point3D> line3D = new Line<>(start3D, end3D);
            System.out.println(line3D); // Выводим информацию о линии
            System.out.println("Длина линии: " + line3D.getLength()); // Выводим длину
        }
    }

    // Пример использования стека GenericStack
    public static void main(String[] args) {
        GenericStack<Integer> integerStack = new GenericStack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);

        System.out.println("Верхний элемент стека: " + integerStack.peek()); // 3
        System.out.println("Удаляем элемент: " + integerStack.pop()); // 3
        System.out.println("Верхний элемент стека после удаления: " + integerStack.peek()); // 2

        // Создаем стек для строк
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Верхний элемент стека строк: " + stringStack.peek()); // World
    }
}

// Класс для тестирования Line6
public class Main {
    public static void main(String[] args) {
        ru.Balakireva.geometry.Point3D start3D = new ru.Balakireva.geometry.Point3D(1, 2, 3);
        ru.Balakireva.geometry.Point3D end3D = new ru.Balakireva.geometry.Point3D(4, 5, 6);

        Line<ru.Balakireva.geometry.Point3D> line3D = new Line<>(start3D, end3D);
        System.out.println("Перед сдвигом: " + line3D); // Выводим информацию о линии
        System.out.println("Длина линии: " + line3D.getLength()); // Выводим длину

        shiftLine(line3D); // Сдвигаем линию
        System.out.println("После сдвига: " + line3D); // Выводим снова линию
    }
//box 6.2.2
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.put(10);

        Box<Double> box2 = new Box<>();
        box2.put(20.5);

        Box<Float> box3 = new Box<>();
        box3.put(15.7f);

        Box<Integer> box4 = new Box<>();
        box4.put(25);

        // Создаем массив коробок
        Box<?>[] boxes = new Box[]{box1, box2, box3, box4};

        // Находим максимальное значение
        double max = findMax(boxes);
        System.out.println("Максимальное значение: " + max);
    }
}
//box 6.2.2
public class Main {
    // Метод для добавления трехмерной точки в коробку
    public static <T extends Box<? super ru.Balakireva.geometry.Point3D>> void addPointToBox(T box, int x, int y, int z) {
        ru.Balakireva.geometry.Point3D point = new ru.Balakireva.geometry.Point3D(x, y, z); // Создаем новую точку
        box.put(point); // Добавляем точку в коробку
    }

    public static void main(String[] args) {
        Box<ru.Balakireva.geometry.Point3D> box3D = new Box<>();

        // Добавляем различные трехмерные точки в коробку
        addPointToBox(box3D, 1, 2, 3);
        addPointToBox(box3D, 4, 5, 6);

        // Извлекаем и печатаем сущности из коробки
        while (!box3D.isEmpty()) {
            System.out.println("Из коробки извлечена точка: " + box3D.get());
        }
    }
}

// Задача 6.2.4
import java.util.List;

public class Main {

    // Обобщенный метод для заполнения списка числами от 1 до 100
    public static <T extends Number> void fillList(List<T> list) {
        for (int i = 1; i <= 100; i++) {
            // Добавляем значения в список
            // Мы можем использовать метод add для всех типов, поскольку мы передаем List<T>, где T - Number
            // Однако на самом деле мы должны использовать Number, поэтому это может вызвать ошибку компиляции.
            // Нужно использовать подход с приведение типов
            // Для простой реализации создадим новую переменную типа T и добавим в список.
            list.add((T) Integer.valueOf(i)); // Приводим Integer к типу T
        }
    }

    public static void main(String[] args) {
        // Создаем список для Integer
        List<Integer> integerList = new java.util.ArrayList<>();
        fillList(integerList);
        System.out.println("Список целых чисел: " + integerList);

        // Создаем список для Double
        List<Double> doubleList = new java.util.ArrayList<>();
        fillList(doubleList);
        System.out.println("Список дробных чисел: " + doubleList);

        // Создаем список для Float
        List<Float> floatList = new java.util.ArrayList<>();
        fillList(floatList);
        System.out.println("Список дробных чисел Float: " + floatList);
    }
}
//Functional задача 6.3.1
public class Main {

    // Обобщенный метод для применения функции к каждому элементу списка
    public static <T, P> List<P> map(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static void main(String[] args) {
        // Задача 1: Получить список чисел длины строк
        List<String> stringList = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengthList = map(stringList, value -> value.length());
        System.out.println("Длины строк: " + lengthList);

        // Задача 2: Получить список, где все отрицательные числа стали положительными
        List<Integer> integerList = Arrays.asList(1, -3, 7);
        List<Integer> positiveList = map(integerList, value -> Math.abs(value));
        System.out.println("Положительные числа: " + positiveList);

        // Задача 3: Получить список максимальных значений из массивов
        List<int[]> arraysList = Arrays.asList(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{4, 5, 6});
        List<Integer> maxValues = map(arraysList, array -> {
            int max = Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
            return max; // Возвращаем максимальное значение
        });
        System.out.println("Максимум из массивов: " + maxValues);
    }
}
//Predicate Задача 6.3.2
public class Main {

    // Обобщенный метод для фильтрации списка
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Задача 1: Отфильтровать строки меньше трех символов
        List<String> stringList = Arrays.asList("qwerty", "asdfg", "zx");
        List<String> filteredStrings = filter(stringList, value -> value.length() >= 3);
        System.out.println("Отфильтрованные строки: " + filteredStrings);

        // Задача 2: Отфильтровать положительные числа
        List<Integer> integerList = Arrays.asList(1, -3, 7);
        List<Integer> filteredIntegers = filter(integerList, value -> value <= 0);
        System.out.println("Отфильтрованные числа: " + filteredIntegers);

        // Задача 3: Получить массивы, в которых нет положительных элементов
        List<int[]> arraysList = Arrays.asList(new int[]{1, -2, -3}, new int[]{-1, -3, -5}, new int[]{4, 5, 6});
        List<int[]> filteredArrays = filter(arraysList, array -> Arrays.stream(array).allMatch(num -> num <= 0));
        System.out.println("Массивы без положительных элементов:");
        for (int[] array : filteredArrays) {
            System.out.println(Arrays.toString(array));
        }
    }
}
//Reducer задача 6.3.3
public class Main {

    // Обобщенный метод для сводки списка в одно значение
    public static <T> T reduce(List<T> list, Reducer<T> reducer) {
        // Проверка на пустоту списка
        if (list.isEmpty()) {
            // Возвращаем начальное значение, которое не будет null (например, первое значение)
            return null; // или можно вернуть значение по умолчанию
        }

        // Начинаем с первого элемента списка
        T result = list.get(0);

        // Проходим по всем элементам списка и сводим их в одно значение
        for (int i = 1; i < list.size(); i++) {
            result = reducer.reduce(result, list.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        // Задача 1: Сформировать одну большую строку
        List<String> stringList = Arrays.asList("qwerty", "asdfg", "zx");
        String concatenatedString = reduce(stringList, (a, b) -> a + b);
        System.out.println("Сформированная строка: " + concatenatedString);

        // Задача 2: Вернуть сумму всех значений
        List<Integer> integerList = Arrays.asList(1, -3, 7);
        Integer sum = reduce(integerList, (a, b) -> a + b);
        System.out.println("Сумма значений: " + sum);

        // Задача 3: Получить общее количество элементов во всех списках
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList());
        Integer totalCount = reduce(listOfLists, (a, b) -> a + b.size());
        System.out.println("Общее количество элементов: " + totalCount);
    }
}

//collections Задача 6.3.4

import java.util.*;

import java.util.function.Supplier;
import java.util.function.BiConsumer;
public class Main {

    // Обобщенный метод для создания коллекции и распределения значений
    public static <T, P extends Collection<T>> P collect(
            List<T> source,
            Supplier<P> collectionFactory,
            BiConsumer<P, T> valueCollector
    ) {
        // Создаем новую коллекцию с помощью collectionFactory
        P result = collectionFactory.get();

        // Проходим по списку и добавляем элементы в результирующую коллекцию
        for (T value : source) {
            valueCollector.accept(result, value);
        }

        return result;
    }

    public static void main(String[] args) {
        // Задача 1: Разбить на подсписки положительных и отрицательных чисел
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> positiveNumbers = collect(
                numbers,
                ArrayList::new,
                (collection, value) -> {
                    if (value > 0) collection.add(value);
                }
        );
        List<Integer> negativeNumbers = collect(
                numbers,
                ArrayList::new,
                (collection, value) -> {
                    if (value < 0) collection.add(value);
                }
        );
        System.out.println("Положительные числа: " + positiveNumbers);
        System.out.println("Отрицательные числа: " + negativeNumbers);

        // Задача 2: Разбить строки на подсписки одинаковой длины
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");
        Map<Integer, List<String>> groupedByLength = collect(
                strings,
                HashMap::new,
                (map, value) -> {
                    map.putIfAbsent(value.length(), new ArrayList<>());
                    map.get(value.length()).add(value);
                }
        );

        System.out.println("Строки, сгруппированные по длине: " + groupedByLength);

        // Задача 3: Набор уникальных строк
        List<String> uniqueStrings = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueSet = collect(
                uniqueStrings,
                HashSet::new,
                Set::add
        );

        System.out.println("Уникальные строки: " + uniqueSet);
    }
}
// задача 7.1.2
public class Main {
    public static void main(String[] args) {
        // Создание дроби с заданными числителем и знаменателем
        Fraction fraction1 = FractionGenerator.createFraction(1, 2);
        System.out.println("Fraction 1: " + fraction1);

        // Создание случайной дроби
        Fraction randomFraction = FractionGenerator.createRandomFraction(10, 10);
        System.out.println("Random Fraction: " + randomFraction);

        // Создание дроби из целого числа
        Fraction fractionFromInteger = FractionGenerator.createFractionFromInteger(5);
        System.out.println("Fraction from Integer: " + fractionFromInteger);

        // Создание дроби с заданными свойствами
        Fraction fractionWithProperties = FractionGenerator.createFractionWithProperties(3, 4);
        System.out.println("Fraction with Properties: " + fractionWithProperties);
    }
}
// задача 7.1.3
public class Main {
    public static void main(String[] args) {
        // Получаем единственный экземпляр генератора
        FractionGenerator generator = FractionGenerator.getInstance();

        Fraction fraction1 = generator.createFraction(1, 2);
        Fraction fraction2 = generator.createFraction(3, 4);

        System.out.println("Fraction 1: " + fraction1);
        System.out.println("Fraction 2: " + fraction2);
        System.out.println("Sum: " + fraction1.sum(fraction2));
    }
}
//задача 7.1.4
public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = FractionGenerator.createFraction(1, 2);
        Fraction fraction2 = FractionGenerator.createFraction(1, 2);
        Fraction fraction3 = FractionGenerator.createFraction(3, 4);

        System.out.println("Fraction 1: " + fraction1);
        System.out.println("Fraction 2: " + fraction2);
        System.out.println("Fraction 3: " + fraction3);

        // Сравнение дробей
        System.out.println("Fraction 1 equals Fraction 2: " + fraction1.equals(fraction2)); // true
        System.out.println("Fraction 1 equals Fraction 3: " + fraction1.equals(fraction3)); // false
    }
    // Тестовый класс для карате
    public class Main {
        public static void main(String[] args) {
            Karateka daniel = new Karateka("Дэниэл");

            // Создание комбинации ударов
            Combo combo = new Combo();
            combo.addAction(new ActionCommand("punch", daniel)); // Удар рукой
            combo.addAction(new ActionCommand("kick", daniel));  // Удар ногой
            combo.addAction(new ActionCommand("punch", daniel)); // Удар рукой
            combo.addAction(new ActionCommand("jumpKick", daniel)); // Удар в прыжке

            // Выполнение комбинации
            combo.executeCombo(daniel.name);
        }
    }
