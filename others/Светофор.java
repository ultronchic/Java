package edu.mfti;

public class Main {
    public static void main(String[] args) {
        Trafficlight tl = new Trafficlight();
        tl.on(); // Включаем светофор
        tl.next(); // Переход к зеленому
        tl.next(); // Переход к красному
        tl.off(); // Выключаем светофор
        tl.next(); // Ничего не происходит, светофор выключен
        tl.on(); // Включаем светофор снова
        tl.next(); // Переход к зеленому
    }
}

enum TrafficLightState {
    OFF {
        @Override
        public void make() {
            System.out.println("black");
        }

        @Override
        public TrafficLightState next() {
            return this; // Остается в состоянии OFF
        }
    },
    RED {
        @Override
        public void make() {
            System.out.println("red");
        }

        @Override
        public TrafficLightState next() {
            return GREEN; // Переход к зеленому
        }
    },
    GREEN {
        @Override
        public void make() {
            System.out.println("green");
        }

        @Override
        public TrafficLightState next() {
            return RED; // Переход к красному
        }
    };

    public abstract void make();
    public abstract TrafficLightState next();
}

class Trafficlight {
    private TrafficLightState currentState = TrafficLightState.OFF;

    public void off() {
        currentState = TrafficLightState.OFF;
    }

    public void on() {
        if (currentState == TrafficLightState.OFF) {
            currentState = TrafficLightState.RED; // Начинаем с красного при включении
        }
    }

    public void next() {
        currentState.make();
        currentState = currentState.next();
    }
}