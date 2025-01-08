import java.util.ArrayList;
import java.util.List;

class Square {
    private Point topLeft;
    private int sideLength;

    public Square(Point topLeft, int sideLength) {
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    public Square(int x, int y, int sideLength) {
        this.topLeft = new Point(x, y);
        this.sideLength = sideLength;
    }

    public Polyline toPolyline() {
        List<Point> corners = new ArrayList<>();
        corners.add(topLeft);
        corners.add(new Point(topLeft.getX() + sideLength, topLeft.getY()));
        corners.add(new Point(topLeft.getX() + sideLength, topLeft.getY() + sideLength));
        corners.add(new Point(topLeft.getX(), topLeft.getY() + sideLength));
        corners.add(topLeft); // Замыкание

        return new Polyline(corners);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }
}