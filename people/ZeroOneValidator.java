package ru.Balakireva.people;

public class ZeroOneValidator implements GradeValidator {
    @Override
    public boolean isValid(int grade) {
        return grade == 0 || grade == 1;
    }
}