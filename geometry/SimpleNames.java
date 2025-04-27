package ru.ermakov.geometry;

public class Point {
    private int x;
    private int y;
    private String color;
    private int size;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = "black"; // Значение по умолчанию
        this.size = 1; // Значение по умолчанию
    }

    public Point(int x, int y, String color, int size) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
    }

    public void shift(double deltaX, double deltaY) {
        this.x += (int) deltaX;
        this.y += (int) deltaY;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public String getColor() { return color; }
    public int getSize() { return size; }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}, Color: " + color + ", Size: " + size;
    }
}

public class Point3D extends Point {
    private int z; // Координата Z

    public Point3D(int x, int y, int z) {
        super(x, y); // Вызываем конструктор родительского класса
        this.z = z;
    }

    public Point3D(int x, int y, int z, String color, int size) {
        super(x, y, color, size); // Вызываем конструктор родительского класса
        this.z = z;
    }

    public void shift(double deltaX, double deltaY, double deltaZ) {
        super.shift(deltaX, deltaY); // Сдвиг по X и Y
        this.z += (int) deltaZ; // Сдвигаем по оси Z
    }

    public int getZ() { return z; }
    public void setZ(int z) { this.z = z; }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}, Color: " + getColor() + ", Size: " + getSize();
    }
}