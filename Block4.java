public class Block41 {
    //задача 4.1
    public static void main(String[] args) {
        System.out.println(listNums(5)); // ожидается "0 1 2 3 4 5"
        System.out.println(listNums(0)); // ожидается "0"
        System.out.println(listNums(10)); // ожидается "0 1 2 3 4 5 6 7 8 9 10"
    }
    public static String listNums(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i++) {
            result.append(i);
            if (i < x) {
                result.append(" "); // добавляем пробел между числами, кроме последнего
            }
        }
        return result.toString(); // возвращаем результат в виде строки
    }
}
public class Block42 {
    //задача 4.2
    public static void main(String[] args) {
        System.out.println(reverseListNums(5)); // ожидается "5 4 3 2 1 0"
        System.out.println(reverseListNums(0)); // ожидается "0"
        System.out.println(reverseListNums(10)); // ожидается "10 9 8 7 6 5 4 3 2 1 0"
    }
    public static String reverseListNums(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = x; i >= 0; i--) {
            result.append(i); // добавляем текущее число
            if (i > 0) { // добавляем пробел между числами, кроме последнего
                result.append(" ");
            }
        }
        return result.toString(); // возвращаем результат в виде строки
    }
}

public class Block43 {
    //задача 4.3
    public static void main(String[] args) {
        System.out.println(chet(9)); // ожидается "0 2 4 6 8"
        System.out.println(chet(10)); // ожидается "0 2 4 6 8 10"
        System.out.println(chet(0)); // ожидается "0"
        System.out.println(chet(1)); // ожидается "0"
    }
    public static String chet(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i += 2) { // начинаем с 0 и увеличиваем на 2
            result.append(i); // добавляем текущее четное число
            result.append(" "); // добавляем пробел
        }
        // Удаляем последний пробел, если результат не пустой
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        return result.toString(); // возвращаем результат в виде строки
    }
}
public class Block44 {
    //задача 4.4
    public static void main(String[] args) {
        System.out.println(pow(2, 5)); // ожидается 32
        System.out.println(pow(3, 3)); // ожидается 27
        System.out.println(pow(5, 0)); // ожидается 1
        System.out.println(pow(4, 1)); // ожидается 4
        System.out.println(pow(2, 10)); // ожидается 1024
    }
    public static int pow(int x, int y) {
        int result = 1; // начальное значение
        for (int i = 0; i < y; i++) { // повторяем y раз
            result *= x; // умножаем результат на x
        }
        return result; // возвращаем результат
    }
}
public class Block45 {
    //задача 4.5
    public static void main(String[] args) {
        System.out.println(numLen(12567)); // ожидается 5
        System.out.println(numLen(0));      // ожидается 1
        System.out.println(numLen(-1234));  // ожидается 4
        System.out.println(numLen(9876543210L)); // ожидается 10
    }
    public static int numLen(long x) {
        // Отрицательные числа рассматриваем с их абсолютным значением
        x = Math.abs(x);
        // Если x равно 0, то длина - 1
        if (x == 0) {
            return 1;
        }
        int length = 0;
        while (x > 0) {
            x /= 10; // Делене на 10
            length++; // Увеличиваем счетчик
        }
        return length; // Возвращаем количество цифр
    }
}


public class Block46 {
    //задача 4.6
    public static void main(String[] args) {
        System.out.println(equalNum(1111)); // ожидается true
        System.out.println(equalNum(1211)); // ожидается false
        System.out.println(equalNum(22222)); // ожидается true
        System.out.println(equalNum(0)); // ожидается true
    }
    public static boolean equalNum(int x) {
        // Если число отрицательное, берем его абсолютное значение
        x = Math.abs(x);
        // Получаем последнюю цифру числа
        int lastDigit = x % 10;
        // Уменьшаем число, убирая последнюю цифру
        x /= 10;
        // Проверяем оставшиеся цифры
        while (x > 0) {
            // Получаем текущую последнюю цифру
            int currentDigit = x % 10;
            // Сравниваем её с последней цифрой
            if (currentDigit != lastDigit) {
                return false; // Если не совпадают, возвращаем false
            }
            // Убираем последнюю цифру
            x /= 10;
        }
        // Если все цифры совпали, возвращаем true
        return true;
    }
}
public class Block47 {
    //задача 4.7
    public static void main(String[] args) {
        square(2); // ожидается:
        // **
        // **
        System.out.println(); // для разделения выводов
        square(4); // ожидается:
        // ****
        // ****
        // ****
        // ****
    }
    public static void square(int x) {
        // Внешний цикл для каждой строки
        for (int i = 0; i < x; i++) {
            // Внутренний цикл для каждого символа в строке
            for (int j = 0; j < x; j++) {
                System.out.print('*'); // выводим символ без перехода на новую строку
            }
            System.out.println(); // переход на новую строку после завершения вывода символов текущей строки
        }
    }
}
public class Block48 {
    //задача 4.8
    public static void main(String[] args) {
        leftTriangle(2); // ожидается:
        // *
        // **
        System.out.println(); // Для разделения выводов

        leftTriangle(4); // ожидается:
        // *
        // **
        // ***
        // ****
    }
    public static void leftTriangle(int x) {
        // Внешний цикл отвечает за строки
        for (int i = 1; i <= x; i++) {
            // Внутренний цикл отвечает за вывод символов '*' в строке
            for (int j = 1; j <= i; j++) {
                System.out.print('*'); // Выводим символ без перехода на новую строку
            }
            System.out.println(); // Переход на новую строку после завершения вывода символов текущей строки
        }
    }
}
public class Block49 {
    //задача 4.9
    public static void main(String[] args) {
        rightTriangle(3); // ожидается:
        //     *
        //   **
        // ***
        System.out.println(); // Для разделения выводов
        rightTriangle(4); // ожидается:
        //       *
        //     **
        //   ***
        // ****
    }
    public static void rightTriangle(int x) {
        // Внешний цикл отвечает за строки
        for (int i = 1; i <= x; i++) {
            // Внутренний цикл выводит пробелы
            for (int j = 1; j <= x - i; j++) {
                System.out.print(" "); // выводим пробелы для выравнивания
            }
            // Внутренний цикл выводит символы '*'
            for (int j = 1; j <= i; j++) {
                System.out.print("*"); // выводим символ без перехода на новую строку
            }
            System.out.println(); // Переход на новую строку после завершения вывода символов текущей строки
        }
    }
}
public class Block410 {
//задача 4.10
public static void guessGame() {
    int randomNum = 3; // Загаданное число
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int attempts = 0; // Счетчик попыток
    int x = -1; // Начальное значение для числа, введенного пользователем

    while (x != randomNum) {
        System.out.println("What number am I thinking (0 to 9)? :");
        x = sc.nextInt(); // Считываем число от пользователя
        attempts++; // Увеличиваем счетчик попыток

        if (x != randomNum) {
            System.out.println("No, try again");
        } else {
            System.out.println("Yes, it's " + randomNum);
        }
    }
    System.out.println("It took you " + attempts + " attempts to guess the number.");
}

