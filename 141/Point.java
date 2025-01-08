public class Point {
    private int x; // Координата X
    private int y; // Координата Y

    // Конструктор, который требует указание координат
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Метод для получения текстового представления точки
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Метод для сдвига точки
    public void shift(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
}
