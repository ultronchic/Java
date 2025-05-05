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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

    @Configuration
    public class AppConfig {

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
        public List<Review> reviews(RandomIntGenerator randomIntGenerator) {
            List<Review> reviews = new ArrayList<>();
            reviews.add(new Review("Очень хорошо", 4));
            reviews.add(new Review("Сойдет", 3));

            // Добавляем случайный отзыв
            int randomRating = randomIntGenerator.getNextRandom();
            reviews.add(new Review("Сложно сказать", randomRating));

            return reviews;
        }

        @Bean
        public Review bestReview(List<Review> reviews) {
            return getBestReview(reviews);
        }

        private Review getBestReview(List<Review> reviews) {
            if (reviews.isEmpty()) {
                throw new IllegalArgumentException("Нет доступных отзывов для оценки.");
            }

            Review best = reviews.get(0);
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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.Balakireva.stream.DataReader;
import ru.Balakireva.stream.DataWriter;
import ru.Balakireva.stream.FileDataReader;
import ru.Balakireva.stream.FileDataWriter;

// Конфигурационный класс Spring для настройки бинов.
@Configuration
public class AppConfig {

    @Value("${input.file.name}")
    private String inputFileName;

    @Value("${output.file.name}")
    private String outputFileName;

    @Bean
    public DataReader fileDataReader() {
        FileDataReader reader = new FileDataReader();
        reader.setInputFileName(inputFileName);
        return reader;
    }

    @Bean
    public DataWriter fileDataWriter() {
        FileDataWriter writer = new FileDataWriter();
        writer.setOutputFileName(outputFileName);
        return writer;
    }

    @Bean
    public StreamProcessor streamProcessor(DataReader dataReader, DataWriter dataWriter,
                                           ToUpperCaseAction toUpperCaseAction,
                                           RemoveAAction removeAAction,
                                           FilterLongWordsAction filterLongWordsAction) {
        return new StreamProcessor(dataReader, dataWriter, toUpperCaseAction, removeAAction, filterLongWordsAction);
    }
}

// задача 9.2.8
package edu.mfti;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TrafficLight trafficLight() {
        return new TrafficLight(); // Создаем светофор без состояний как бинов.
    }
}
//Задача 9.3.1
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName(null); // Устанавливаем имя в null для тестирования
        return person;
    }
    @Bean
    public NameFieldPostProcessor nameFieldPostProcessor() {
        return new NameFieldPostProcessor();
    }
//задача 9.3.2 Умолчания контейнера

package ru.Balakireva.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.Balakireva.models.DefaultPerson;
import ru.Balakireva.models.Person;
import ru.Balakireva.others.AnnotationUtils;
import ru.Balakireva.others.DefaultValuesPostProcessor;

@Configuration
public class AppConfig {

    @Bean(name = "defaultPerson")
    public DefaultPerson defaultPerson() {
        return new DefaultPerson(); // Бин со значением по умолчанию
    }

    @Bean(name = "person")
    public Person person() {
        return new Person(); // Бин без значения имени
    }

    @Bean
    public AnnotationUtils annotationUtils() {
        return new AnnotationUtils(); // Внедряем AnnotationUtils
    }

    @Bean
    public DefaultValuesPostProcessor defaultValuesPostProcessor(AnnotationUtils annotationUtils) {
        return new DefaultValuesPostProcessor(annotationUtils); // Регистрируем постобработчик
    }
//Задача 9.3.3
package ru.Balakireva.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.Balakireva.models.B;
import ru.Balakireva.others.ToStringPostProcessor;

    @Configuration
    public class MainApp {

        @Bean
        public B b() {
            return new B(); // Создаем экземпляр класса B
        }

        @Bean
        public ToStringPostProcessor toStringPostProcessor() {
            return new ToStringPostProcessor(); // Регистрируем наш постобработчик
        }

        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

            B bInstance = context.getBean(B.class);

            System.out.println(bInstance); // Ожидается вывод: B{text=B, s=hello}
        }
    }
//задача 9.3.6
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        @Bean
        public RandomNumber randomNumber(RandomIntGenerator randomIntGenerator) {
            return new RandomNumber(randomIntGenerator);
        }
    }
}
}
}
}