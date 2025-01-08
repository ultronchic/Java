public class Time {
    private int seconds; // Количество секунд с начала суток

    // Конструктор для инициализации времени в секундах
    public Time(int seconds) {
        this.seconds = seconds % 86400; // 86400 секунд в сутках
    }

    // Метод для возврата текстового представления времени
    @Override
    public String toString() {
        int hours = seconds / 3600; // Часы
        int minutes = (seconds % 3600) / 60; // Минуты
        int secs = seconds % 60; // Секунды
        return String.format("%d:%02d:%02d", hours, minutes, secs); // Форматируем строку
    }

    public static void main(String[] args) {
        // Создаем объекты времени
        Time time1 = new Time(10);
        Time time2 = new Time(10000);
        Time time3 = new Time(100000);

        // Выводим текстовое представление времени на экран
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
    }
}