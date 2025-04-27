import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private final String url; // URL базы данных
    private final String user; // Имя пользователя
    private final String password; // Пароль

    public DAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public <T> List<T> findAll(Class<T> clz) {
        List<T> resultList = new ArrayList<>();

        // Определяем имя таблицы на основе имени класса
        String tableName = clz.getSimpleName().toLowerCase() + "s"; // Например, "users"

        // SQL-запрос для выборки всех записей
        String sql = "SELECT * FROM " + tableName;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                // Создаем объект типа T на основе результата запроса
                T obj = createObjectFromResultSet(resultSet, clz);
                resultList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка исключений
        }

        return resultList;
    }

    private <T> T createObjectFromResultSet(ResultSet resultSet, Class<T> clz) throws SQLException {
        try {
            if (clz == User.class) { // Пример для класса User
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                return clz.cast(new User(id, name, email));
            }
            // Добавьте дополнительные условия для других классов по мере необходимости

            throw new IllegalArgumentException("Неизвестный класс: " + clz);

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new SQLException("Ошибка создания объекта", e);
        }
    }
}