public class Main {
    public static void main(String[] args) {
        // Создаем людей
        Person ivan = new Person("Иван");
        Person petya = new Person(ivan, new Name("Петр", null, null));
        Person boris = new Person(petya, new Name("Борис", null, null));

        // Выводим строковое представление всех троих людей
        System.out.println(ivan); // Иван
        System.out.println(petya); // Петр Чудов
        System.out.println(boris); // Борис Петров-ович
    }
}