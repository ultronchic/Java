package ru.Balakireva.others;

import org.springframework.stereotype.Component;

@Component
public class MyService {
    @Default("myBean")
    private MyDependency myDependency;

    // Геттер для тестирования
    public MyDependency getMyDependency() {
        return myDependency;
    }
}