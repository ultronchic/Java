public class Main {
    public static void main(String[] args) {
        // Создание точек
        Point point1 = new Point(1, 3);
        Point point2 = new Point(23, 8);
        Point point3 = new Point(5, 10);
        Point point4 = new Point(25, 10);

        // Линия 1
        Line line1 = new Line(point1, point2);
        System.out.println(line1);
        System.out.println("Длина линии 1: " + line1.getLength());

        // Линия 2 (горизонтальная на высоте 10)
        Line line2 = new Line(point3, point4);
        System.out.println(line2);
        System.out.println("Длина линии 2: " + line2.getLength());

        // Линия 3 (начинается там же, где линия 1, и заканчивается там же, где линия 2)
        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.println(line3);

        // Изменим координаты первой и второй линий
        line1.setEnd(new Point(20, 10)); // Меняем конец первой линии
        line2.setStart(new Point(0, 10)); // Меняем начало второй линии

        // Проверяем линии после изменений
        System.out.println("После изменения координат:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        // Изменение координат первой линии не изменяет координаты третьей
        line1.setStart(new Point(2, 6)); // Меняем начало, но оно не повлияет на линию 3

        // Проверяем линии после изменений
        System.out.println("После изменения только начала первой линии:");
        System.out.println(line1);
        System.out.println(line3);
    }
}