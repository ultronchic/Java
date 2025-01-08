public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        if (department != null) {
            if (department.getManager().equals(this)) {
                return name + " начальник отдела " + department.getName();
            } else {
                return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getManager().name;
            }
        }
        return name + " работает в отделе не известном"; // Если отдел не указан
    }

    public Department getDepartment() {
        return department;
    }
}