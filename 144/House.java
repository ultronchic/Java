public class House {
    private final int floors; // Количество этажей

    // Конструктор, который принимает количество этажей
    public House(int floors) {
        if (floors <= 0) {
            throw new IllegalArgumentException("Количество этажей должно быть положительным.");
        }
        this.floors = floors;
    }

    // Метод для получения текстового представления дома
    @Override
    public String toString() {
        return "Дом с " + floors + " " + getFloorEnding(floors) + ".";
    }

    // Метод для получения правильного окончания слова "этаж" в зависимости от количества этажей
    private String getFloorEnding(int floors) {
        if (floors % 10 == 1 && floors % 100 != 11) {
            return "этажом";
        } else if ((floors % 10 >= 2 && floors % 10 <= 4) && (floors % 100 < 10 || floors % 100 >= 20)) {
            return "этажами";
        } else {
            return "этажей";
        }
    }

    // Метод для получения количества этажей (только для чтения)
    public int getFloors() {
        return floors;
    }
}