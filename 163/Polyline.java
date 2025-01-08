import java.util.ArrayList;

class Polyline {
    private final ArrayList<Point> points;

    public Polyline() {
        points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public double calculateTotalLength() {
        double totalLength = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            totalLength += calculateDistance(points.get(i), points.get(i + 1));
        }
        return totalLength;
    }

    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}