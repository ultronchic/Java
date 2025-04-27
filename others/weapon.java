package ru.Balakireva.others;
// Абстрактный класс Weapon
abstract class Weapon {
    private int ammo; // Количество патронов

    public Weapon(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Количество патронов не может быть отрицательным.");
        }
        this.ammo = ammo;
    }

    // Абстрактный метод для стрельбы
    abstract void shoot();

    // Метод для получения текущего количества патронов
    public int getAmmo() {
        return ammo;
    }

    // Метод для выстрела, который уменьшает количество патронов
    public boolean fire() {
        if (ammo == 0) {
            return false; // Нет патронов
        }
        ammo--; // Уменьшаем количество патронов
        return true;
    }

    // Метод для дозарядки патронов
    public int load(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Количество патронов не может быть отрицательным.");
        }
        int previousAmmo = this.ammo; // Сохранение прежнего количества патронов
        this.ammo += ammo; // Увеличение количества патронов
        return previousAmmo; // Возвращаем прежнее количество
    }
}

// Класс для пистолета
class Pistol extends Weapon {
    private final int maxBullets; // Максимальное количество патронов

    // Конструктор с указанием начального количества патронов и максимального
    public Pistol(int initialBullets, int maxBullets) {
        super(initialBullets); // Инициализация базового класса
        if (initialBullets < 0 || initialBullets > maxBullets) {
            throw new IllegalArgumentException("Некорректное количество патронов.");
        }
        this.maxBullets = maxBullets;
    }

    // Конструктор без указания начального количества патронов
    public Pistol(int maxBullets) {
        this(5, maxBullets); // По умолчанию 5 патронов
    }

    // Метод для стрельбы
    @Override
    public void shoot() {
        if (fire()) {
            System.out.println("Бах!");
        } else {
            System.out.println("Клац!");
        }
    }

    // Метод для перезарядки
    public int reload(int bullets) {
        return load(bullets); // Вызываем метод загрузки из базового класса
    }

    // Метод для разрядки пистолета
    public int discharge() {
        int discharged = getAmmo();
        load(-discharged); // Разряжаем пистолет
        return discharged; // Возвращаем количество патронов, которые были в пистолете
    }

    // Геттер для максимального количества патронов
    public int getMaxBullets() {
        return maxBullets;
    }

    // Метод для проверки, заряжен ли пистолет
    public boolean isLoaded() {
        return getAmmo() > 0;
    }
}

// Класс для автоматического пистолета
public class Automatic extends Weapon {

    public Automatic(int ammo) {
        super(ammo);
    }

    @Override
    void shoot() {
        if (fire()) {
            System.out.println("Выстрел из автомата. Осталось патронов: " + getAmmo());
        } else {
            System.out.println("Патронов нет. Автомат не стреляет.");
        }
    }
}
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

// Пример использования
/* public class Main {
    public static void main(String[] args) {
        Pistol pistol = new Pistol(10, 10);
        pistol.shoot();
        System.out.println("Текущие патроны: " + pistol.getAmmo());

        pistol.reload(5);
        System.out.println("Патронов после перезарядки: " + pistol.getAmmo());

        Automatic automatic = new Automatic(45, 15);
        automatic.shoot();
        automatic.shootForSeconds(2);
        System.out.println("Текущие патроны после стрельбы: " + automatic.getAmmo());
    }
 */
}
