package ru.Balakireva.others;

public class Pistol extends Weapon {
    public Pistol(int ammo) {
        super(ammo);
    }
    @Override
    void shoot() {
        if (fire()) {
            System.out.println("Выстрел из пистолета. Осталось патронов: " + getAmmo());
        } else {
            System.out.println("Патронов нет. Пистолет не стреляет.");
        }
    }
} {
    private final int maxBullets; // Максимальное количество патронов
    private int currentBullets; // Текущее количество патронов

    // Конструктор с указанием начального количества патронов
    public Pistol(int initialBullets, int maxBullets) {
        if (initialBullets < 0 || initialBullets > maxBullets) {
            throw new IllegalArgumentException("Некорректное количество патронов.");
        }
        this.currentBullets = initialBullets;
        this.maxBullets = maxBullets;
    }

    // Конструктор без указания начального количества патронов, с максимальным количеством
    public Pistol(int maxBullets) {
        this(5, maxBullets); // По умолчанию 5 патронов
    }

    // Метод для стрельбы
    public void shoot() {
        if (currentBullets > 0) {
            System.out.println("Бах!");
            currentBullets--;
        } else {
            System.out.println("Клац!");
        }
    }

    // Метод для перезарядки
    public int reload(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным.");
        }
        int spaceLeft = maxBullets - currentBullets;
        if (bullets > spaceLeft) {
            currentBullets = maxBullets; // Заполняем до максимума
            return bullets - spaceLeft; // Возвращаем лишние патроны
        } else {
            currentBullets += bullets; // Добавляем патроны
            return 0; // Нет лишних патронов
        }
    }

    // Метод для разрядки пистолета
    public int discharge() {
        int discharged = currentBullets;
        currentBullets = 0; // Обнуляем патроны
        return discharged; // Возвращаем количество патронов, которые были в пистолете
    }

    // Геттер для текущего количества патронов
    public int getCurrentBullets() {
        return currentBullets;
    }

    // Геттер для максимального количества патронов
    public int getMaxBullets() {
        return maxBullets;
    }

    // Метод для проверки, заряжен ли пистолет
    public boolean isLoaded() {
        return currentBullets > 0;
    }
}

class Automatic extends Pistol {
    private final int fireRate; // Скорострельность

    // Конструктор по умолчанию
    public Automatic() {
        this(30, 30); // Скорострельность 30, вместимость 30
    }

    // Конструктор с указанием максимального количества патронов
    public Automatic(int maxBullets) {
        this(maxBullets, maxBullets / 2); // Скорострельность в два раза меньше максимума
    }

    // Конструктор с указанием максимального количества патронов и скорострельности
    public Automatic(int maxBullets, int fireRate) {
        super(maxBullets);
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительным числом.");
        }
        this.fireRate = fireRate;
    }

    // Метод для стрельбы в зависимости от скорострельности
    @Override
    public void shoot() {
        for (int i = 0; i < fireRate; i++) {
            super.shoot(); // Вызов метода стрельбы из родительского класса
        }
    }

    // Метод для стрельбы в течение N секунд
    public void shootForSeconds(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным.");
        }
        int totalShots = seconds * fireRate;
        for (int i = 0; i < totalShots; i++) {
            super.shoot(); // Вызов метода стрельбы из родительского класса
        }
    }

    // Геттер для скорострельности
    public int getFireRate() {
        return fireRate;
    }
}

public class Pistol extends Weapon {

    public Pistol(int ammo) {
        super(ammo);
    }

    @Override
    void shoot() {
        if (fire()) {
            System.out.println("Выстрел из пистолета. Осталось патронов: " + getAmmo());
        } else {
            System.out.println("Патронов нет. Пистолет не стреляет.");
        }
    }
}
// Пример использования
//public class Main {
//    public static void main(String[] args) {
//        Automatic automatic = new Automatic(); // Автомат с параметрами по умолчанию
//        automatic.reload(30); // Перезарядка
//        automatic.shoot(); // Стрельба по скорострельности
//        automatic.shootForSeconds(2); // Стрельба в течение 2 секунд
//        System.out.println("Текущие патроны: " + automatic.getCurrentBullets());
//    }
//}