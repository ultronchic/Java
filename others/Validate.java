package ru.Balakireva.others;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Validator {

    public static void validate(Object obj, Class<?> testClass) throws ValidateException {
        Method[] methods = testClass.getDeclaredMethods();
        Method[] methods;
        Class<?> objClass = obj.getClass();

        // Проверяем наличие аннотации @Validate или @AValidate
        if (objClass.isAnnotationPresent(Validate.class)) {
            Validate validateAnnotation = objClass.getAnnotation(Validate.class);
            Class<?>[] testClasses = validateAnnotation.value();
            methods = getTestMethods(validateAnnotation.value());

        } else if (objClass.isAnnotationPresent(AValidate.class)) {
            AValidate avalidateAnnotation = objClass.getAnnotation(AValidate.class);
            methods = getTestMethods(avalidateAnnotation.value());
        } else {
            throw new ValidateException("Класс не имеет аннотации @Validate или @AValidate");
        }
//Выполняем тесты
            for (Class<?> testClass : testClasses) {
                Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            try {
                method.invoke(null, obj); // Вызов статического метода теста с переданным объектом
            } catch (Exception e) {
                // Если возникло исключение, обрабатываем его и выбрасываем ValidateException
                if (e.getCause() instanceof ValidateException) {
                    throw (ValidateException) e.getCause();
                } else {
                    throw new ValidateException("Ошибка при выполнении теста " + method.getName() + ": " + e.getMessage());
                }
            }
        } else {
            throw new ValidateException("Класс не имеет аннотации @Validate");
        }
private static Method[] getTestMethods(Class<?>[] testClasses) {
    // Собираем все методы тестирования из указанных классов
    return Arrays.stream(testClasses)
          .flatMap(testClass -> Arrays.stream(testClass.getDeclaredMethods()))
          .toArray(Method[]::new);
    }
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Validate {
    Class<?>[] value(); // Массив классов тестов
    String[] value(); // Массив имен правил // Задача 9.3.4
    }
}
