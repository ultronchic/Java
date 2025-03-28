package edu.mfti;

import java.util.HashMap;
import java.util.Map;

public interface Fractionable {
    Fraction sum(int num);
    int intValue();
}

class Fraction implements Fractionable {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Fraction sum(int num) {
        return new Fraction(this.numerator + num * this.denominator, this.denominator);
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

class FractionCache {
    private final Map<String, Fractionable> cache = new HashMap<>();

    public Fractionable getFraction(int numerator, int denominator) {
        String key = numerator + "/" + denominator;
        if (!cache.containsKey(key)) {
            cache.put(key, new Fraction(numerator, denominator));
        }
        return cache.get(key);
    }
}
