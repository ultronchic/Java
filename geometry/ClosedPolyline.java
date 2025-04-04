package ru.Balakireva.geometry;

public ClosedPolyline getPolyline() {
    Point[] points = new Point[5];
    points[0] = topLeft;
    points[1] = new Point(topLeft.getX() + sideLength, topLeft.getY());
    points[2] = new Point(topLeft.getX() + sideLength, topLeft.getY() + sideLength);
    points[3] = new Point(topLeft.getX(), topLeft.getY() + sideLength);
    points[4] = points[0]; // Замыкаем ломаную линию
    return new ClosedPolyline(points);
}