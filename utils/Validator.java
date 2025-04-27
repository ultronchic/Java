package ru.Balakireva.utils;
package ru.Balakireva.others;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

//REST API
@RestController
class SummatorController {
@GetMapping("/make")
public String arithmeticExpression(String expression) {
    return calculate(expression);
}
    //логику писать сюда
    public static String calculate(String str){
        return String.valueOf(evaluateExpression(str));
    };
}
    private static int evaluateExpression(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            // Пропуск пробелов
                if (tokens[i] == ' ') continue;

                // Если текущий символ - число, считываем его
                if (Character.isDigit(tokens[i])) {
                    StringBuilder sb = new StringBuilder();
                    while (i < tokens.length && Character.isDigit(tokens[i])) {
                        sb.append(tokens[i++]);
                    }
                    values.push(Integer.parseInt(sb.toString()));
                    i--; // уменьшаем индекс, так как в цикле его увеличиваем
                }

                // Если текущий символ - открывающая скобка
                else if (tokens[i] == '(') {
                    operators.push(tokens[i]);
                }

                // Если текущий символ - закрывающая скобка
                else if (tokens[i] == ')') {
                    while (operators.peek() != '(') {
                        values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.pop(); // удаляем открывающую скобку
                }

                // Если текущий символ - оператор
                else if (isOperator(tokens[i])) {
                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(tokens[i])) {
                        values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.push(tokens[i]);
                }
            }

            // Выполняем оставшиеся операции в стеке операторов
            while (!operators.isEmpty()) {
                values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
            }

            return values.pop(); // возвращаем результат
        }
        // Определяем приоритет операций
        private static int precedence(char operator) {
            switch (operator) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                default:
                    return -1;
            }
        }
        // Применение операции
        private static int applyOperation(char operator, int b, int a) {
            switch (operator) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                    return a / b;
            }
            return 0;
        }

        // Проверка является ли символ оператором
        private static boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }
//задача 9.3.4
        public class Validator {
            public static void validate(Object obj) throws ValidateException {
                Class<?> objClass = obj.getClass();

                // Проверяем наличие аннотации @Validate
                if (objClass.isAnnotationPresent(Validate.class)) {
                    Validate validateAnnotation = objClass.getAnnotation(Validate.class);
                    String[] rules = validateAnnotation.value();

                    // Выполняем тесты
                    for (String rule : rules) {
                        try {
                            Method method = ValidationRules.class.getDeclaredMethod(rule, obj.getClass());
                            method.invoke(null, obj); // Вызов статического метода теста с переданным объектом
                        } catch (NoSuchMethodException e) {
                            throw new ValidateException("Правило " + rule + " не найдено.");
                        } catch (Exception e) {
                            // Если возникло исключение, обрабатываем его и выбрасываем ValidateException
                            if (e.getCause() instanceof ValidateException) {
                                throw (ValidateException) e.getCause();
                            } else {
                                throw new ValidateException("Ошибка при выполнении правила " + rule + ": " + e.getMessage());
                            }
                        }
                    }
                } else {
                    throw new ValidateException("Класс не имеет аннотации @Validate");
                }
            }
        }