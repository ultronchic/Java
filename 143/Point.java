public class Point {
    private int x; // Координата X
    private int y; // Координата Y

    // Конструктор
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Метод для получения координаты X
    public int getX() {
        return x;
    }

    // Метод для получения координаты Y
    public int getY() {
        return y;
    }

    // Метод для получения текстового представления точки
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Метод для сдвига точки
    public void shift(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}