public class Person {
    private Name name;
    private Person father;

    public Person(Name name, Person father) {
        this.name = name;
        this.father = father;
    }

    public Name getName() {
        return name;
    }

    public Person getFather() {
        return father;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        // Используем фамилию отца, если фамилия не указана
        if (name.getLastName().isEmpty() && father != null) {
            String lastNameFromFather = father.getName().getLastName();
            if (!lastNameFromFather.isEmpty()) {
                result.append(lastNameFromFather).append(" ");
            }
        } else {
            result.append(name.getLastName()).append(" ");
        }

        // Используем имя из имени, либо имя отца с окончанием "ович" для отчества
        if (!name.getMiddleName().isEmpty()) {
            result.append(name.getMiddleName());
        } else if (father != null && !father.getName().getFirstName().isEmpty()) {
            result.append(father.getName().getFirstName()).append("-ович");
        }

        if (!name.getFirstName().isEmpty()) {
            result.append(", ").append(name.getFirstName());
        }

        return result.toString().trim(); // результат без учета роста
    }
}