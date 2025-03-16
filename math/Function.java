package ru.Balakireva.math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Function<T, P> {
    P apply(T value);
}

