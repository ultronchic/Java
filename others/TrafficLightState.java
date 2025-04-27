// TrafficLightState.java
package ru.Balakireva.others;

public interface TrafficLightState {
    void make();
    TrafficLightState next();
}