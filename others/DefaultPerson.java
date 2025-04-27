package ru.Balakireva.models;
import ru.Balakireva.others.Default;
public class DefaultPerson {

    @Default("defaultName")
    private String name = "John Doe"; // Значение по умолчанию

    public String getName() {
        return name;
    }
}