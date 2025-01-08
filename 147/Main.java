public class Main {
    public static void main(String[] args) {
        // 1. Создание студента Вася с оценками: 3, 4, 5
        Student vasya = new Student("Вася", 3, 4, 5);
        System.out.println(vasya); // Выводим информацию о Васе

        // 2. Создание студента Максим без оценок
        Student maxim = new Student("Максим");
        System.out.println(maxim); // Выводим информацию о Максиме

        // 5. Создание студента Петя и копирование оценок Васи
        Student petya = new Student("Петя", vasya.getGrades());
        petya.replaceFirstGrade(5); // Заменяем первую оценку Пети на 5
        System.out.println(vasya); // Выводим информацию о Васе
        System.out.println(petya);  // Выводим информацию о Пете

        // 8. Создаем студента Андрея и копируем оценки Васи без влияния
        Student andrey = new Student("Андрей", vasya.getGrades());
        andrey.replaceFirstGrade(4); // Заменяем первую оценку Андрея на 4
        System.out.println(vasya); // Выводим информацию о Васе
        System.out.println(andrey);  // Выводим информацию о Андрее
    }
}