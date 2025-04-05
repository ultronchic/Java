import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Создаем контекст приложения на основе класса конфигурации
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Получаем бин типа String
        String helloWorld = context.getBean(String.class);

        // Получаем бин типа Date (инициализация произойдет здесь)
        Date firstAccess = context.getBean(Date.class);
        // Получаем бин типа Predicate<Integer>
        Predicate<Integer> inRange = context.getBean(Predicate.class);

        // Получаем бин типа int дважды
        int firstRandomValue = context.getBean(int.class);
        int secondRandomValue = context.getBean(int.class);
        // Получаем бин max
        int maxValue = context.getBean("max", Integer.class);
        // Получаем бин min
        int minValue = context.getBean("min", Integer.class);
        // Выводим значения на экран
        System.out.println(helloWorld);
        System.out.println("Первое случайное значение: " + firstRandomValue);
        System.out.println("Второе случайное значение: " + secondRandomValue);
        // Выводим значение на экран
        System.out.println("Дата и время первого обращения к бину: " + firstAccess);
        // Проверяем несколько значений
        int[] testValues = {1, 2, 3, 4, 5, 6};
        for (int value : testValues) {
            boolean result = inRange.test(value);
            System.out.println("Число " + value + " укладывается в диапазон от 2 до 5: " + result);
         // Выводим значения на экран
         System.out.println("Максимальное значение: " + maxValue);
         System.out.println("Минимальное значение: " + minValue);
}







    }
}
}
