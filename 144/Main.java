public class Main {
    public static void main(String[] args) {
        // Создание домов с разным количеством этажей
        House house1 = new House(2);
        House house2 = new House(35);
        House house3 = new House(91);

        // Вывод информации о домах
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);

        // Попытка изменить количество этажей (это не возможно, так как поле floors является final)
        // house1.setFloors(3); // Это вызовет ошибку компиляции, так как метод setFloors не существует
    }
}