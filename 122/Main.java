public class Main {
    public static void main(String[] args) {
        // Создание людей
        Person person1 = new Person(new Name(null, "Клеопатра", null), 152);
        Person person2 = new Person(new Name("Пушкин", "Александр", "Сергеевич"), 167);
        Person person3 = new Person(new Name("Маяковский", "Владимир", null), 189);

        // Вывод информации о людях
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }
}