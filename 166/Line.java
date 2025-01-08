class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Точки не могут быть null");
        }
        this.start = start;
        this.end = end;
        // Проверка для уникальности точек
        if (start == end) {
            throw new IllegalArgumentException("Линия не может иметь одинаковые точки начала и конца");
        }
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public void setStart(Point start) {
        if (start == null) {
            throw new IllegalArgumentException("Начальная точка не может быть null");
        }
        this.start = start;
    }

    public void setEnd(Point end) {
        if (end == null) {
            throw new IllegalArgumentException("Конечная точка не может быть null");
        }
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}