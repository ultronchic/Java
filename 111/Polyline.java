import java.util.List;
import java.util.ArrayList;

public class Polyline {
    private List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public void shiftAll(double dx, double dy) {
        for (Point point : points) {
            point.shift(dx, dy); // сдвигаем каждую точку
        }
    }

    // Другие методы для работы с полилинией
}