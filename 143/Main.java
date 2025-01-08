import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Создание первой ломаной
        Polyline polyline1 = new Polyline(Arrays.asList(new Point(1, 5), new Point(2, 8), new Point(5, 3)));
        System.out.println("Первая ломаная: " + polyline1);

        // Создание второй ломаной
        Polyline polyline2 = new Polyline(Arrays.asList(new Point(1, 5), new Point(2, -5), new Point(4, -8), new Point(5, 3)));
        System.out.println("Вторая ломаная: " + polyline2);

        // Сдвиг начала первой ломаной
        polyline1.shift(1, 1);
        System.out.println("Первая ломаная после сдвига: " + polyline1);
        System.out.println("Вторая ломаная после сдвига: " + polyline2);
    }
}