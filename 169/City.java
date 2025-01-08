import java.util.HashMap;
import java.util.Map;

class City {
    private String name; // Название города
    private Map<City, Integer> roads; // Пара "город - стоимость"

    // Конструктор города
    public City(String name) {
        this.name = name;
        this.roads = new HashMap<>(); // Инициализация дороги
    }

    // Метод для добавления или обновления дороги
    public void addRoad(City city, int cost) {
        roads.put(city, cost); // Добавляем или обновляем стоимость дороги
    }

    // Метод для удаления дороги
    public void removeRoad(City city) {
        roads.remove(city); // Удаляем дорогу
    }

    // Метод для получения списка дорог
    public Map<City, Integer> getRoads() {
        return new HashMap<>(roads); // Возвращаем копию дорог
    }

    // Текстовое представление города
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + ": ");
        roads.forEach((city, cost) ->
                sb.append(city.getName()).append(": ").append(cost).append(" km, ")
        );
        if (roads.isEmpty()) {
            sb.append("нет дорог.");
        } else {
            sb.delete(sb.length() - 2, sb.length()); // Убираем последнюю запятую
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }
}