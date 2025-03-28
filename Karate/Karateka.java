package ru.Balakireva.Karate;

import java.util.ArrayList;
import java.util.List;

// Интерфейс для действия
interface Action {
    void execute(String name);
}

// Класс для представления каратиста
class Karateka {
    private final String name;

    public Karateka(String name) {
        this.name = name;
    }

    public void kick() {
        System.out.println(name + ": бац!");
    }

    public void punch() {
        System.out.println(name + ": кия!");
    }

    public void jumpKick() {
        System.out.println(name + ": вжух!");
    }
}

// Класс для представления команды удара
class ActionCommand implements Action {
    private final String actionType;
    private final Karateka karateka;

    public ActionCommand(String actionType, Karateka karateka) {
        this.actionType = actionType;
        this.karateka = karateka;
    }

    @Override
    public void execute(String name) {
        switch (actionType) {
            case "kick":
                karateka.kick();
                break;
            case "punch":
                karateka.punch();
                break;
            case "jumpKick":
                karateka.jumpKick();
                break;
            default:
                throw new IllegalArgumentException("Unknown action: " + actionType);
        }
    }
}
