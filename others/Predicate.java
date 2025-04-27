import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class AppConfig {

    @Bean
    public Predicate<Integer> inRange() {
        return number -> number >= 2 && number <= 5; // Проверка на диапазон от 2 до 5 включительно
    }
}