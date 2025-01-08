class Pistol {
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