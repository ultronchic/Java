import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> connections; // Связанные города и стоимость поездки

    // Конструктор
    public City(String name) {
        this.name = name;
        this.connections = new HashMap<>();
    }

    // Метод для добавления пути к следующему городу
    public void addRoute(City city, int cost) {
        connections.put(city, cost);
    }

    // Метод для получения текстового представления города
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " -> ");
        for (Map.Entry<City, Integer> entry : connections.entrySet()) {
            sb.append(entry.getKey().getName()).append(": ").append(entry.getValue()).append(", ");
        }
        // Удаляем последнюю запятую и пробел
        if (sb.length() > 4) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    // Геттер для имени города
    public String getName() {
        return name;
    }
}
