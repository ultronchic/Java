import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем ломаную через точки {1;5}, {2;8}, {5;3}
        Polyline polyline = new Polyline(List.of(new Point(1, 5), new Point(2, 8), new Point(5, 3)));
        System.out.println("Длина ломаной: " + polyline.getLength());

        // Добавляем точки {5;15}, {8;10}
        polyline.addPoints(new Point(5, 15), new Point(8, 10));
        System.out.println("Длина ломаной после добавления новых точек: " + polyline.getLength());
    }
}