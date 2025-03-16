public class PowerCalculator {

    // Метод для возведения X в степень Y
    public static double raiseToPower(String x, String y) {
        // Преобразуем строки в целые числа
        int base = Integer.parseInt(x);
        int exponent = Integer.parseInt(y);

        // Возводим в степень и возвращаем результат
        return Math.pow(base, exponent);
    }
}