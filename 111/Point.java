public class Point {
    private int x; // Координата X
    private int y; // Координата Y

    // Конструктор, инициализирующий координаты
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Метод для возврата текстового представления точки в формате "{X;Y}"
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
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
}