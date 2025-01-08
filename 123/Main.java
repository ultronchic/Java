public class Main {
    public static void main(String[] args) {
        // Создание людей
        Person ivan = new Person(new Name("Чудов", "Иван", null), null);
        Person petr = new Person(new Name("Чудов", "Петр", null), ivan);
        Person boris = new Person(new Name(null, "Борис", null), petr);

        // Вывод строкового представления всех людей
        System.out.println(ivan);
        System.out.println(petr);
        System.out.println(boris);
    }
}