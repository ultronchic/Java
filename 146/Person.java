public class Person {
    private final Name name;
    private final Person father; // Отец

    // Конструктор, когда только имя в виде строки
    public Person(String firstName) {
        this(new Name(firstName, null, null), null);
    }

    // Конструктор, когда только имя в виде объекта Name
    public Person(Name name) {
        this(name, null);
    }

    // Конструктор с отцом и именем в виде строки
    public Person(String firstName, Person father) {
        this(new Name(firstName, father != null ? father.getName().getLastName() : null, null), father);
    }

    // Конструктор с отцом и именем в виде объекта Name
    public Person(Name name, Person father) {
        this.name = name;
        this.father = father;
    }

    public Name getName() {
        return name;
    }

    public Person getFather() {
        return father;
    }

    @Override
    public String toString() {
        String lastName = name.getLastName();
        String patronymic = name.getPatronymic();
        if (patronymic.isEmpty() && father != null && father.getName().getFirstName() != null) {
            patronymic = father.getName().getFirstName() + "-ович";
        }

        if (lastName.isEmpty() && father != null && !father.getName().getLastName().isEmpty()) {
            lastName = father.getName().getLastName();
        }

        return String.format("%s %s %s", name.getFirstName(), lastName, patronymic).trim();
    }
}