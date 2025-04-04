package ru.Balakireva.geometry;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Polyline {
    private final List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }
}

public class Main {

    public static void main(String[] args) {
        // Пример набора точек
        Point[] pointsArray = new Point[]{
                new Point(1, -2),
                new Point(1, 2),
                new Point(2, 3),
                new Point(2, -3),
                new Point(3, 4),
                new Point(1, 2), // Дубликат
                new Point(3, -5)
        };

        // Создание Polyline с использованием Stream.of
        Polyline polyline = new Polyline(
                Stream.of(pointsArray)
                        .distinct() // Убираем дубликаты
                        .map(point -> new Point(point.getX(), Math.abs(point.getY()))) // Делаем Y положительными
                        .sorted(Comparator.comparingInt(Point::getX)) // Сортируем по X
                        .collect(Collectors.toList()) // Собираем в список
        );

        // Вывод результата (для проверки)
        polyline.getPoints().forEach(point ->
                System.out.println("Point: (" + point.getX() + ", " + point.getY() + ")"));
    }
}