package ru.Balakireva.geometry;

public class GeometryTest {
    public static void main(String[] args) {
        // Создание нескольких квадратов
        Point topLeft1 = new Point(0, 0);
        Square square1 = new Square(topLeft1, 5);

        Point topLeft2 = new Point(6, 0);
        Square square2 = new Square(topLeft2, 5);

        // Массив объектов
        LengthMeasurable[] shapes = { square1, square2 };

        // Объединение в одну Polyline
        Polyline combinedPolyline = PolygonalChain.combinePolylines(shapes);

        System.out.println(combinedPolyline);
        System.out.println("Общая длина: " + combinedPolyline.getLength());

        ClosedPolyline closedPolyline = square.toClosedPolyline();
        System.out.println(closedPolyline); // Печатает информацию о замкнутой ломаной
        System.out.println("Длина замкнутого квадрата: " + closedPolyline.getLength());
    }
}