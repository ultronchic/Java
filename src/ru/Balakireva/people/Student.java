package ru.Balakireva.people;
import ru.Balakireva.exceptions.InvalidGradeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    // Остальные методы остаются без изменений
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
             for (String args : addArgs) {
                 String[] parts = args.split(",");
                 String name = parts[0].trim();
                 int grade = Integer.parseInt(parts[1].trim());
                 for (Student student : students) {
                     if (student.getName().equals(name)) {
                         try {
                             student.addGrade(grade);
                         } catch (IllegalArgumentException e) {
                             System.out.println("Ошибка при добавлении оценки для студента " + name + ": " + e.getMessage());
                             return convert(constructorArgs, new ArrayList<>()); // Повторный вызов с пустым списком оценок
                         }
                     }
                 }
             }
             return students;
         }
            }
    }
}