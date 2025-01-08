public class Main {
    public static void main(String[] args) {
        // Создаем людей
        Person ivan = new Person("Иван");                  // Чудов Иван
        Person petr = new Person("Чудов", "Петр");        // Чудов Петр, отец Иван
        Person boris = new Person(petr, "Борис"); // Борис, отец Петр

        // Выводим на экран строковое представление всех троих людей
        System.out.println(ivan);  // Иван
        System.out.println(petr);  // Петр Чудов
        System.out.println(boris); // Борис Чудов
    }
}