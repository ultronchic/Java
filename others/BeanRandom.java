//9.2.1
/*9.2.1 random. Измените бин random из задачи 9.1.2 таким образом, что бы
        1.	Минимальное и максимальное значения задавались бинами из задачи 9.1.5
        2.	Возвращаемые им числа не повторялись до тех пор, пока не использованы все значения в диапазоне от минимального до максимального.
*/
// AppConfig.java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotat.n.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Integer min() {
        return 0; // минимальное значение
    }

    @Bean
    public Integer max() {
        return 99; // максимальное значение
    }

    @Bean
    public RandomIntGenerator randomIntGenerator(Integer min, Integer max) {
        return new RandomIntGenerator(min, max);
    }
}
// RandomIntGenerator.java
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
// MainApp.java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        int minValue = context.getBean("min", Integer.class);
        int maxValue = context.getBean("max", Integer.class);

        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Максимальное значение: " + maxValue);

        RandomIntGenerator generator = context.getBean(RandomIntGenerator.class);

        // Запросим два раза подряд и выведем значения
        int firstRandom = generator.getNextRandom();
        int secondRandom = generator.getNextRandom();

        System.out.println("Первое случайное число: " + firstRandom);
        System.out.println("Второе случайное число: " + secondRandom);
    }
}