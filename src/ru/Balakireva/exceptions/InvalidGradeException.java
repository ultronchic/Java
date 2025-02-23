package ru.Balakireva.exceptions;

public class InvalidGradeException extends RuntimeException {
    // Конструктор без параметров
    public InvalidGradeException() {
        super();
    }

    // Конструктор с сообщением
    public InvalidGradeException(String message) {
        super(message);
    }
    public class NetworkConnectionLostException extends Exception {
        // Конструктор без параметров
        public NetworkConnectionLostException() {
            super();
        }

        // Конструктор с сообщением
        public NetworkConnectionLostException(String message) {
            super(message);
        }

        // Конструктор с причиной
        public NetworkConnectionLostException(Throwable cause) {
            super(cause);
        }

        // Конструктор с сообщением и причиной
        public NetworkConnectionLostException(String message, Throwable cause) {
            super(message, cause);
        }
        public class ResourceAlreadyClosedException extends RuntimeException {
            // Конструктор без параметров
            public ResourceAlreadyClosedException() {
                super("Ресурс уже закрыт и не может быть использован."); // Сообщение по умолчанию
            }
        }
    }
}