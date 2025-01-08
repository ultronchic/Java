import java.util.ArrayList;
import java.util.List;

class Polyline {
    private List<Point> points; // Список точек

    // Конструктор без параметров
    public Polyline() {
        points = new ArrayList<>();
    }

    // Конструктор с набором точек
    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    // Метод для добавления новых точек
    public void addPoints(Point... newPoints) {
        for (Point point : newPoints) {
            points.add(point);
        }
    }

    // Метод для вычисления общей длины ломаной
    public double getLength() {
        double length = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += calculateDistance(points.get(i), points.get(i + 1));
        }
        return length;
    }

    // Метод для вычисления расстояния между двумя точками
    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    // Метод для получения текстового представления ломаной
    @Override
    public String toString() {
        return "Линия " + points.toString();
    }
}