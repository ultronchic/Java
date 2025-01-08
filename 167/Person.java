class Person {
    private final Name name; // Имя
    private final Person father; // Отец

    // Конструкторы
    public Person(String firstName) {
        this.name = new Name(firstName, null, null);
        this.father = null;
    }

    public Person(Name name) {
        this.name = name;
        this.father = null;
    }

    public Person(Person father, String firstName) {
        this.name = new Name(firstName, null, null);
        this.father = father;
    }

    public Person(Person father, Name name) {
        this.name = name;
        this.father = father;
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public Name getName() {
        return name;
    }

    public Person getFather() {
        return father;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name.getFirstName());

        if (name.getLastName() == null && father != null && father.getName().getLastName() != null) {
            result.append(" ").append(father.getName().getLastName());
        }

        if (name.getPatronymic() == null && father != null && father.getName().getFirstName() != null) {
            result.append(" ").append(father.getName().getFirstName()).append("-ович");
        }

        return result.toString();
    }
}