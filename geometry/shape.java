package ru.Balakireva.geometry;

import java.util.List;
import java.util.ArrayList;

class Square {
    private final Point topLeft;  // Левый верхний угол
    private int sideLength;       // Длина стороны

    public Square(Point topLeft, int sideLength) {
        validateSideLength(sideLength);
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        validateSideLength(sideLength);
        this.sideLength = sideLength;
    }

    private void validateSideLength(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительным числом.");
        }
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }

    public ClosedPolyline toClosedPolyline() {
        // Создаем точки квадрата
        Point[] points = new Point[5]; // 4 угла + 1 для замыкания
        points[0] = topLeft;
        points[1] = new Point(topLeft.getX() + sideLength, topLeft.getY());
        points[2] = new Point(topLeft.getX() + sideLength, topLeft.getY() + sideLength);
        points[3] = new Point(topLeft.getX(), topLeft.getY() + sideLength);
        points[4] = topLeft; // Замыкаем на первую точку

        return new ClosedPolyline(points); // Возвращаем замкнутую ломаную
    }
}