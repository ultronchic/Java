package ru.Balakireva.others;
package ru.Balakireva.models;
import ru.Balakireva.others.Default;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target({ElementType.TYPE, ElementType.FIELD}) // применяется к типам и полям
public @interface Default {
    Class<?> value(); // Обязательное свойство типа Class
public @interface Default {
    String value();

    @Default("defaultPerson")
    public class Person {

        @Default("defaultName")
        private String name;

        @Override
        public String toString() {
            return "Person{name='" + name + "'}";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}