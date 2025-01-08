public class Main {
    public static void main(String[] args) {
        // 1. Создаем студента Васю с оценками 3,4,5
        Student vasya = new Student("Вася", 3, 4, 5);

        // 2. Создаем студента Петю и копируем оценки Васи
        Student petya = new Student("Петя");
        for (int grade : vasya.getGrades()) {
            petya.addGrade(grade); // Добавляем оценки через метод добавления
        }

        // 3. Заменяем первую оценку Пети на 5
        petya.addGrade(5); // Добавляем еще одну 5
        System.out.println(vasya); // Вам нужно добавить текстовое представление Васи
        System.out.println(petya); // Вам нужно добавить текстовое представление Пети

        // Объяснение результата
        System.out.println("Объяснение: Изменение оценок одного студента не влияет на другого, так как у них разные списки оценок.");

        // 4. Создаем студента Андрея и копируем ему оценки Васи, так чтобы изменения не влияли на Андрея
        Student andrey = new Student("Андрей");
        for (int grade : vasya.getGrades()) {
            andrey.addGrade(grade); // Копируем оценки
        }

        // 5. Выводим информацию о средних оценках и отличниках
        Student vasyaTwo = new Student("Василий", 3, 4, 5, 4);
        Student petyaTwo = new Student("Петя", 5, 5, 5, 5);

        System.out.println(vasyaTwo + ", Средняя оценка: " + vasyaTwo.getAverageGrade() + ", Отличник: " + vasyaTwo.isExcellent());
        System.out.println(petyaTwo + ", Средняя оценка: " + petyaTwo.getAverageGrade() + ", Отличник: " + petyaTwo.isExcellent());
    }
}