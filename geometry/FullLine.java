package ru.Balakireva.geometry;

// Обобщенный класс Line
public class Line<T extends Point> {
    private T start; // Начальная точка
    private T end;   // Конечная точка

    public Line(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public T getStart() {
        return start;
    }

    public T getEnd() {
        return end;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public void setEnd(T end) {
        this.end = end;
    }

    // Получение длины линии
    public double getLength() {
        int deltaX = end.getX() - start.getX();
        int deltaY = end.getY() - start.getY();

        if (end instanceof Point3D) {
            int deltaZ = ((Point3D) end).getZ() - ((Point3D) start).getZ(); // Если работа с 3D
            return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
        }

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line<?> line = (Line<?>) obj;
        return (start.equals(line.start) && end.equals(line.end)) ||
                (start.equals(line.end) && end.equals(line.start));
    }

    @Override
    public int hashCode() {
        int result = start.hashCode() + end.hashCode();
        return result;
    }
}