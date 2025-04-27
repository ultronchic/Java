package ru.Balakireva.geometry;

// Обобщенный класс Storage
class Storage<T> {
    private final T item; // Храним объект типа T

    // Конструктор для инициализации объекта
    public Storage(T item) {
        this.item = item; // Сохраняем значение, может быть null
    }

    // Метод для получения значения с альтернативным значением
    public T getOrDefault(T defaultValue) {
        return item != null ? item : defaultValue; // Возвращаем объект или альтернативное значение
    }
}

