public class Main {
    public static void main(String[] args) {
        // Задание 1 и 2: Создание студентов
        Student vasya = new Student("Вася", 3, 4, 5, 4);
        Student petya = new Student("Петя", 5, 5, 5, 5);

        // Вывод информации о среднем балле и статусе отличника
        System.out.println(vasya);
        System.out.println("Средняя оценка Васи: " + vasya.getAverageGrade());
        System.out.println("Является ли Вася отличником? " + vasya.isHonorStudent());

        System.out.println(petya);
        System.out.println("Средняя оценка Пети: " + petya.getAverageGrade());
        System.out.println("Является ли Петя отличником? " + petya.isHonorStudent());

        // Задание 9-11: Копирование оценок
        Student petya2 = new Student("Петя");
        petya2.copyGradesFrom(vasya); // Копируем оценки Васи

        // Заменяем первую оценку Пети на 5
        petya2.setGrades(5, petya2.getGrades()[1], petya2.getGrades()[2]);

        // Вывод на экран строки представления Васи и Пети
        System.out.println(vasya);
        System.out.println(petya2);

        // Задание 12: Копирование оценок для Андрея (глубокое копирование)
        Student andrey = new Student("Андрей");
        andrey.copyGradesFrom(vasya); // Копируем оценки Васи

        // Теперь изменения в Васи не повлияют на Андрея
        vasya.setGrades(5, 5, 5); // Изменяем оценки Васи

        // Вывод на экран оценок Андрея
        System.out.println(andrey);
    }
}