public class Person {
    private Name name;
    private int height;

    public Person(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return name.toString() + ", рост: " + height;
    }
}