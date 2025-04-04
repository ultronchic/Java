//задача 7.2.6  с обобщением 6.3.1, 6.3.2, 6.3.3, 6.3.4,
package ru.Balakireva.others;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Поток<T> {
    private List<T> data;

    public Поток(List<T> data) {
        this.data = data;
    }

    public <R> Поток<R> map(Function<T, R> function) {
        List<R> mappedData = new ArrayList<>();
        for (T item : data) {
            mappedData.add(function.apply(item));
        }
        return new Поток<>(mappedData);
    }

    public Поток<T> filter(Predicate<T> predicate) {
        List<T> filteredData = new ArrayList<>();
        for (T item : data) {
            if (predicate.test(item)) {
                filteredData.add(item);
            }
        }
        return new Поток<>(filteredData);
    }

    public T reduce(Reducer<T> reducer) {
        if (data.isEmpty()) {
            return null; // или можно вернуть значение по умолчанию
        }
        T result = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            result = reducer.reduce(result, data.get(i));
        }
        return result;
    }

    public <P extends Collection<T>> P collect(Supplier<P> collectionFactory, BiConsumer<P, T> valueCollector) {
        P result = collectionFactory.get();
        for (T value : data) {
            valueCollector.accept(result, value);
        }
        return result;
    }

    public List<T> toList() {
        return data;
    }

    public interface Reducer<T> {
        T reduce(T a, T b);
    }

    public static void main(String[] args) {
        // Задача 1: Получить сумму всех чисел из строк
        List<String> stringList = Arrays.asList("1", "2", "три", "4", "пять");
        int sum = new Поток<>(stringList)
                .filter(s -> s.matches("-?\\d+")) // Фильтруем только числовые строки
                .map(Integer::parseInt) // Преобразуем строки в числа
                .reduce((a, b) -> a + b); // Суммируем
        System.out.println("Сумма чисел: " + sum);

        // Задача 2: Подсчитать строки, начинающиеся с большой буквы
        List<String> strings = Arrays.asList("Hello", "world", "Java", "is", "great");
        long count = new Поток<>(strings)
                .filter(s -> Character.isUpperCase(s.charAt(0))) // Фильтруем строки, начинающиеся с большой буквы
                .toList().size(); // Получаем размер отфильтрованного списка
        System.out.println("Количество строк, начинающихся с большой буквы: " + count);
    }
}