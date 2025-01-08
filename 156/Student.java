import java.util.Arrays;

class Student {
    private String name; // Имя студента
    private int[] grades; // Оценки студента

    // Конструктор, принимающий имя и набор оценок
    public Student(String name, int... grades) {
        this.name = name;
        this.grades = grades != null ? Arrays.copyOf(grades, grades.length) : new int[0];
    }

    // Метод для получения текстового представления студента
    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }

    // Метод для вычисления средней оценки
    public double getAverageGrade() {
        if (grades.length == 0) {
            return 0.0; // Если оценок нет
        }
        double total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return total / grades.length;
    }

    // Метод для проверки, является ли студент отличником
    public boolean isHonorStudent() {
        if (grades.length == 0) {
            return false; // Нет оценок
        }
        for (int grade : grades) {
            if (grade != 5) {
                return false; // Если хотя бы одна оценка не "отлично"
            }
        }
        return true; // Все оценки "отлично"
    }

    // Метод для изменения оценок (для примера)
    public void setGrades(int... newGrades) {
        this.grades = Arrays.copyOf(newGrades, newGrades.length);
    }

    // Метод для копирования оценок (глубокое копирование)
    public void copyGradesFrom(Student anotherStudent) {
        this.grades = Arrays.copyOf(anotherStudent.grades, anotherStudent.grades.length);
    }

    // Получение оценок
    public int[] getGrades() {
        return Arrays.copyOf(grades, grades.length);
    }
}