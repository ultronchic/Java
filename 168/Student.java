import java.util.ArrayList;
import java.util.List;

class Student {
    private String name; // Имя студента
    private List<Integer> grades; // Список оценок

    // Конструктор для создания студента с именем и оценками
    public Student(String name, Integer... initialGrades) {
        this.name = name;
        this.grades = new ArrayList<>();
        for (Integer grade : initialGrades) {
            addGrade(grade); // Добавляем оценки через метод добавления
        }
    }

    // Метод для добавления оценки с проверкой диапазона
    public void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5.");
        }
        grades.add(grade);
    }

    // Получить список оценок
    public List<Integer> getGrades() {
        return new ArrayList<>(grades); // Возвращаем копию списка оценок
    }

    // Вычислить среднюю оценку
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0; // Если оценок нет, возвращаем 0
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size(); // Среднее значение
    }

    // Проверка, является ли студент отличником
    public boolean isExcellent() {
        if (grades.isEmpty()) return false; // Нет оценок
        for (int grade : grades) {
            if (grade < 5) return false; // Если есть хоть одна неотличная оценка
        }
        return true; // Все оценки отличные
    }

    // Метод для получения текстового представления студента
    @Override
    public String toString() {
        return name + ": " + grades.toString();
    }
}