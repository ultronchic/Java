public class Block3 {
    //задача 3.1
    public static void main(String[] args) {
        // Примеры использования метода
        int result1 = abs(5);   // ожидается 5
        int result2 = abs(-3);  // ожидается 3

        // Выводим результаты на экран
        System.out.println("Модуль числа 5: " + result1);   // Модуль числа 5: 5
        System.out.println("Модуль числа -3: " + result2);  // Модуль числа -3: 3
    }
    public static int abs(int x) {
        // Проверяем, является ли x отрицательным
        if (x < 0) {
            return -x; // Возвращаем -x для получения модуля
        } else {
            return x;  // Возвращаем x, если он положительный или равен нулю
        }
    }
}
public class Block32 {
    //задача 3.2
    public static void main(String[] args) {
        int result1 = safeDiv(5, 0);  // ожидается 0
        int result2 = safeDiv(8, 2);  // ожидается 4
        System.out.println("Результат деления 5 на 0: " + result1);  // Результат деления 5 на 0: 0
        System.out.println("Результат деления 8 на 2: " + result2);  // Результат деления 8 на 2: 4
    }
    public static int safeDiv(int x, int y) {
        // Проверяем, является ли y равным 0
        if (y == 0) {
            return 0; // Возвращаем 0 при попытке деления на 0
        } else {
            return x / y; // Выполняем деление, если y не равно 0
        }
    }
}
public class Block33 {
    //задача 3.3
    public static void main(String[] args) {
        int result1 = max(5, 7);   // ожидается 7
        int result2 = max(8, -1);  // ожидается 8
        System.out.println("Максимум из 5 и 7: " + result1);   // Максимум из 5 и 7: 7
        System.out.println("Максимум из 8 и -1: " + result2);  // Максимум из 8 и -1: 8
    }
    public static int max(int x, int y) {
        // Сравниваем x и y, возвращаем максимальное значение
        if (x > y) {
            return x; // x больше y, возвращаем x
        } else {
            return y; // y больше или равно x, возвращаем y
        }
    }
}
public class Block34 {
    //задача 3.4
    public static void main(String[] args) {
        String result1 = makeDecision(5, 7);   // ожидается "5 < 7"
        String result2 = makeDecision(8, -1);  // ожидается "8 > -1"
        String result3 = makeDecision(4, 4);   // ожидается "4 == 4"
        System.out.println(result1);  // 5 < 7
        System.out.println(result2);  // 8 > -1
        System.out.println(result3);  // 4 == 4
    }
    public static String makeDecision(int x, int y) {
        // Сравниваем x и y и формируем строку в зависимости от результата
        if (x > y) {
            return x + " > " + y;   // x больше y
        } else if (x < y) {
            return x + " < " + y;   // x меньше y
        } else {
            return x + " == " + y;  // x равно y
        }
    }
}
public class Block35 {
    //задача 3.5
    public static void main(String[] args) {
        int result1 = max3(5, 7, 7);   // ожидается 7
        int result2 = max3(8, -1, 4);  // ожидается 8
        System.out.println("Максимум из 5, 7 и 7: " + result1);   // Максимум из 5, 7 и 7: 7
        System.out.println("Максимум из 8, -1 и 4: " + result2);  // Максимум из 8, -1 и 4: 8
    }
    public static int max3(int x, int y, int z) {
        // Сравниваем x и y, затем результат сравниваем с z
        int maxXY = (x > y) ? x : y; // Находим максимум из x и y
        return (maxXY > z) ? maxXY : z; // Сравниваем максимум с z и возвращаем
    }
}
public class Block36 {
    //задача 3.6
    public static void main(String[] args) {
        boolean result1 = sum3(5, 7, 2);   // ожидается true
        boolean result2 = sum3(8, -1, 4);  // ожидается false
        System.out.println("Результат для (5, 7, 2): " + result1);   // true
        System.out.println("Результат для (8, -1, 4): " + result2);  // false
    }
    public static boolean sum3(int x, int y, int z) {
        // Проверяем условия для сложения
        return (x + y == z) || (x + z == y) || (y + z == x);
    }
}
public class Block37 {
    //задача 3.7
    public static void main(String[] args) {
        int result1 = sum2(5, 7);   // ожидается 20
        int result2 = sum2(8, -1);  // ожидается 7
        System.out.println("Сумма 5 и 7: " + result1);   // Сумма 5 и 7: 20
        System.out.println("Сумма 8 и -1: " + result2);  // Сумма 8 и -1: 7
    }
    public static int sum2(int x, int y) {
        int sum = x + y; // Находим сумму x и y
        // Проверяем, попадает ли сумма в диапазон от 10 до 19
        if (sum >= 10 && sum <= 19) {
            return 20; // Если да, возвращаем 20
        }
        return sum; // В противном случае возвращаем обычную сумму
    }
}
public class Block38 {
    //задача 3.8
    public static void main(String[] args) {
        System.out.println("is35(5): " + is35(5));   // ожидается true
        System.out.println("is35(8): " + is35(8));   // ожидается false
        System.out.println("is35(15): " + is35(15)); // ожидается false
    }
    public static boolean is35(int x) {
        // Проверяем, делится ли x на 3 и 5
        boolean divisibleBy3 = (x % 3 == 0);
        boolean divisibleBy5 = (x % 5 == 0);

        // Если x делится и на 3, и на 5, возвращаем false
        if (divisibleBy3 && divisibleBy5) {
            return false;
        }
        // Возвращаем true, если x делится на 3 или на 5
        return divisibleBy3 || divisibleBy5;
    }
}
public class Block39 {
    //задача 3.9
    public static void main(String[] args) {
        System.out.println("magic6(5, 7): " + magic6(5, 7)); // ожидается false
        System.out.println("magic6(8, 2): " + magic6(8, 2)); // ожидается true
        System.out.println("magic6(1, 6): " + magic6(1, 6)); // ожидается true
        System.out.println("magic6(6, 0): " + magic6(6, 0)); // ожидается true
        System.out.println("magic6(12, 6): " + magic6(12, 6)); // ожидается true
    }
    public static boolean magic6(int x, int y) {
        // Проверяем условия для "волшебной шестерки"
        return (x == 6 || y == 6 || (x + y) == 6 || Math.abs(x - y) == 6);
    }
}
public class Block310 {
    //задача 3.10
    public static void main(String[] args) {
        System.out.println(age(5));   // ожидается "5 лет"
        System.out.println(age(31));  // ожидается "31 год"
        System.out.println(age(44));  // ожидается "44 года"
        System.out.println(age(11));  // ожидается "11 лет"
        System.out.println(age(22));  // ожидается "22 года"
        System.out.println(age(42));  // ожидается "42 года"
        System.out.println(age(101)); // ожидается "101 год"
    }
    public static String age(int x) {
        String suffix;
        // Проверяем последнюю цифру и исключения
        if (x % 10 == 1 && x % 100 != 11) {
            suffix = "год"; // 1, 21, 31, ..., 101 и т.д.
        } else if (x % 10 >= 2 && x % 10 <= 4 && (x % 100 < 12 || x % 100 > 14)) {
            suffix = "года"; // 2, 3, 4, 22, 23, 24 и т.д.
        } else {
            suffix = "лет"; // все остальные случаи
        }
        return x + " " + suffix;
    }
}
public class Block311 {
    //задача 3.11
    public static void main(String[] args) {
        System.out.println(day(1)); // ожидается "понедельник"
        System.out.println(day(5)); // ожидается "пятница"
        System.out.println(day(7)); // ожидается "воскресенье"
        System.out.println(day(0)); // ожидается "это не день недели"
        System.out.println(day(8)); // ожидается "это не день недели"
    }
    public static String day(int x) {
        String dayName;
        switch (x) {
            case 1:
                dayName = "понедельник";
                break;
            case 2:
                dayName = "вторник";
                break;
            case 3:
                dayName = "среда";
                break;
            case 4:
                dayName = "четверг";
                break;
            case 5:
                dayName = "пятница";
                break;
            case 6:
                dayName = "суббота";
                break;
            case 7:
                dayName = "воскресенье";
                break;
            default:
                return "это не день недели";
        }
        return dayName;
    }
}
public class Block312 {
    //задача 3.12
    public static void main(String[] args) {
        printDays("четверг"); // ожидается вывод всех дней начиная с четверга
        printDays("понедельник"); // ожидается вывод всех дней начиная с понедельника
        printDays("воскресенье"); // ожидается вывод только "воскресенье"
        printDays("чг"); // ожидается "это не день недели"
    }
    public static void printDays(String x) {
        // Приводим строку к нижнему регистру для корректного сравнения
        x = x.toLowerCase();
        // Переменная, которая будет использоваться для падения сквозь метки
        boolean validDay = true;
        // Пробуем использовать switch для проверки дня недели
        switch (x) {
            case "понедельник":
                System.out.println("понедельник");
                // Падение через метки к следующему дню
            case "вторник":
                System.out.println("вторник");
                // Падение через метки к следующему дню
            case "среда":
                System.out.println("среда");
                // Падение через метки к следующему дню
            case "четверг":
                System.out.println("четверг");
                // Падение через метки к следующему дню
            case "пятница":
                System.out.println("пятница");
                // Падение через метки к следующему дню
            case "суббота":
                System.out.println("суббота");
                // Падение через метки к следующему дню
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                validDay = false; // Установим флаг, если день не правильный
                break;
        }
        // Если день не валиден, выводим сообщение
        if (!validDay) {
            System.out.println("это не день недели");
        }
    }
}