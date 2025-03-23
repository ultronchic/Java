package ru.Balakireva.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Predicate<T> {
    boolean test(T value);
}
