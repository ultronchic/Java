import java.util.ArrayList;
import java.util.List;

class Department {
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        if (manager != null && manager.getDepartment() == this) {
            this.manager = manager;
            addEmployee(manager); // Добавляем менеджера в список сотрудников
        }
    }

    public void addEmployee(Employee employee) {
        if (employee != null && employee.getDepartment() == this) {
            employees.add(employee);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Отдел: " + name + ", Начальник: " + (manager != null ? manager.getName() : "нет");
    }
}