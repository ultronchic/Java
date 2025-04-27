// RedState.java
package ru.Balakireva.others;

import org.springframework.stereotype.Component;

@Component
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

// YellowState.java
package ru.Balakireva.others;

import org.springframework.stereotype.Component;

@Component
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

// GreenState.java
package ru.Balakireva.others;

import org.springframework.stereotype.Component;

@Component
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