package ru.Balakireva.geometry;

import java.util.List;

// Обобщенный класс Box6 6.2.2
class Box<T> {
    private T item; // Храним объект типа T

    // Метод для добавления объекта в коробку
    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена. Сначала извлеките объект.");
        }
        this.item = item; // Помещаем объект в коробку
    }

    // Метод для извлечения объекта из коробки
    public T get() {
        T tempItem = this.item; // Сохраняем ссылку на текущий объект
        this.item = null; // Обнуляем ссылку
        return tempItem; // Возвращаем объект
    }

    // Метод проверки на заполненность
    public boolean isEmpty() {
        return this.item == null; // Возвращаем true, если коробка пуста
    }
}

public class Main {
    // Метод для поиска максимального значения среди коробок
    public static <T extends Comparable<T>> double findMax(Box<T>[] boxes) {
        T max = null; // Будем хранить максимальное значение

        for (Box<T> box : boxes) {
            if (!box.isEmpty()) { // Проверяем, что коробка не пуста
                T value = box.get(); // Извлекаем значение из коробки
                if (max == null || value.compareTo(max) > 0) {
                    max = value; // Обновляем максимальное значение
                }
            }
        }

        // Если не нашли ни одного значения, выбрасываем исключение
        if (max == null) {
            throw new IllegalStateException("Нет значений для поиска максимума.");
        }

        return max instanceof Number ? ((Number) max).doubleValue() : 0;
    }