import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "max")
    public int max() {
        return 100; // Произвольное значение для максимума
    }

    @Bean(name = "min")
    public int min() {
        return 10; // Произвольное значение для минимума
    }
}