public class House {
    private int floors; // Количество этажей

    // Конструктор для инициализации количества этажей
    public House(int floors) {
        this.floors = floors;
    }

    // Метод для возврата текстового представления дома
    @Override
    public String toString() {
        String floorWord;
        if (floors % 10 == 1 && floors % 100 != 11) {
            floorWord = "этаж";
        } else if ((floors % 10 >= 2 && floors % 10 <= 4) && (floors % 100 < 10 || floors % 100 >= 20)) {
            floorWord = "этажа";
        } else {
            floorWord = "этажей";
        }
        return "Дом с " + floors + " " + floorWord;
    }

    public static void main(String[] args) {
        // Создаем объекты домов
        House house1 = new House(1);
        House house2 = new House(5);
        House house3 = new House(23);

        // Выводим текстовое представление домов на экран
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);
    }
}