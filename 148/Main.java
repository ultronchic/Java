import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создание городов
        City a = new City("Город A");
        City b = new City("Город B");
        City c = new City("Город C");
        City d = new City("Город D");

        // Создание путей между городами
        a.addPath(b, 10); // Город A в Город B, стоимость 10
        a.addPath(c, 15); // Город A в Город C, стоимость 15
        b.addPath(a, 10); // Город B в Город A, стоимость 10
        b.addPath(c, 12); // Город B в Город C, стоимость 12
        c.addPath(a, 15); // Город C в Город A, стоимость 15
        c.addPath(d, 20); // Город C в Город D, стоимость 20
        d.addPath(b, 25); // Город D в Город B, стоимость 25

        // Выводим информацию о городах и путях
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}