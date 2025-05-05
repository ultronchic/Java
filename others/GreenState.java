package edu.mfti;

public class GreenState implements TrafficLightState {
    @Override
    public void make() {
        System.out.println("green");
    }

    @Override
    public TrafficLightState next() {
        return new YellowState(); // Переход к желтому
    }
}