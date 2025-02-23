package ru.Balakireva.geometry;

import java.util.List;
import java.util.ArrayList;

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
        // Строковое представление ломаной
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
}
