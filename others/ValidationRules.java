package ru.Balakireva.others;

public class ValidationRules {

    public static void checkAge(Human human) throws ValidateException {
        if (human.getAge() < 0 || human.getAge() > 150) {
            throw new ValidateException("Возраст должен быть в диапазоне от 0 до 150.");
        }
    }
}