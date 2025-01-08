public class Person {
    private String name; // Имя
    private int height;  // Рост

    // Конструктор для инициализации имени и роста
    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    // Метод для возврата текстового представления человека
    @Override
    public String toString() {
        return name + ", рост: " + height;
    }

    public static void main(String[] args) {
        // Создаем объекты людей
        Person cleopatra = new Person("Клеопатра", 152);
        Person pushkin = new Person("Пушкин", 167);
        Person alexander = new Person("Александр", 189);

        // Выводим текстовое представление людей на экран
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(alexander);
    }
}