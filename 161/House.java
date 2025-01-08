class House {
    private final int floors; // Количество этажей

    // Конструктор для создания дома с заданным количеством этажей
    public House(int floors) {
        if (floors <= 0) {
            throw new IllegalArgumentException("Количество этажей должно быть положительным");
        }
        this.floors = floors;
    }

    // Метод для получения текстового представления дома
    public String getDescription() {
        return "Дом с " + floors + " " + getFloorEnding(floors) + ".";
    }

    // Метод для получения правильного окончания слова "этаж" в зависимости от количества этажей
    private String getFloorEnding(int floors) {
        if (floors % 10 == 1 && floors % 100 != 11) {
            return "этажем"; // 1 этаж
        } else if (floors % 10 >= 2 && floors % 10 <= 4 && (floors % 100 < 10 || floors % 100 >= 20)) {
            return "этажа"; // 2, 3, 4 этажа
        } else {
            return "этажей"; // 0, 5-9 и 11-19 этажей
        }
    }

    // Метод для получения количества этажей
    public int getFloors() {
        return floors;
    }
}