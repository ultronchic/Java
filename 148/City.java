import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private String name; // Название города
    private Map<City, Integer> paths; // Словарь путей к другим городам и их стоимости

    // Конструктор только с названием
    public City(String name) {
        this.name = name;
        this.paths = new HashMap<>();
    }

    // Конструктор с названием и набором путей
    public City(String name, Map<City, Integer> paths) {
        this.name = name;
        this.paths = new HashMap<>(paths); // Копируем пути
    }

    // Метод для добавления пути
    public void addPath(City destination, int cost) {
        paths.put(destination, cost);
    }

    // Метод для получения строкового представления города и его путей
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Город: ").append(name).append("\nПути:");
        for (Map.Entry<City, Integer> entry : paths.entrySet()) {
            sb.append("\n- ").append(entry.getKey().getName()).append(": ").append(entry.getValue());
        }
        return sb.toString();
    }

    // Геттер для названия города
    public String getName() {
        return name;
    }
}