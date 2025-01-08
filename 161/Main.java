public class Main {
    public static void main(String[] args) {
        // Создаем дома с 2, 35 и 91 этажами
        House house1 = new House(2);
        House house2 = new House(35);
        House house3 = new House(91);

        // Выводим описание домов на экран
        System.out.println(house1.getDescription());
        System.out.println(house2.getDescription());
        System.out.println(house3.getDescription());

        // Проверяем, что количество этажей нельзя изменить
        // Попробуем создать дом с отрицательным количеством этажей
        try {
            House invalidHouse = new House(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Проверяем, что нельзя изменить количество этажей после создания
        try {
            // На самом деле, здесь невозможна такая операция,
            // но мы можем попытаться это сделать через рефлексию для демонстрации.
            // Компиляция не позволит изменить значение, но мы можем продемонстрировать, что его нет в методах.
            // house1.floors = 10; // Это вызовет ошибку компиляции
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}