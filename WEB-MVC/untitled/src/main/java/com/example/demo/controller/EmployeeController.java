package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees"; // имя HTML-шаблона без расширения .html
    }

    // Метод для добавления тестовых данных (опционально)
    @PostConstruct // Этот метод будет вызван после создания бина.
    public void init() {
        employeeRepository.save(new Employee("John Doe", "Developer"));
        employeeRepository.save(new Employee("Jane Smith", "Manager"));
    }
}