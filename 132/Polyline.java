public class Polyline {
    private Point[] points;

    // Конструктор
    public Polyline(Point[] points) {
        this.points = points;
    }

    // Метод для строки
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i].toString());
            if (i < points.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Метод для сдвига всех точек на заданное количество по x и y
    public void shift(double deltaX, double deltaY) {
        for (Point point : points) {
            point.shift(deltaX, deltaY); // Добавим метод shift в класс Point
        }
    }

    // Метод для получения первой и последней точки
    public Point getFirstPoint() {
        return points[0];
    }

    public Point getLastPoint() {
        return points[points.length - 1];
    }
}