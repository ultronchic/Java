public class Pistol {
    private int bullets; // Количество патронов

    // Конструктор для инициализации количества патронов
    public Pistol(int bullets) {
        this.bullets = bullets;
    }

    // Конструктор по умолчанию, который создает пистолет с 5 патронами
    public Pistol() {
        this.bullets = 5;
    }

    // Метод для стрельбы
    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--; // Уменьшаем количество патронов на 1
        } else {
            System.out.println("Клац!");
        }
    }

    public static void main(String[] args) {
        // Создаем пистолет с 3 патронами
        Pistol pistol = new Pistol(3);

        // Стреляем 5 раз
        for (int i = 0; i < 5; i++) {
            pistol.shoot();
        }
    }
}