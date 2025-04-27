package ru.Balakireva.people;

public class Person {
    private String fatherName;
    private Name name;

    // Конструктор с одним параметром (только имя в виде строки)
    public Person(String firstName) {
        this.name = new Name(firstName, "");
    }

    // Конструктор с одним параметром (только имя в виде объекта типа Name)
    public Person(Name name) {
        this.name = name;
    }

    // Конструктор с отцом и именем в виде строки
    public Person(String fatherName, String firstName) {
        this.fatherName = fatherName;
        this.name = new Name(firstName, "");
    }

    // Конструктор с отцом и именем в виде объекта типа Name
    public Person(String fatherName, Name name) {
        this.fatherName = fatherName;
        this.name = name;
    }

    @Override
    public String toString() {
        String personDetails = "Имя: " + name.toString();
        if (fatherName != null) {
            personDetails += ", Отец: " + fatherName;
        }
        return personDetails;
        }
    }
}



}