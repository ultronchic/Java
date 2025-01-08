import java.util.ArrayList;
import java.util.List;

class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public double getLength() {
        double length = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            length += calculateDistance(points.get(i), points.get(i + 1));
        }

        return length;
    }

    public void setPoint(int index, Point newPoint) {
        if (index >= 0 && index < points.size()) {
            points.set(index, newPoint);
        }
    }

    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}