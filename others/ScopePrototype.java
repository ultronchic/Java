import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class AppConfig {

    private final Random random = new Random();

    @Bean
    @Scope("prototype") // Каждый раз будет создаваться новый экземпляр
    public int randomInt() {
        return random.nextInt(100); // Генерируем случайное число от 0 до 99
    }
}