package ru.Balakireva.geometry;

public class Line {
    private Point start; // Начальная точка
    private Point end; // Конечная точка

    // Конструктор для инициализации линии
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

    // Переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Проверка на идентичность
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на тип

        Line line = (Line) obj; // Приведение типа
        return (start.equals(line.start) && end.equals(line.end)) ||
                (start.equals(line.end) && end.equals(line.start)); // Сравнение
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        // Используем уникальные хэш-коды точек и комбинируем их
        int result = start.hashCode() + end.hashCode();
        // Поменять порядок суммирования, чтобы учесть взаимное равенство
        return result;
    }

    // Конструктор для инициализации линии по координатам
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point((int)x1, (int)y1);
        this.end = new Point((int)x2, (int)y2);
    }
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
