package ru.Balakireva.geometry;

// Базовый класс Point 6
public class Point {
    private int x; // Координата X
    private int y; // Координата Y

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}

// Класс Point3D, наследующий Point
class Point3D extends Point {
    private int z; // Координата Z

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Point3D{" + "x=" + getX() + ", y=" + getY() + ", z=" + z + '}';
    }
}

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
            int deltaZ = ((Point3D) end).getZ() - ((Point3D) start).getZ();
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
    // Метод для сдвига начальной точки линии
    public static <T extends Point> void shiftLine(Line<T> line) {
        T startPoint = line.getStart();
        startPoint.setX(startPoint.getX() + 10); // Сдвигаем X на 10
        line.setStart(startPoint); // Устанавливаем новую начальную точку в линию
    }
}