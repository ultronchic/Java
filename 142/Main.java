public class Main {
    public static void main(String[] args) {
        // Создание точек
        Point point1 = new Point(1, 3);
        Point point2 = new Point(23, 8);
        Point point3 = new Point(5, 10);
        Point point4 = new Point(25, 10);

        // Создание линий
        Line line1 = new Line(point1, point2);
        Line line2 = new Line(point3.getX(), point3.getY(), point4.getX(), point4.getY());
        Line line3 = new Line(point1, new Point(point4.getX(), point2.getY()));

        // Вывод линий на экран
        System.out.println(line1); // Вывод: Линия от {1;3} до {23;8}
        System.out.println(line2); // Вывод: Линия от {5;10} до {25;10}
        System.out.println(line3); // Вывод: Линия от {1;3} до {25;8}

        // Изменение координат первой линии
        point1 = new Point(2, 4);
        line1 = new Line(point1, point2); // Обновляем линию с новыми координатами

        // Изменение координат второй линии
        point3 = new Point(6, 10);
        line2 = new Line(point3.getX(), point3.getY(), point4.getX(), point4.getY()); // Обновляем линию

        // Вывод обновленных линий на экран
        System.out.println(line1); // Вывод: Линия от {2;4} до {23;8}
        System.out.println(line2); // Вывод: Линия от {6;10} до {25;10}
        System.out.println(line3); // Вывод: Линия от {2;4} до {25;8}
    }
}