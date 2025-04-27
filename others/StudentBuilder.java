// StudentBuilder.java
package ru.Balakireva.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class StudentBuilder {

    private final Predicate<Integer> range;

    @Autowired
    public StudentBuilder(Predicate<Integer> range) {
        this.range = range;
    }

    public Student createStudent(String name, List<Integer> grades) {
        return new Student(name, grades, range);
    }

    public Student createStudent(String name) {
        return new Student(name, null, range); // Если оценки не указаны, передаем null
    }
}