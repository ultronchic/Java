public class Main {
    public static void main(String[] args) {
        // Создаем точки {1, 1} и {10, 15}
        Point startPoint = new Point(1, 1);
        Point endPoint = new Point(10, 15);

        // Создаем линию из этих точек
        Line line = new Line(startPoint, endPoint);

        // Выводим длину линии
        System.out.println("Длина линии: " + line.getLength());
    }
}