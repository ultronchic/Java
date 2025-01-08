public class Name {
    private final String firstName; // Имя
    private final String lastName; // Фамилия
    private final String patronymic; // Отчество

    public Name(String firstName, String lastName, String patronymic) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.firstName = firstName;
        this.lastName = (lastName != null) ? lastName : "";
        this.patronymic = (patronymic != null) ? patronymic : "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }
}