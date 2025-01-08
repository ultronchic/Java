public class Name {
    private String lastName; // Фамилия
    private String firstName; // Личное имя
    private String patronymic; // Отчество

    // Конструктор для инициализации всех параметров
    public Name(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    // Метод для возврата текстового представления имени
    @Override
    public String toString() {
        StringBuilder fullName = new StringBuilder();

        if (lastName != null && !lastName.isEmpty()) {
            fullName.append(lastName).append(" ");
        }
        if (firstName != null && !firstName.isEmpty()) {
            fullName.append(firstName).append(" ");
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            fullName.append(patronymic);
        }

        return fullName.toString().trim(); // Удаляем лишние пробелы
    }

    public static void main(String[] args) {
        // Создаем объекты имен
        Name cleopatra = new Name("Клеопатра", "", "");
        Name pushkin = new Name("Пушкин", "Александр", "Сергеевич");
        Name mayakovsky = new Name("Маяковский", "Владимир", "");

        // Выводим текстовое представление имен на экран
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);
    }
}