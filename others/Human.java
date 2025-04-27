package ru.Balakireva.others;
package ru.Balakireva.models;
import ru.Balakireva.others.Validate;

public class Human {
    private int age;

    public Human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human {age=" + age + "}";
    }
}
@Validate(value = {HumanTests.class}) // Указываем, что класс Human должен проходить тесты из HumanTests
public class Human {
}
//Задача 9.3.4
@Validate(value = {"checkAge"}) // Указываем правило проверки возраста
public class Human {
    private int age;


}