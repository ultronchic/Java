package ru.Balakireva.people;

// Интерфейс Comparable
interface Comparable<T> {
    int compare(T other);
}

// Класс Student
class Student implements Comparable<Student> {
    private String name;       // Имя студента
    private double averageGrade; // Средняя оценка студента

    // Конструктор
    public Student(String name, double averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    // Реализация метода compare
    @Override
    public int compare(Student other) {
        if (this.averageGrade > other.averageGrade) {
            return 1; // Текущий студент имеет более высокую среднюю оценку
        } else if (this.averageGrade < other.averageGrade) {
            return -1; // Текущий студент имеет более низкую среднюю оценку
        } else {
            return 0; // Средние оценки равны
        }
    }
}


}