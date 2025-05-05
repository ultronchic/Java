package edu.mfti;
import org.springframework.stereotype.Component;
@Component
public class TrafficLight {

    private TrafficLightState currentState;

    public TrafficLight() {
        this.currentState = new RedState(); // Начинаем с красного состояния.
    }

    public void next() {
        currentState.make();
        currentState = currentState.next();
    }
}