package edu.mfti;

public interface TrafficLightState {
    void make();
    TrafficLightState next();
}