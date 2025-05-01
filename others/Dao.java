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
        String tableName = clz.getSimpleName().toLowerCase(); // Предполагаем, что имя таблицы соответствует имени класса в нижнем регистре

        String sql = "SELECT * FROM " + tableName;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                T obj = mapRowToObject(resultSet, clz);
                resultList.add(obj);
            }

        } catch (SQLException e) {
            throw new DataAccessException("Ошибка при извлечении данных из таблицы '" + tableName + "': " + e.getMessage(), e);
        } catch (Exception e) {
            throw new DataMappingException("Ошибка при маппинге данных на объект класса '" + clz.getSimpleName() + "': " + e.getMessage(), e);
        }

        return resultList;
    }

    private <T> T mapRowToObject(ResultSet resultSet, Class<T> clz) throws Exception {
        T obj = clz.getDeclaredConstructor().newInstance(); // Создаем новый экземпляр класса

        for (Field field : clz.getDeclaredFields()) {
            field.setAccessible(true); // Игнорируем инкапсуляцию
            Object value = resultSet.getObject(field.getName()); // Получаем значение из ResultSet по имени поля
            field.set(obj, value); // Устанавливаем значение поля
        }

        return obj;
    }
}
