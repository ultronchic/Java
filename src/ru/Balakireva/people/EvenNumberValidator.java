package ru.Balakireva.people;

public class EvenNumberValidator implements GradeValidator {
    @Override
    public boolean isValid(int grade) {
        return grade % 2 == 0;
    }
}