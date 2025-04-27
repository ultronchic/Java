package ru.Balakireva.geometry;

// Обобщенный интерфейс Comparable с методом compare
interface Comparable<T> {
    int compare(T other);
}

// Пример реализации интерфейса для сравнения чисел
class NumberComparable implements Comparable<Number> {
    private Number value;

    public NumberComparable(Number value) {
        this.value = value;
    }

    @Override
    public int compare(Number other) {
        return Double.compare(this.value.doubleValue(), other.doubleValue());
    }

    public Number getValue() {
        return value;
    }
}

// Пример реализации интерфейса для сравнения строк
class StringComparable implements Comparable<String> {
    private String value;

    public StringComparable(String value) {
        this.value = value;
    }

    @Override
    public int compare(String other) {
        return this.value.compareTo(other);
    }

    public String getValue() {
        return value;
    }
}