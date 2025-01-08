public class Student {
    private String name;
    private int[] grades;

    // Конструктор
    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades.clone(); // Клонируем массив оценок
    }

    // Метод для получения текстового представления студента
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + ": [");
        for (int i = 0; i < grades.length; i++) {
            sb.append(grades[i]);
            if (i < grades.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Метод для получения оценок
    public int[] getGrades() {
        return grades.clone(); // Возвращаем клон массива оценок
    }

    // Метод для изменения оценки
    public void setGrade(int index, int value) {
        if (index >= 0 && index < grades.length) {
            grades[index] = value;
        }
    }
}