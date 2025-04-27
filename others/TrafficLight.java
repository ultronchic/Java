// TrafficLight.java
package ru.Balakireva.others;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight {

    private TrafficLightState currentState;

    @Autowired
    public TrafficLight(RedState redState) {
        this.currentState = redState; // Начинаем с красного состояния.
    }

    public void next() {
        currentState.make();
        currentState = currentState.next();
    }
}