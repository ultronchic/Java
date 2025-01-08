public class Main {
    public static void main(String[] args) {
        // Задача 1: Создать людей
        Person lev = new Person("Лев");
        Person pushkinSergey = new Person(new Name("Сергей", "Пушкин", null), lev);
        Person alexander = new Person("Александр", pushkinSergey);

        // Выводим на экран созданных людей
        System.out.println(lev); // Лев
        System.out.println(pushkinSergey); // Сергей Пушкин
        System.out.println(alexander); // Александр Пушкин-ович

        // Задача 4: Создаем людей Чудова Иван, Чудова Петр, Борис
        Person ivan = new Person(new Name("Иван", "Чудов", null));
        Person petr = new Person(new Name("Петр", "Чудов", null), ivan);
        Person boris = new Person("Борис", petr);

        // Установить отцовство
        // Иван стал отцом Петра, а Петр стал отцом Бориса

        // Выводим на экран строковое представление всех троих
        System.out.println(ivan); // Иван Чудов
        System.out.println(petr); // Петр Чудов
        System.out.println(boris); // Борис Петрович
    }
}