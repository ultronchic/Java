public class Main {
    public static void main(String[] args) {
        // Создание первой линии
        Point start1 = new Point(1, 3);
        Point end1 = new Point(23, 8);
        Line line1 = new Line(start1, end1);
        System.out.println(line1);

        // Создание второй линии
        Point start2 = new Point(5, 10);
        Point end2 = new Point(25, 10);
        Line line2 = new Line(start2, end2);
        System.out.println(line2);

        // Создание третьей линии
        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.println(line3);

        // Изменяем первую и вторую линии
        start1.setX(5);
        end1.setY(10);
        start2.setX(10);
        end2.setX(30);

        // Обновляем третью линию согласно условиям
        line3.setStart(line1.getStart());
        line3.setEnd(line2.getEnd());

        System.out.println("Измененные линии:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        // Изменяем координаты первой линии так, чтобы не изменились координаты третьей линии
        line1.getStart().setX(0); // Изменим только координату, чтобы это не повлияло на line3
        System.out.println("После изменения первой линии:");
        System.out.println(line1);
        System.out.println(line3);
    }
}