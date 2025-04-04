package ru.Balakireva.others;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target({ElementType.TYPE, ElementType.FIELD}) // Может применяться к типам и полям
public @interface Default {
    Class<?> value(); // Обязательное свойство типа Class
}