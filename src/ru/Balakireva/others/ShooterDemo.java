package ru.Balakireva.others;

public class ShooterDemo {
    public static void main(String[] args) {
        // Создание стрелков
        Shooter shooterWithoutWeapon = new Shooter("Стрелок без оружия");
        Shooter shooterWithPistol = new Shooter("Стрелок с пистолетом");
        Shooter shooterWithAutomatic = new Shooter("Стрелок с автоматом");

        // Создание оружия
        Pistol pistol = new Pistol(5);
        Automatic automatic = new Automatic(3);

        // Назначаем оружие стрелкам
        shooterWithPistol.setWeapon(pistol);
        shooterWithAutomatic.setWeapon(automatic);

        // Стрельба
        shooterWithoutWeapon.shoot(); // Ожидаемый выход: "не могу участвовать в перестрелке"
        shooterWithPistol.shoot();     // Ожидаемый выход: "Выстрел из пистолета. Осталось патронов: 4"
        shooterWithAutomatic.shoot();   // Ожидаемый выход: "Выстрел из автомата. Осталось патронов: 2"

        // Стрельба еще раз
        shooterWithPistol.shoot();     // Ожидаемый выход: "Выстрел из пистолета. Осталось патронов: 3"
        shooterWithAutomatic.shoot();   // Ожидаемый выход: "Выстрел из автомата. Осталось патронов: 1"
    }
}