public class Point {
    private double x;
    private double y;

    // Конструктор
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Метод для строки
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Сдвиг точки
    public void shift(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
}