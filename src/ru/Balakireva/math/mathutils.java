package ru.Balakireva.math;

public class MathUtils {
    public static double sumNumbers(Number... numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}