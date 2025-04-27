// AppConfig.java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Predicate;
import java.util.function.Predicate; // задача 9.2.5

@Configuration
public class AppConfig {
    @Bean
    public String helloWorld() {
        return "Hello world";
    @Bean
    public Integer min() {
        return 1; // минимальная оценка
    }

    @Bean
    public Integer max() {
        return 5; // максимальная оценка
    }

    @Bean
    public RandomIntGenerator randomIntGenerator(Integer min, Integer max) {
        return new RandomIntGenerator(min, max);
    }

    @Bean
    public Review review1() {
        return new Review("Очень хорошо", 4);
    }

    @Bean
    public Review review2() {
        return new Review("Сойдет", 3);
    }

    @Bean
    public Review review3(RandomIntGenerator randomIntGenerator) {
        int randomRating = randomIntGenerator.getNextRandom();
        return new Review("Сложно сказать", randomRating);
    }
}
// AppConfig.java задача 9.2.3

        @Bean
        public Review bestReview(Review review1, Review review2, Review review3) {
            return getBestReview(review1, review2, review3);
        }

        private Review getBestReview(Review... reviews) {
            Review best = reviews[0];
            for (Review review : reviews) {
                if (review.getRating() > best.getRating()) {
                    best = review;
                }
            }
            return best;
        }
    }
// AppConfig.java задача 9.2.4

    @Bean
    public Predicate<Integer> inRange() {
        return number -> number >= 2 && number <= 5; // Проверка на диапазон от 2 до 5 включительно
    }

    @Bean
    public Student student1(Predicate<Integer> inRange) {
        return new Student("Иванов Иван", 4.5, inRange);
    }

    @Bean
    public Student student2(Predicate<Integer> inRange) {
        return new Student("Петров Петр", 3.0, inRange);
    }
}
// AppConfig.java 9.2.5

    @Bean
    public Predicate<Integer> inRange() {
        return number -> number >= 2 && number <= 5; // Проверка на диапазон от 2 до 5 включительно
    }
// AppConfig.java 9.2.6 Стриминг платформа.
package ru.Balakireva.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.Balakireva.stream.DataReader;
import ru.Balakireva.stream.DataWriter;
import ru.Balakireva.stream.FileDataReader;
import ru.Balakireva.stream.FileDataWriter;

// Конфигурационный класс Spring для настройки бинов.
    @Bean
    public DataReader fileDataReader() {
        return new FileDataReader();
    }
    @Bean
    public DataWriter fileDataWriter() {
        return new FileDataWriter();
    }
// AppConfig.java 9.2.7 Настройка светофора.
package ru.Balakireva.others;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Bean
    public RedState redState() {
        return new RedState();
    }

    @Bean
    public YellowState yellowState() {
        return new YellowState();
    }

    @Bean
    public GreenState greenState() {
        return new GreenState();
    }

    @Bean
    public TrafficLight trafficLight() {
        return new TrafficLight(redState());
    }

// задача 9.2.8

    @Bean
    public Stock orclStock() {
        return new Stock("ORCL", 75);
    }

    @Bean
    public Stock tslaStock() {
        return new Stock("TSLA", 696);
    }

    @Bean
    public Printer printer() {
        return new Printer();
    }

    @Bean
    public Bot bot() {
        return new Bot();
    }

    @Bean
    public void registerObservers(Stock orclStock, Stock tslaStock, Printer printer, Bot bot) {
        orclStock.addObserver(printer);
        orclStock.addObserver(bot);
        tslaStock.addObserver(printer);
    }
}
}
}
}