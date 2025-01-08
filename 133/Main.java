public class Main {
    public static void main(String[] args) {
        // Создание городов
        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");

        // Создание меньших городов
        City city1 = new City("1");
        City city2 = new City("2");
        City city3 = new City("3");
        City city4 = new City("4");
        City city5 = new City("5");
        City city6 = new City("6");

        // Добавление путей между большими и малыми городами
        cityA.addRoute(city1, 5); // A -> 1 (длинная связь)
        cityA.addRoute(city2, 10); // A -> 2 (менее сильная связь)
        cityB.addRoute(city3, 3); // B -> 3 (длинная связь)
        cityB.addRoute(city4, 8); // B -> 4 (менее сильная связь)
        cityC.addRoute(city5, 6); // C -> 5 (длинная связь)
        cityD.addRoute(city6, 2); // D -> 6 (длинная связь)

        // Вывод информации о городах
        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println(cityC);
        System.out.println(cityD);
    }
}