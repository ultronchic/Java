package ru.Balakireva.people;

class Employee {
    private String name;
    private Department department;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (department != null) {
            this.department = department;
            department.addEmployee(this); // Добавляем сотрудника в отдел
        }
    }

    @Override
    public String toString() {
        if (department != null) {
            if (department.getManager() == this) {
                return name + " - начальник отдела " + department.getName();
            } else {
                return name + " работает в отделе " + department.getName() + ", начальник которого " + (department.getManager() != null ? department.getManager().getName() : "нет");
            }
        }
        return name + " - без отдела";
    }
}