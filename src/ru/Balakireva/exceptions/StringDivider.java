package ru.Balakireva.exceptions;
import java.util.ArrayList;
import java.util.List;

public class StringDivider {
    public static Double divideFirstByOthers(String[] strings) {
        List<Double> numbers = new ArrayList<>();

        // Преобразуем строки в числа
        for (String str : strings) {
            try {
                // Пробуем преобразовать строку в число
                double number = Double.parseDouble(str);
                numbers.add(number);
            } catch (NumberFormatException e) {
                // Игнорируем строки, которые не являются числами
                System.out.println("Игнорируем некорректный ввод: " + str);
            }
        }

        // Проверяем, есть ли достаточно чисел для выполнения деления
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("Необходимо как минимум два числа для операции деления.");
        }

        // Первое число
        double firstNumber = numbers.get(0);
        double result = firstNumber;

        // Делим первое число на остальные
        for (int i = 1; i < numbers.size(); i++) {
            double divisor = numbers.get(i);
            if (divisor == 0) {
                throw new ArithmeticException("Деление на ноль невозможно.");
            }
            result /= divisor;
        }

        // Возвращаем результат
        return result;
    }

    /* public static void main(String[] args) {
        String[] input = {"10", "2", "5", "not a number", "0", "3"};
        try {
            double result = divideFirstByOthers(input);
            System.out.println("Результат деления: " + result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }*/
}