class Square {
    private final Point topLeft; // Левый верхний угол
    private int sideLength; // Длина стороны

    public Square(Point topLeft, int sideLength) {
        validateSideLength(sideLength);
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        validateSideLength(sideLength);
        this.sideLength = sideLength;
    }

    private void validateSideLength(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительным числом.");
        }
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }
}