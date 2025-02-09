package ru.Balakireva.geometry;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    public Point getStart() {
        return start;
    }
    public Point getEnd() {
        return end;
    }
    public void setStart(Point start) {
        this.start = start;
    }
    public void setEnd(Point end) {
        this.end = end;
    }
    public double getLength() {
        int deltaX = end.getX() - start.getX();
        int deltaY = end.getY() - start.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    private double x1, y1, x2, y2;

    // Конструктор для инициализации линии по координатам
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Метод для вычисления длины линии
    public double length() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public String toString() {
        return "Line[(x1=" + x1 + ", y1=" + y1 + "), (x2=" + x2 + ", y2=" + y2 + ")]";
    }

}
