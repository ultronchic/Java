package edu.mfti;

public class YellowState implements TrafficLightState {
    @Override
    public void make() {
        System.out.println("yellow");
    }

    @Override
    public TrafficLightState next() {
        return new GreenState(); // Переход к зеленому
    }
}