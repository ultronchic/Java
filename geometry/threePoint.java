package ru.Balakireva.geometry;
import java.util.HashMap;
import java.util.Map;

// Базовый класс для точек
public final class Point {
    private int x; // Координата X
    private int y; // Координата Y
    private String color; // Цвет точки (необязательный)
    private int size; // Размер точки (необязательный)
    private Map<String, String> customFeatures; // Пользовательские характеристики

    // Конструктор, инициализирующий координаты
    public Point(int x, int y) {
        this(x, y, null, 0);
    }

    // Конструктор с дополнительными параметрами
    public Point(int x, int y, String color, int size) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
        this.customFeatures = new HashMap<>();
    }

    // Метод для сдвига точки
    public void shift(double deltaX, double deltaY) {
        this.x += (int)deltaX; // Сдвигаем по оси X, приводим к int
        this.y += (int)deltaY; // Сдвигаем по оси Y, приводим к int
    }

    // Геттеры и сеттеры
    public int getX() { return x; }
    public int getY() { return y; }
    public String getColor() { return color; }
    public int getSize() { return size; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setColor(String color) { this.color = color; }
    public void setSize(int size) { this.size = size; }

    // Метод для добавления пользовательских характеристик
    public void addCustomFeature(String key, String value) {
        customFeatures.put(key, value);
    }

    public String getCustomFeature(String key) {
        return customFeatures.get(key);
    }

    // Метод для возвращения текстового представления точки
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(x).append(";").append(y).append("}");
        if (color != null) {
            sb.append(", Color: ").append(color);
        }
        if (size > 0) {
            sb.append(", Size: ").append(size);
        }
        if (!customFeatures.isEmpty()) {
            sb.append(", Custom Features: ").append(customFeatures);
        }
        return sb.toString();
    }
}

// Класс для трехмерной точки
class Point3D extends Point {
    private int z; // Координата Z

    // Конструктор, инициализирующий все три координаты
    public Point3D(int x, int y, int z) {
        super(x, y); // Вызываем конструктор родительского класса
        this.z = z;
    }

    // Конструктор с дополнительными параметрами
    public Point3D(int x, int y, int z, String color, int size) {
        super(x, y, color, size); // Вызываем конструктор родительского класса
        this.z = z;
    }

    // Метод для сдвига точки
    public void shift(double deltaX, double deltaY, double deltaZ) {
        super.shift(deltaX, deltaY); // Сдвиг по X и Y
        this.z += (int)deltaZ; // Сдвигаем по оси Z
    }

    // Геттер для координаты Z
    public int getZ() { return z; }

    // Сеттер для координаты Z
    public void setZ(int z) { this.z = z; }

    // Метод для возвращения текстового представления трехмерной точки
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}, Color: " + getColor() + ", Size: " + getSize();
    }
}
