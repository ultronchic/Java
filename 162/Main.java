public class Main {
    public static void main(String[] args) {
        // Создаем имена
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Александр", "Пушкин", "Сергеевич");
        Name name3 = new Name("Владимир", "Маяковский");
        Name name4 = new Name("Христофор", "Бонифатьевич");

        // Выводим имена на экран
        System.out.println(name1); // Клеопатра
        System.out.println(name2); // Пушкин Александр Сергеевич
        System.out.println(name3); // Маяковский Владимир
        System.out.println(name4); // Бонифатьевич Христофор
    }
}