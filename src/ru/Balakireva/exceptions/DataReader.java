import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataReader {

    public void readData() {
        // URL адрес, с которым мы хотим работать
        String urlString = "http://ermakov.edu";
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            // Шаг 1: Создаем подключение
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Проверяем код ответа
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.err.println("Ошибка при подключении: " + responseCode);
                return;
            }

            // Шаг 2: Считываем и выводим на экран десять строк
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null && lineCount < 10) {
                System.out.println(line);
                lineCount++;
            }

        } catch (IOException e) {
            System.err.println("Ошибка во время чтения данных: " + e.getMessage());
        } finally {
            // Шаг 3: Закрываем соединение
            try {
                if (reader != null) {
                    reader.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
    }

}