public class Student {
    private String name; // Имя
    private int[] grades; // Оценки

    // Конструктор
    public Student(String name, int... grades) {
        this.name = name;
        this.grades = grades.length > 0 ? grades.clone() : new int[0]; // Копируем оценки
    }

    // Метод для получения строкового представления
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Имя: " + name);
        if (grades.length > 0) {
            result.append(", Оценки: [");
            for (int i = 0; i < grades.length; i++) {
                result.append(grades[i]);
                if (i < grades.length - 1) {
                    result.append(", ");
                }
            }
            result.append("]");
        } else {
            result.append(", Оценки: отсутствуют");
        }
        return result.toString();
    }

    // Метод для копирования оценок
    public void setGrades(int[] grades) {
        this.grades = grades.clone(); // Хотя бы для копирования
    }

    // Метод для доступа к оценкам
    public int[] getGrades() {
        return grades.clone(); // Защита от прямого изменения массива
    }

    // Метод для замены оценок
    public void replaceFirstGrade(int newGrade) {
        if (grades.length > 0) {
            grades[0] = newGrade; // Замена первой оценки
        }
    }
}