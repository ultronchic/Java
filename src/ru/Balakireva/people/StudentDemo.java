package ru.Balakireva.people;

public class StudentDemo {
    public static void main(String[] args) {
        // Вася: позволяет только 0 и 1
        Student vasya = new Student("Вася", new ZeroOneValidator(), 1, 0, 1);
        System.out.println(vasya.getName() + " оценки: " + vasya.getGrades() + ", средняя: " + vasya.getAverageGrade());

        // Петя: позволяет любые четные числа
        Student petya = new Student("Петя", new EvenNumberValidator(), 2, 4, 6);
        System.out.println(petya.getName() + " оценки: " + petya.getGrades() + ", средняя: " + petya.getAverageGrade());
    }
}