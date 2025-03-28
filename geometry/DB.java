package ru.Balakireva.geometry;

import java.util.ArrayList;
import java.util.List;

public class Db {
    private List<String> records;

    public Db() {
        records = new ArrayList<>();
        // Пример данных
        records.add("42"); // индекс 0
        records.add("Point(10, 20)"); // индекс 1
    }

    public <T> T get(int index, Class<T> type) {
        if (index < 0 || index >= records.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        String record = records.get(index);
        return convert(record, type);
    }

    @SuppressWarnings("unchecked")
    private <T> T convert(String record, Class<T> type) {
        if (type == String.class) {
            return (T) record;
        } else if (type == Integer.class) {
            return (T) Integer.valueOf(record);
        } else if (type == Point.class) {
            return (T) parsePoint(record);
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }

    private Point parsePoint(String record) {
        // Пример парсинга строки "Point(10, 20)"
        String[] parts = record.replace("Point(", "").replace(")", "").split(", ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        return new Point(x, y);
    }
}