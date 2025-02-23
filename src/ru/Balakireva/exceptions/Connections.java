package ru.Balakireva.exceptions;
package ru.Balakireva.network;

import ru.Balakireva.exceptions.NetworkConnectionLostException;
import ru.Balakireva.exceptions.ResourceAlreadyClosedException;

import java.util.Random;

public class Connections {
    public class Connection {
        private String address;
        private boolean isOpen;
        private Random random;

        public Connection(String address) {
            this.address = address;
            this.isOpen = true; // Соединение открыто после создания
            this.random = new Random();
        }

        public void close() {
            isOpen = false; // Закрыть подключение
        }

        public String requestData() throws NetworkConnectionLostException {
            if (!isOpen) {
                throw new ResourceAlreadyClosedException(); // Генерируем исключение, если ресурс закрыт
            }

            // Генерация случайного числа для определения успешности запроса
            if (random.nextBoolean()) { // 50% вероятность
                return "test connection";
            } else {
                throw new NetworkConnectionLostException("Connection lost while requesting data.");
            }
        }

        public boolean isOpen() {
            return isOpen;
        }

        public String getAddress() {
            return address;
        }
    }
}
