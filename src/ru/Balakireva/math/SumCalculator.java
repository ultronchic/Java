package ru.Balakireva.math;

import java.util.List;

public class SumCalculator {
    public static double sum(List<Number> numbers) {
        double total = 0.0;

        for (Number number : numbers) {
            if (number instanceof Integer) {
                total += number.intValue();
            } else if (number instanceof Double) {
                total += number.doubleValue();
            } else if (number instanceof Fraction) {
                total += ((Fraction) number).toDouble();
            }
        }

        return total;
    }
}