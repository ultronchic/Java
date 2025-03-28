package ru.Balakireva.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Reducer<T> {
    T reduce(T a, T b);
}