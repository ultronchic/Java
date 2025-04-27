package ru.Balakireva.geometry;
import java.util.HashMap;
import java.util.Map;

// Обобщенный класс Box
class Box<T> {
    private T item; // Храним объект типа T

    // Метод для добавления объекта в коробку
    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена. Сначала извлеките объект.");
        }
        this.item = item; // Помещаем объект в коробку
    }

    // Метод для извлечения объекта из коробки
    public T get() {
        T tempItem = this.item; // Сохраняем ссылку на текущий объект
        this.item = null; // Обнуляем ссылку
        return tempItem; // Возвращаем объект
    }

    // Метод проверки на заполненность
    public boolean isEmpty() {
        return this.item == null; // Возвращаем true, если коробка пуста
    }
}

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

    // Геттеры и сеттеры
    public int getX() { return x; }
    public int getY() { return y; }
    public String getColor() { return color; }
    public int getSize() { return size; }

    // Метод для возвращения текстового представления точки
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
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

    // Метод для возвращения текстового представления трехмерной точки
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}

