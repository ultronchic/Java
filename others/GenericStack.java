package ru.Balakireva.others;

import java.util.Arrays;

public class GenericStack<T> {
    private Object[] elements;  // Массив для хранения элементов стека
    private int size;          // Текущий размер стека
    private static final int INITIAL_CAPACITY = 10; // Начальная емкость стека

    // Конструктор
    public GenericStack() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Метод для добавления элемента на верх стека
    public void push(T element) {
        ensureCapacity(); // Убедимся, что массив имеет достаточную емкость
        elements[size++] = element; // Добавление элемента и увеличение размера
    }

    // Метод для удаления верхнего элемента стека
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стек пуст"); // Исключение, если стек пуст
        }
        T element = peek(); // Получаем верхний элемент
        elements[size - 1] = null; // Убираем ссылку для сборщика мусора
        size--; // Уменьшаем размер
        return element; // Возвращаем элемент
    }

    // Метод для просмотра верхнего элемента стека
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Стек пуст"); // Исключение, если стек пуст
        }
        return (T) elements[size - 1]; // Возвращаем верхний элемент
    }

    // Проверка на пустоту стека
    public boolean isEmpty() {
        return size == 0;
    }

    // Получение размера стека
    public int size() {
        return size;
    }

    // Метод для увеличения емкости массива
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2); // Увеличиваем массив
        }
    }

