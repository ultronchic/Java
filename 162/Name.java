class Name {
    private final String firstName; // Личное имя
    private final String lastName;   // Фамилия
    private final String patronymic; // Отчество

    public Name(String firstName, String lastName, String patronymic) {
        if (isEmpty(firstName) && isEmpty(lastName) && isEmpty(patronymic)) {
            throw new IllegalArgumentException("Как минимум один параметр должен быть ненулевым и непустым");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public Name(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public Name(String firstName) {
        this(firstName, null, null);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName).append(" ");
        }
        if (firstName != null && !firstName.isEmpty()) {
            result.append(firstName).append(" ");
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            result.append(patronymic);
        }
        return result.toString().trim();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}