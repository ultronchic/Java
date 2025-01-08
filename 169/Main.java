public class Main {
    public static void main(String[] args) {
        // Создаем города
        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");

        // Добавляем дороги
        cityA.addRoad(cityB, 10); // A -> B
        cityA.addRoad(cityC, 20); // A -> C
        cityB.addRoad(cityD, 5);   // B -> D
        cityC.addRoad(cityD, 15);  // C -> D

        // Обновляем дорогу между A и B
        cityA.addRoad(cityB, 12);  // A -> B (обновление стоимости)

        // Выводим информацию о городах и дорогах
        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println(cityC);
        System.out.println(cityD);

        // Удаляем дорогу
        cityA.removeRoad(cityB); // Удаляем дорогу A -> B

        // Выводим информацию после удаления дороги
        System.out.println("После удаления дороги A -> B:");
        System.out.println(cityA);
    }
}