package ru.Balakireva.Karate;

import java.util.ArrayList;
import java.util.List;

// Класс для представления комбинации ударов
class Combo {
    private final List<Action> actions = new ArrayList<>();

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
    }

    public void executeCombo(String name) {
        for (Action action : actions) {
            action.execute(name);
        }
    }
}
