package ru.Balakireva.geometry;
//•	Координата Х: целое число
//•	Координата Y: целое число
public class Point {
    private int x; // Координата X
    private int y; // Координата Y

    // Конструктор, инициализирующий координаты
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // Конструктор
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Метод для сдвига точки на заданные значения dx и dy
    public void shift(double dx, double dy) {
        this.x += dx; // Сдвигаем по оси X
        this.y += dy; // Сдвигаем по оси Y
    }
    // Метод для сдвига точки
    public void shift(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
    // Геттеры для координат  Метод для получения координаты X
    public int getX() {
        return x;
    }
    //Метод для получения координаты Y
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
}
