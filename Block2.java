public class Block2 {
    //задача 2.1
    public static void main(String[] args) {
        double x = 5.25;
        double result = fraction(x);
        System.out.println(result);
    }
    public static double fraction(double x) {
        // Приведение к int отбрасывает дробную часть
        int integerPart = (int) x; // Получаем целую часть
        return x - integerPart; // Возвращаем дробную часть
    }
}
    //задача 2.2
public class Block22 {
        public static void main(String[] args) {
            int x = 4568;
            int result = sumLastNums(x);
            System.out.println(result);
        }

        public static int sumLastNums(int x) {
            // Получаем последние две цифры числа
            int lastDigit = x % 10;       // Последняя цифра
            int secondLastDigit = (x / 10) % 10; // Предпоследняя цифра
            // Возвращаем сумму двух последних цифр
            return lastDigit + secondLastDigit;
        }
}
    //задача 2.3
public class Block23 {
        public static void main(String[] args) {
            char x = '3';
            int result = charToNum(x);
            System.out.println(result);
        }

        public static int charToNum(char x) {
            // Преобразуем символ в соответствующее число
            return x - '0'; // '0' имеет код 48, цифра '3' имеет код 51, вычитание дает 3
        }
    }
        //задача 2.4
public class Block24 {
    public static void main(String[] args) {
        int x1 = 3;
        int x2 = -5;

        boolean result1 = isPositive(x1);
        boolean result2 = isPositive(x2);

        System.out.println("Число " + x1 + " положительное? " + result1); // true
        System.out.println("Число " + x2 + " положительное? " + result2); // false
        }
        public static boolean isPositive(int x) {
        // Проверяем, является ли число больше нуля
        return x > 0; // возвращает true, если x положительное, иначе false
        }
}
    //задача 2.5
public class Block25 {
    public static void main(String[] args) {
        int x1 = 3;
        int x2 = -5;
        boolean result1 = isPositive(x1);
        boolean result2 = isPositive(x2);
        System.out.println(" " + x1 + " " + result1); // true
        System.out.println(" " + x2 + " " + result2); // false
        }
        public static boolean isPositive(int x) {
        // Проверяем, является ли число больше нуля
        return x > 0; // возвращает true, если x положительное, иначе false
    }
}
    //задача 2.6
public class Block26 {
    public static void main(String[] args) {
        char x1 = 'D';
        char x2 = 'q';

        boolean result1 = isUpperCase(x1); // ожидается true
        boolean result2 = isUpperCase(x2); // ожидается false

        System.out.println("Символ " + x1 + " - это большая буква? " + result1);
        System.out.println("Символ " + x2 + " - это большая буква? " + result2);
        }
        public static boolean isUpperCase(char x) {
        // Проверяем, находится ли символ в диапазоне от 'A' до 'Z'
        return x >= 'A' && x <= 'Z'; // возвращает true, если x - большая буква
        }
}
    //задача 2.7
public class Block27 {
    public static void main (String[] args) {
        int a1 = 5, b1 = 1, num1 = 3;
        int a2 = 2, b2 = 15, num2 = 33;

        boolean result1 = isInRange(a1, b1, num1); // ожидается true
        boolean result2 = isInRange(a2, b2, num2); // ожидается false

        System.out.println("Число " + num1 + " в диапазоне от " + a1 + " до " + b1 + "? " + result1); // true
        System.out.println("Число " + num2 + " в диапазоне от " + a2 + " до " + b2 + "? " + result2); // false
    }
    public static boolean isInRange(int a, int b, int num) {
        // Находим минимальное и максимальное значение из a и b
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        // Проверяем, входит ли num в диапазон от min до max
        return num >= min && num <= max; // возвращает true, если num в диапазоне
    }
    //задача 2.8
public class Block28 {
    public static void main (String[] args) {

        int a1 = 3, b1 = 6;     // ожидается true
        int a2 = 2, b2 = 15;    // ожидается false

        boolean result1 = isDivisor(a1, b1);
        boolean result2 = isDivisor(a2, b2);

        System.out.println("Число " + a1 + " делит " + b1 + "? " + result1); // true
        System.out.println("Число " + a2 + " делит " + b2 + "? " + result2); // false
    }
    public static boolean isDivisor(int a, int b) {
        // Проверяем, делит ли одно число другое нацело
        return (b % a == 0) || (a % b == 0);
    }
}

    //задача 2.9
public class Block29 {
    public static void main (String[] args) {
        // Примеры использования метода
        int a1 = 3, b1 = 3, c1 = 3;     // ожидается true
        int a2 = 2, b2 = 15, c2 = 2;    // ожидается false

        boolean result1 = isEqual(a1, b1, c1);
        boolean result2 = isEqual(a2, b2, c2);

        System.out.println("Все числа равны? " + result1); // true
        System.out.println("Все числа равны? " + result2); // false
    }
    public static boolean isEqual(int a, int b, int c) {
        // Проверяем, равны ли все три числа
        return (a == b) && (b == c);
    }
}
    //задача 2.10
public class Block210 {
    public static void main (String[] args) {
        int result = 5; // Начальное значение

        // Последовательное сложение с использованием метода lastNumSum
        result = lastNumSum(result, 11); // 5 + 11 = 6 (по последней цифре)
        result = lastNumSum(result, 123); // 6 + 123 = 9 (по последней цифре)
        result = lastNumSum(result, 14); // 9 + 14 = 13 (по последней цифре)
        result = lastNumSum(result, 1); // 13 + 1 = 4 (по последней цифре)

        // Выводим итоговый результат
        System.out.println("Итого: " + result);
    }
    public static int lastNumSum(int a, int b) {
    return (a % 10) + (b % 10);
    }
}
