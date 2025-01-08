public class Main {
    public static void main(String[] args) {
        // 1. Создаем точки
        Point point1 = new Point(5, 3);
        Point point2 = new Point(25, 6);
        Point point3 = new Point(7, 8);

        // Выводим точки на экран
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);

        // 2. Создаем квадрат в точке {5;3} со стороной 23
        Square square = new Square(point1, 23);
        System.out.println(square);

        // 3. Получение ломаной (мы создадим простую ломаную, используя только 4 угла квадрата)
        Polyline polyline = new Polyline();
        polyline.addPoint(point1);
        polyline.addPoint(new Point(point1.getX() + square.getSideLength(), point1.getY()));
        polyline.addPoint(new Point(point1.getX() + square.getSideLength(), point1.getY() + square.getSideLength()));
        polyline.addPoint(new Point(point1.getX(), point1.getY() + square.getSideLength()));
        polyline.addPoint(point1);

        // 4. Выводим общую длину полученной ломаной
        double totalLength = polyline.calculateTotalLength();
        System.out.println("Общая длина ломаной: " + totalLength);

        // 5. Сдвигаем последнюю точку ломаной
        Point lastPoint = new Point(15, 25); // создаем новую точку
        polyline.addPoint(lastPoint); // добавляем новую точку к ломаной

        // 6. Снова выводим длину ломаной
        double newTotalLength = polyline.calculateTotalLength();
        System.out.println("Новая общая длина ломаной: " + newTotalLength);

        // 7. Пробуем изменить длину стороны квадрата
        try {
            square.setSideLength(-5); // это должно вызвать ошибку
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}