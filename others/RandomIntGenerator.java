import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomIntGenerator {

    private final List<Integer> numbers;
    private int currentIndex = 0;

    public RandomIntGenerator(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min должен быть меньше или равен max");
        }
        numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
    }

    /**
     * Возвращает следующее случайное число без повторений.
     * Если все числа использованы — выбрасывает исключение.
     */
    public int getNextRandom() {
        if (currentIndex >= numbers.size()) {
            throw new IllegalStateException("Все числа в диапазоне уже были использованы");
        }
        return numbers.get(currentIndex++);
    }
}