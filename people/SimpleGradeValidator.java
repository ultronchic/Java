package ru.Balakireva.people;

import java.util.ArrayList;
import java.util.List;

// Класс, реализующий правила проверки
class SimpleGradeValidator implements GradeValidator {
    @Override
    public boolean isValid(int grade) {
        return grade >= 1 && grade <= 10; // Оценка должна быть в диапазоне от 1 до 10
    }
// Метод для добавления случайных оценок
public class GradeAllocator {

public static String addRandomGrades(List<Student> students) {
   Random random = new Random();

   for (Student student : students) {
   // Генерируем случайную оценку от 1 до 10
   int randomGrade = random.nextInt(10) + 1;

   try {
        student.addGrade(randomGrade);
   } catch (IllegalArgumentException e) {
   // Если у студента недопустимая оценка, возвращаем сообщение об ошибке
   return "Не удалось добавить оценку студенту " + student.getName() + ": " + e.getMessage();
   }
   }
   return "Все оценки успешно добавлены.";
   }

}
   )
}
