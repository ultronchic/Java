package ru.Balakireva.others;

public class HumanTests {

    public static void test1(Human human) throws ValidateException {
        if (human.getAge() < 1 || human.getAge() > 200) {
            throw new ValidateException("Ошибка в test1: возраст человека не в диапазоне от 1 до 200");
        }
    }
}