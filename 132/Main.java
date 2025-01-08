public class Main {
    public static void main(String[] args) {
        // 1. Создаем первую ломаную
        Point[] points1 = {
                new Point(1, 5),
                new Point(2, 8),
                new Point(5, 3)
        };
        Polyline polyline1 = new Polyline(points1);
        System.out.println(polyline1); // Вывод первой ломаной

        // 2. Создаем вторую ломаную
        Point[] points2 = {
                polyline1.getFirstPoint(),
                new Point(2, -5),
                new Point(4, -8),
                polyline1.getLastPoint()
        };
        Polyline polyline2 = new Polyline(points2);
        System.out.println(polyline2); // Вывод второй ломаной

        // 3. Сдвигаем первую ломаную
        double deltaX = 1; // Пример сдвига по x
        double deltaY = 2; // Пример сдвига по y
        polyline1.shift(deltaX, deltaY);
        polyline2.shift(deltaX, deltaY); // Сдвигаем обе ломаные

        // Выводим результат после сдвига
        System.out.println("После сдвига:");
        System.out.println(polyline1);
        System.out.println(polyline2);
    }
}