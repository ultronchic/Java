public class Main {
    public static void main(String[] args) {
        // 1. Создаем студента Васю с оценками: 3, 4, 5
        int[] vasyaGrades = {3, 4, 5};
        Student vasya = new Student("Вася", vasyaGrades);

        // 2. Создаем студента Петю и копируем оценки Васи
        Student petya = new Student("Петя", vasya.getGrades());

        // 3. Заменяем первую оценку Пети на 5 и выводим на экран
        petya.setGrade(0, 5);

        System.out.println(vasya); // Должен показать оценку: [3, 4, 5]
        System.out.println(petya);  // Должен показать оценку: [5, 4, 5]

        // 4. Создаем студента Андрея и копируем ему оценки Васи
        Student andrey = new Student("Андрей", vasya.getGrades());

        // Модифицируем оценки Васи
        vasya.setGrade(0, 2); // Заменяем оценку 3 на 2

        // Выводим на экран оценки
        System.out.println(vasya); // Должен показать оценку: [2, 4, 5]
        System.out.println(andrey); // Должен показать оценку: [3, 4, 5]
    }
}