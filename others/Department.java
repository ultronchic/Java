package ru.Balakireva.others;

import ru.Balakireva.people.Employee;

import java.util.ArrayList;
import java.util.Collections;
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
            if (this.manager != null) {
                // Убираем предыдущего менеджера из списка сотрудников, если он есть
                employees.remove(this.manager);
            }
            this.manager = manager;
            addEmployee(manager); // Добавляем нового менеджера в список сотрудников
        }
    }

    public void addEmployee(Employee employee) {
        if (employee != null && employee.getDepartment() == this) {
            // Учтем, что менеджер не должен дублироваться в списке сотрудников
            if (!employees.contains(employee)) {
                employees.add(employee);
            }
        }
    }

    // Возвращаем копию списка сотрудников
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    @Override
    public String toString() {
        return "Отдел: " + name + ", Начальник: " + (manager != null ? manager.getName() : "нет");
    }
}