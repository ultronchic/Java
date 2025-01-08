class Name {
    private String firstName; // Личное имя
    private String patronymic; // Отчество
    private String lastName; // Фамилия

    public Name(String firstName, String patronymic, String lastName) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLastName() {
        return lastName;
    }
}