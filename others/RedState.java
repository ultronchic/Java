package edu.mfti;

public class RedState implements TrafficLightState {
    @Override
    public void make() {
        System.out.println("red");
    }

    @Override
    public TrafficLightState next() {
        return new YellowState(); // Переход к желтому
    }
}