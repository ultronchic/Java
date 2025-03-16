package ru.Balakireva.geometry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
        city.roads.put(this, cost); // Добавляем обратную дорогу
    }

    // Метод для удаления дороги
    public void removeRoad(City city) {
        roads.remove(city); // Удаляем дорогу
        city.roads.remove(this); // Удаляем обратную дорогу
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true; // Проверка на идентичность
        if (obj == null || getClass() != obj.getClass())
            return false; // Проверка на тип

        City otherCity = (City) obj;

        // Сравнение дорог без учета стоимости
        Set<City> thisRoads = new HashSet<>(roads.keySet());
        Set<City> otherRoads = new HashSet<>(otherCity.roads.keySet());

        return thisRoads.equals(otherRoads); // Сравнение наборов
    }

    @Override
    public int hashCode() {
        return roads.keySet().hashCode(); // Хэш-код на основе наборов дорог
    }
}

// Класс для двусторонних городов
class BidirectionalCity extends City {

    public BidirectionalCity(String name) {
        super(name);
    }

    @Override
    public void addRoad(City city, int cost) {
        super.addRoad(city, cost); // Добавляем дорогу
        // Обратная дорога автоматически добавляется, ничего делать не нужно
    }
}