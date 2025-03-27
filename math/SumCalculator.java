package ru.Balakireva.math;
import java.math.BigInteger;
import java.util.List;

public class SumCalculator {
    public static double sum(List<Number> numbers) {
        double total = 0.0;
        BigInteger bigTotal = BigInteger.ZERO;
        for (Number number : numbers) {
            if (number instanceof Integer) {
                total += number.intValue();
            } else if (number instanceof Double) {
                total += number.doubleValue();
            } else if (number instanceof Fraction) {
                total += ((Fraction) number).toDouble();
            } else if (number instanceof Fraction) {
                total += ((Fraction) number).toDouble();
            } else if (number instanceof BigInteger) {
                bigTotal = bigTotal.add((BigInteger) number);
            // Преобразуем bigTotal в double и добавляем к total
                total += bigTotal.doubleValue();
        }
        return total;
    }
}
