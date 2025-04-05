import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Configuration
public class AppConfig {

    @Bean
    @Lazy // Инициализация произойдет только при первом обращении
    public Date firstAccessDate() {
        return new Date(); // Возвращаем текущую дату и время
    }
}