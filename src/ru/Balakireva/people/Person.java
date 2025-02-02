package ru.Balakireva.people;

public class Person {
    private Name name;
    private Person father;

    public Person(String firstName) {
        this.name = new Name(firstName, null, null);
    }

    // Другие конструкторы и методы...

    @Override
    public String toString() {
        return name.getFirstName(); // Упрощенное возвращение имени
    }
}

class Person {
    private Name name;
    private Person father;

    public Person(String firstName) {
        this.name = new Name(firstName, null, null);
    }

    public Person(Name name) {
        this.name = name;
    }

    public Person(String fatherName, String firstName) {
        this.father = new Person(fatherName);
        this.name = new Name(firstName, null, null);
    }

    public Person(Name fatherName, String firstName) {
        this.father = new Person(fatherName);
        this.name = new Name(firstName, null, null);
    }

    public Person(Person father, String firstName) {
        this.father = father;
        this.name = new Name(firstName, null, null);
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public String getPatronymic() {
        if (name.getPatronymic() != null) {
            return name.getPatronymic();
        } else if (father != null && father.getFirstName() != null) {
            return father.getFirstName() + "-ович"; // Пример для отца
        }
        return null;
    }

    public String getLastName() {
        if (name.getLastName() != null) {
            return name.getLastName();
        } else if (father != null) {
            return father.getLastName(); // Получение фамилии отца
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFirstName());
        if (getPatronymic() != null) {
            sb.append(" ").append(getPatronymic());
        }
        if (getLastName() != null) {
            sb.append(" ").append(getLastName());
        }
        return sb.toString().trim();
    }
}