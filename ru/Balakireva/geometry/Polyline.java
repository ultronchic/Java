package ru.Balakireva.geometry;

import java.util.List;
import java.util.ArrayList;

public class Polyline {

    // Конструктор
    public Polyline(Point[] points) {
        this.points = points;
    }

    private List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public void shiftAll(double dx, double dy) {
        for (Point point : points) {
            point.shift(dx, dy); // сдвигаем каждую точку
        }
    }
    public double calculateTotalLength() {
        double totalLength = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            totalLength += calculateDistance(points.get(i), points.get(i + 1));
        }
        return totalLength;
    }
    // Метод для сдвига всех точек на заданное количество по x и y
    public void shift(double deltaX, double deltaY) {
        for (Point point : points) {
            point.shift(deltaX, deltaY); // Добавим метод shift в класс Point
    }
    // Метод для получения первой и последней точки
    public Point getFirstPoint() {
        return points[0];
    }
    public Point getLastPoint() {
        return points[points.length - 1];
    }

    // Метод для строки
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
             sb.append(points[i].toString());
             if (i < points.length - 1) {
                sb.append(", ");
             }
        }
        sb.append("]");
        return sb.toString()
    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}