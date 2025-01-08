public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName != null ? lastName : "";
        this.firstName = firstName != null ? firstName : "";
        this.middleName = middleName != null ? middleName : "";
    }

    @Override
    public String toString() {
        StringBuilder fullName = new StringBuilder();
        if (!lastName.isEmpty()) fullName.append(lastName).append(" ");
        if (!firstName.isEmpty()) fullName.append(firstName).append(" ");
        if (!middleName.isEmpty()) fullName.append(middleName);
        return fullName.toString().trim();
    }
}