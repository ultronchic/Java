package ru.Balakireva.people;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> grades;

    // Конструктор
    public Student(String name, Integer... grades) {
        this.name = name;
        this.grades = new ArrayList<>();
        for (int grade : grades) {
            this.grades.add(grade);
        }
    }

    // Метод для расчета средней оценки
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Метод для проверки, является ли студент отличником
    public boolean isHonorStudent() {
        if (grades.isEmpty()) {
            return false;
        }
        for (int grade : grades) {
            if (grade < 5) {
                return false; // Если есть хоть одна оценка меньше 5, то не отличник
            }
        }
        return true; // Все оценки отличные
    }

    // Метод для получения информации о студенте
    public String getName() {
        return name;
    }
}