public class Name {
    private String firstName; // Личное имя
    private String lastName; // Фамилия
    private String patronymic; // Отчество

    // Конструктор для имени
    public Name(String firstName) {
        this.firstName = firstName;
    }

    // Конструктор для имени и фамилии
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Конструктор для имени, фамилии и отчества
    public Name(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    // Метод для получения текстового представления имени
    @Override
    public String toString() {
        StringBuilder nameRepresentation = new StringBuilder();

        // Добавляем фамилию, если она задана
        if (lastName != null && !lastName.isEmpty()) {
            nameRepresentation.append(lastName).append(" ");
        }

        // Добавляем имя
        if (firstName != null && !firstName.isEmpty()) {
            nameRepresentation.append(firstName).append(" ");
        }

        // Добавляем отчество, если оно задано
        if (patronymic != null && !patronymic.isEmpty()) {
            nameRepresentation.append(patronymic);
        }

        // Возвращаем итоговое представление (удаляем ведущие и завершающие пробелы)
        return nameRepresentation.toString().trim();
    }

    // Геттеры для доступа к полям
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    // Добавленный метод getMiddleName()
    public String getMiddleName() {
        return patronymic;
    }
}