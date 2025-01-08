class Name {
    private String firstName; // Личное имя
    private String lastName;  // Фамилия
    private String patronymic; // Отчество

    public Name(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
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

    @Override
    public String toString() {
        return firstName + (lastName != null ? " " + lastName : "") + (patronymic != null ? " " + patronymic : "");
    }
}
