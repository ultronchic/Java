import java.util.ArrayList;
import java.util.List;

// Класс для представления точки
class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}

// Класс базы данных
class Db {
    private List<String> records;

    public Db() {
        records = new ArrayList<>();
        // Пример данных
        records.add("42"); // индекс 0
        records.add("Point(10,20)"); // индекс 1
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
            // Пример конвертации строки в объект Point
            String[] parts = record.replace("Point(", "").replace(")", "").split(",");
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());
            return (T) new Point(x, y);
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }
}
