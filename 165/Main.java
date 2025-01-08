public class Main {
    public static void main(String[] args) {
        // Создаем пистолет с максимальной вместимостью 7 и 3 патронами на старте
        Pistol pistol = new Pistol(3, 7);

        // Стреляем 5 раз
        for (int i = 0; i < 5; i++) {
            pistol.shoot();
        }

        // Перезаряжаем пистолет 8 патронами
        int returnedBullets = pistol.reload(8);
        System.out.println("Возвращено лишних патронов: " + returnedBullets);

        // Стреляем еще 2 раза
        for (int i = 0; i < 2; i++) {
            pistol.shoot();
        }

        // Разряжаем пистолет
        int dischargedBullets = pistol.discharge();
        System.out.println("Разряжено патронов: " + dischargedBullets);

        // Проверка на контрольный выстрел
        pistol.shoot(); // Должно вывести "Клац!"
    }
}