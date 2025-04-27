package ru.Balakireva.people;

import ru.Balakireva.exceptions.InvalidGradeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Student {
    private String name;
    private List<Integer> grades;
    private GradeValidator gradeValidator;

    // Конструктор
    public Student(String name, GradeValidator gradeValidator, Integer... grades) {
        this.name = name;
        this.grades = new ArrayList<>();
        this.gradeValidator = gradeValidator;

        for (int grade : grades) {
            addGrade(grade); // Используем метод `addGrade` для проверки оценки
        }
    }

    public Student(String name, Integer... grades) {
        this(name, null, grades); // Если валидатор не указан, используем null
    }

    // Метод для добавления оценки с проверкой на корректность
    public void addGrade(int grade) {
        if (gradeValidator != null && !gradeValidator.isValid(grade)) {
            throw new IllegalArgumentException("Оценка " + grade + " не является допустимой.");
        }
        grades.add(grade);
    }

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

    public boolean isHonorStudent() {
        for (int grade : grades) {
            if (grade < 5) { // Если есть хоть одна оценка меньше 5, то не отличник
                return false;
            }
        }
        return true; // Все оценки отлично
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades); // Возвращаем копию списка оценок
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Проверка на идентичность
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на тип

        Student other = (Student) obj; // Приведение к Student
        return name.equals(other.name) && Double.compare(getAverageGrade(), other.getAverageGrade()) == 0;
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, getAverageGrade());
    }

    // Метод для преобразования строковых значений в список студентов
    public static List<Student> convert(List<String> constructorArgs, List<String> addArgs) {
        List<Student> students = new ArrayList<>();
        for (String args : constructorArgs) {
            String[] parts = args.split(",");
            String name = parts[0].trim();
            GradeValidator validator = new SimpleGradeValidator(); // Используем валидатор по умолчанию
            try {
                Student student = new Student(name, validator);
                students.add(student);
            } catch (IllegalArgumentException e) {
                System.out.println("Студента " + name + " создать невозможно");
                return students; // Возвращаем текущий список студентов
            }
            // Добавляем оценки
            for (String argsAdd : addArgs) {
                String[] parts = argsAdd.split(",");
                String nameAdd = parts[0].trim();
                int grade = Integer.parseInt(parts[1].trim());
                for (Student student : students) {
                    if (student.getName().equals(nameAdd)) {
                        try {
                            student.addGrade(grade);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Ошибка при добавлении оценки для студента " + nameAdd + ": " + e.getMessage());
                            return convert(constructorArgs, new ArrayList<>()); // Повторный вызов с пустым списком оценок
                        }
                    }
                }
            }
            return students;
        }
        return students; // Возврат списка студентов в случае, если пустой
    }
}
// Student.java 9.2.4
public class Student implements Comparable<Student> {
    private String name;       // Имя студента
    private List<Integer> grades; // Список оценок
    private double averageGrade; // Средняя оценка студента

    // Конструктор
    public Student(String name, double averageGrade, Predicate<Integer> range) {
        if (!range.test((int) averageGrade)) {
            throw new IllegalArgumentException("Средняя оценка должна быть в диапазоне от 2 до 5");
        }
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
        return Double.compare(this.averageGrade, other.averageGrade);
    }

    @Override
    public String toString() {
        return "Студент{" +
                "name='" + name + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }
    // Student.java 9.2.5
package ru.Balakireva.people;
import java.util.List;
import java.util.function.Predicate;

        // Конструктор
        public Student(String name, List<Integer> grades, Predicate<Integer> range) {
            this.name = name;
            if (grades != null) {
                for (Integer grade : grades) {
                    if (!range.test(grade)) {
                        throw new IllegalArgumentException("Оценка " + grade + " не в диапазоне от 2 до 5");
                    }
                }
                this.grades = grades;
                this.averageGrade = calculateAverage(grades);
            } else {
                this.grades = List.of(); // Пустой список оценок
                this.averageGrade = 0.0; // Средняя оценка по умолчанию
            }
        }

        private double calculateAverage(List<Integer> grades) {
            return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        }

        public String getName() {
            return name;
        }

        public List<Integer> getGrades() {
            return grades;
        }

        public double getAverageGrade() {
            return averageGrade;
        }

        @Override
        public int compare(Student other) {
            return Double.compare(this.averageGrade, other.averageGrade);
        }

        @Override
        public String toString() {
            return "Студент{" +
                    "name='" + name + '\'' +
                    ", grades=" + grades +
                    ", averageGrade=" + averageGrade +
                    '}';
        }
    }
}