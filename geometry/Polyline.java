package ru.Balakireva.geometry;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Polyline implements LengthMeasurable {
    private List<Point> points;

    public Polyline(Point[] points) {
        this.points = new ArrayList<>();
        for (Point point : points) {
            this.points.add(point);
        }
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void shiftAll(double dx, double dy) {
        for (Point point : points) {
            point.shift(dx, dy);
        }
    }

    @Override
    public double getLength() {
        return calculateTotalLength();
    }

    public double calculateTotalLength() {
        double totalLength = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            totalLength += calculateDistance(points.get(i), points.get(i + 1));
        }
        return totalLength;
    }

    protected double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    @Override
    public String toString() {
        return "Ломаная: " + points.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Проверка на идентичность
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на тип

        Polyline polyline = (Polyline) obj;
        return points.size() == polyline.points.size() && points.containsAll(polyline.points);
    }

    @Override
    public int hashCode() {
        HashSet<Point> set = new HashSet<>(points);
        return set.hashCode(); // Хэш-код, основанный на уникальных точках
    }
}

public class ClosedPolyline extends Polyline {
    public ClosedPolyline(Point[] points) {
        super(points);
    }

    @Override
    public double calculateTotalLength() {
        double totalLength = super.calculateTotalLength();
        if (points.size() > 1) {
            totalLength += calculateDistance(getLastPoint(), getFirstPoint());
        }
        return totalLength;
    }

    public Point getFirstPoint() {
        return getPoints().get(0);
    }

    public Point getLastPoint() {
        return getPoints().get(getPoints().size() - 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Проверка на идентичность
        if (!(obj instanceof Polyline)) return false; // Проверка на тип и приведение

        Polyline polyline = (Polyline) obj;

        // Проверка для замыкания
        if (polyline instanceof ClosedPolyline) {
            ClosedPolyline closedPolyline = (ClosedPolyline) polyline;
            return points.size() == closedPolyline.getPoints().size()
                    && containsSamePoints(closedPolyline);
        }

        return super.equals(polyline);
    }

    private boolean containsSamePoints(Polyline other) {
        if (this.points.size() != other.getPoints().size()) return false;

        for (int i = 0; i < points.size(); i++) {
            if (points.contains(other.getPoints().get(i))) {
                return true;
            }
        }
        return false; // Вернуть false, если точки не совпадают
    }

    @Override
    public int hashCode() {
        HashSet<Point> set = new HashSet<>(getPoints());
        return set.hashCode(); // Хэш-код, основанный на уникальных точках
    }
}