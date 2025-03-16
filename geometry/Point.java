package ru.Balakireva.geometry;

public class Point {
    private int x; // Координата X
    private int y; // Координата Y

    // Конструктор, инициализирующий координаты
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Конструктор с double параметрами (для совместимости)
    public Point(double x, double y) {
        this.x = (int) x; // Приведение к int
        this.y = (int) y; // Приведение к int
    }

    // Метод для сдвига точки на заданные значения dx и dy
    public void shift(double dx, double dy) {
        this.x += dx; // Сдвигаем по оси X
        this.y += dy; // Сдвигаем по оси Y
    }

    // Геттеры для координат
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Сеттеры для координат
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Метод для возврата текстового представления точки в формате "{X;Y}"
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Проверка на идентичность
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на тип
        Point point = (Point) obj; // Приведение типа
        return x == point.x && y == point.y; // Сравнение координат
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        int result = Integer.hashCode(x); // Хэш-код для x
        result = 31 * result + Integer.hashCode(y); // Хэш-код для y
        return result; // Возврат общего хэш-кода
    }
}