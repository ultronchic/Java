package ru.Balakireva.geometry;

public class LengthCalculator {

    public static double calculateTotalLength(LengthMeasurable[] lengthMeasurableObjects) {
        double totalLength = 0.0;
        for (LengthMeasurable obj : lengthMeasurableObjects) {
            totalLength += obj.getLength();
        }
        return totalLength;
    }

    public static void main(String[] args) {
        // Создаем объекты Line и Polyline
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 2);
        Line line = new Line(p1, p2);
        Polyline polyline = new Polyline(new Point[]{p1, p2, p3});
        ClosedPolyline closedPolyline = new ClosedPolyline(new Point[]{p1, p2, p3, p1});

        // Создаем массив объектов, которые могут измерять длину
        LengthMeasurable[] shapes = { line, polyline, closedPolyline };

        // Вычисляем общую длину
        double totalLength = calculateTotalLength(shapes);
        System.out.printf("Общая длина всех объектов: %.2f\n", totalLength);
    }
}