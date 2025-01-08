public class Main {
    public static void main(String[] args) {
        // Создаем три точки с разными координатами
        Point point1 = new Point(3, 4);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(-5, 7);

        // Выводим текстовое представление точек на экран
        System.out.println(point1); // {3;4}
        System.out.println(point2); // {1;2}
        System.out.println(point3); // {-5;7}
    }
}