import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points; // Список точек

    // Конструктор без параметров
    public Polyline() {
        points = new ArrayList<>();
    }

    // Конструктор с набором точек
    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    // Метод для добавления точки
    public void addPoint(Point point) {
        points.add(point);
    }

    // Метод для получения текстового представления ломаной
    @Override
    public String toString() {
        return "Линия " + points.toString();
    }

    // Метод для сдвига ломаной
    public void shift(double dx, double dy) {
        for (Point point : points) {
            point.shift(dx, dy);
        }
    }
}