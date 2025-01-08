import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем Квадрат в точке {5;3} со стороной 23
        Square square = new Square(new Point(5, 3), 23);
        System.out.println(square);

        // Присваиваем Ломаную, результат вызова метода получения Ломаной у ранее созданного квадрата
        Polyline polyline = square.toPolyline();

        // Выводим на экран общую длину полученной Ломаной
        System.out.println("Длина ломаной: " + polyline.getLength());

        // Сдвигаем последнюю Точку Ломаной в позицию {15,25}
        polyline.setPoint(4, new Point(15, 25));

        // Снова выводим на экран длину Ломаной
        System.out.println("Длина ломаной после сдвига последней точки: " + polyline.getLength());
    }
}