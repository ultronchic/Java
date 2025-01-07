/* задача 5.1 public static int findFirst(int[] arr, int x);
Необходимо реализовать метод таким образом,
чтобы он возвращал индекс первого вхождения числа x в массив arr.
Если число не входит в массив – возвращается -1.
Пример: arr=[1,2,3,4,2,2,5] x=2 результат: 1 */

public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 2, 5};
        int x = 2;
        int result = findFirst(arr, x);
        System.out.println(result); // Вывод: 1
    }
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i; // Возвращаем индекс первого вхождения
            }
        }
        return -1; // Если число не найдено, возвращаем -1
    }
/* задача 5.2
public static int findLast(int[] arr, int x);
Необходимо реализовать метод таким образом,
чтобы он возвращал индекс последнего вхождения
числа x в массив arr. Если число не входит в массив – возвращается -1.
Пример: arr=[1,2,3,4,2,2,5] x=2 результат: 5
*/
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 2, 2, 5};
    int x = 2;
    int result = findLast(arr, x);
    System.out.println(result); // Вывод: 5
    }
    public static int findLast(int[] arr, int x) {
        // Проходим массив в обратном порядке
    for (int i = arr.length - 1; i >= 0; i--) {
    if (arr[i] == x) {
       return i; // Возвращаем индекс последнего вхождения
            }
        }
       return -1; // Если число не найдено, возвращаем -1
    }

/* задача 5.3
5.3 Поиск максимального. Дана следующая сигнатура метода:
public static int maxAbs(int[] arr);
Необходимо реализовать метод таким образом, чтобы он возвращал
наибольшее по модулю (то есть без учета знака) значение массива arr.
Пример:
arr=[1,-2,-7,4,2,2,5]
результат: -7
*/

public static void main(String[] args) {
    int[] arr = {1, -2, -7, 4, 2, 2, 5};
    int result = maxAbs(arr);
    System.out.println(result); // Вывод: -7
    }
public static int maxAbs(int[] arr) {
    // Проверка на пустой массив
    if (arr == null || arr.length == 0) {
        throw new IllegalArgumentException("Массив не должен быть пустым.");
        }

    // Инициализация переменной для хранения максимального значения по модулю
    int max = arr[0];

    // Проходим через все элементы массива
    for (int i = 1; i < arr.length; i++) {
    // Сравниваем по абсолютной величине
        if (Math.abs(arr[i]) > Math.abs(max)) {
            max = arr[i];
            }
        }

    return max;
    }

/* задача 5.4
5.4 Подсчет позитива. Дана следующая сигнатура метода:
public static int countPositive(int[] arr);
Необходимо реализовать метод таким образом, чтобы
он возвращал количество положительных элементов массива arr.
Пример:
arr=[1,-2,-7,4,2,2,5]
результат: 5
 */
public static void main(String[] args) {
    int[] arr = {1, -2, -7, 4, 2, 2, 5};
    int result = countPositive(arr);
    System.out.println(result); // Вывод: 5
    }
    public static int countPositive(int[] arr) {
    // Проверка на пустой массив
    if (arr == null || arr.length == 0) {
        return 0; // Если массив пустой, возвращаем 0
        }

        int count = 0; // Инициализация счетчика положительных элементов

        // Проходим через все элементы массива
    for (int num : arr) {
        if (num > 0) { // Если элемент положительный
           count++; // Увеличиваем счетчик
            }
        }

    return count; // Возвращаем количество положительных элементов
    }

/*
задача 5.5
5.5 Палиндром. Дана следующая сигнатура метода:
public static boolean palindrom(int[] arr);
Необходимо реализовать метод таким образом, чтобы он возвращал true,
если массив arr является палиндромом, то есть справа-налево и наоборот читается одинаково
Пример 1:
arr=[1,-2,-7,4,2,2,5]
результат: false
Пример 2:
arr=[1,-2,-7,4,-7,-2,1]
результат: true
 */

public static void main(String[] args) {
    int[] arr1 = {1, -2, -7, 4, 2, 2, 5};
    int[] arr2 = {1, -2, -7, 4, -7, -2, 1};

    System.out.println(palindrom(arr1)); // Вывод: false
    System.out.println(palindrom(arr2)); // Вывод: true
    }
public static boolean palindrom(int[] arr) {
    // Проверка на пустой массив или массив с одним элементом
    if (arr == null || arr.length <= 1) {
        return true; // Пустой массив или массив с одним элементом считается палиндромом
        }

    int left = 0; // Левый указатель
    int right = arr.length - 1; // Правый указатель

    // Сравниваем элементы, пока указатели не встретятся
    while (left < right) {
        if (arr[left] != arr[right]) {
            return false; // Если элементы не равны, массив не палиндром
            }
        left++;
        right--;
        }

    return true; // Если все пары элементов равны, массив палиндром
    }
/*
задача 5.6
5.6 Реверс. Дана следующая сигнатура метода:
public static void reverse(int[] arr);
Необходимо реализовать метод таким образом, чтобы он изменял массив arr. После проведенных изменений массив должен быть записан задом-наперед
Пример:
arr=[1,2,3,4,5]
результат: arr=[5,4,3,2,1]
 */
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    reverse(arr);

    // Выводим результат
    for (int num : arr) {
        System.out.print(num + " "); // Вывод: 5 4 3 2 1
    }
}

public static void reverse(int[] arr) {
    if (arr == null || arr.length <= 1) {
        return; // Если массив пустой или состоит из одного элемента, ничего не делаем
    }

    int left = 0; // Левый указатель
    int right = arr.length - 1; // Правый указатель

    // Пока левый указатель меньше правого
    while (left < right) {
        // Меняем местами элементы
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        // Сдвигаем указатели
        left++;
        right--;
    }
}


/*
задача 5.7
5.7 Возвратный реверс. Дана следующая сигнатура метода:
public static int[] reverseBack(int[] arr);
Необходимо реализовать метод таким образом, чтобы он возвращал новый массив,
в котором значения массива arr записаны задом наперед.
Пример:
arr=[1,2,3,4,5]
результат: [5,4,3,2,1]
 */
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int[] reversedArray = reverseBack(arr);

    // Выводим результат
    for (int num : reversedArray) {
        System.out.print(num + " "); // Вывод: 5 4 3 2 1
    }
}

public static int[] reverseBack(int[] arr) {
    // Проверка на пустой массив
    if (arr == null) {
        return null; // Если массив равен null, возвращаем null
    }

    // Создаем новый массив для результат
    int[] reversed = new int[arr.length];

    // Заполняем новый массив элементами в обратном порядке
    for (int i = 0; i < arr.length; i++) {
        reversed[i] = arr[arr.length - 1 - i];
    }

    return reversed; // Возвращаем новый массив
}

/*
5.8 Объединение. Дана следующая сигнатура метода:
public static int[] concat(int[] arr1, int[] arr2);
Необходимо реализовать метод таким образом, чтобы он возвращал новый массив, в котором сначала идут элементы первого массива (arr1), а затем второго (arr2).
Пример:
arr1=[1,2,3]
arr2=[7,8,9]
результат: [1,2,3,7,8,9]
 */

public static void main(String[] args) {
    int[] arr1 = {1, 2, 3};
    int[] arr2 = {7, 8, 9};

    int[] concatenatedArray = concat(arr1, arr2);

    // Выводим результат
    for (int num : concatenatedArray) {
        System.out.print(num + " "); // Вывод: 1 2 3 7 8 9
    }
}

public static int[] concat(int[] arr1, int[] arr2) {
    // Проверяем, не равны ли массивы null
    if (arr1 == null && arr2 == null) {
        return null; // Если оба массива равны null, возвращаем null
    }

    // Определяем размеры массивов
    int length1 = (arr1 != null) ? arr1.length : 0;
    int length2 = (arr2 != null) ? arr2.length : 0;

    // Создаем новый массив с общей длиной
    int[] result = new int[length1 + length2];

    // Копируем элементы первого массива
    if (arr1 != null) {
        System.arraycopy(arr1, 0, result, 0, length1);
    }

    // Копируем элементы второго массива
    if (arr2 != null) {
        System.arraycopy(arr2, 0, result, length1, length2);
    }

    return result; // Возвращаем объединенный массив
}

/* 5.9 Все вхождения. Дана следующая сигнатура метода:
public static int[] findAll(int[] arr, int x);
Необходимо реализовать метод таким образом, чтобы он возвращал
новый массив, в котором записаны индексы всех вхождений числа x в массив arr.
Пример: arr=[1,2,3,8,2,2,9] x=2
результат: [1,4,5]
*/
import java.util.ArrayList;
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 8, 2, 2, 9};
    int x = 2;

    int[] indices = findAll(arr, x);

    // Выводим результат
    for (int index : indices) {
        System.out.print(index + " "); // Вывод: 1 4 5
    }
}

public static int[] findAll(int[] arr, int x) {
    // Используем список для хранения индексов
    ArrayList<Integer> indexList = new ArrayList<>();

    // Проходим по массиву и ищем вхождения x
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == x) {
            indexList.add(i); // Добавляем индекс в список
        }
    }

    // Преобразуем список в массив и возвращаем
    int[] result = new int[indexList.size()];
    for (int i = 0; i < indexList.size(); i++) {
        result[i] = indexList.get(i);
    }

    return result;
}

/*
5.10 Удалить негатив. Дана следующая сигнатура метода:
public static int[] deleteNegative(int[] arr);
Необходимо реализовать метод таким образом, чтобы он
возвращал новый массив, в котором записаны все элементы массива arr кроме отрицательных.
Пример:
arr=[1,2,-3,4,-2,2,-5]
результат: [1,2,4,2]
 */
import java.util.ArrayList;
public static void main(String[] args) {
    int[] arr = {1, 2, -3, 4, -2, 2, -5};

    int[] result = deleteNegative(arr);

    // Выводим результат
    for (int num : result) {
        System.out.print(num + " "); // Вывод: 1 2 4 2
    }
}

public static int[] deleteNegative(int[] arr) {
    // Используем список для хранения положительных элементов
    ArrayList<Integer> positiveList = new ArrayList<>();

    // Проходим по массиву и добавляем положительные элементы в список
    for (int num : arr) {
        if (num >= 0) {
            positiveList.add(num);
        }
    }

    // Преобразуем список в массив и возвращаем
    int[] result = new int[positiveList.size()];
    for (int i = 0; i < positiveList.size(); i++) {
        result[i] = positiveList.get(i);
    }

    return result;
}

/*
5.11 Добавление в массив. Дана следующая сигнатура метода:
public static int[] add(int[] arr, int x, int pos);
Необходимо реализовать метод таким образом, чтобы он возвращал новый массив, который будет содержать
все элементы массива arr, однако в позицию pos будет вставлено значение x.
Пример:
arr=[1,2,3,4,5]
x=9
pos=3
результат: [1,2,3,9,4,5]
 */
public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int x = 9;
        int pos = 3;

        int[] result = add(arr, x, pos);

        // Выводим результат
        for (int num : result) {
            System.out.print(num + " "); // Вывод: 1 2 3 9 4 5
        }
    }

    public static int[] add(int[] arr, int x, int pos) {
        // Создаем новый массив размером на 1 больше, чем arr
        int[] result = new int[arr.length + 1];

        // Копируем элементы до позиции pos
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        // Вставляем значение x на позицию pos
        result[pos] = x;

        // Копируем оставшиеся элементы
        for (int i = pos; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }

        return result;
    }

/*
5.12 Добавление массива в массив. Дана следующая сигнатура метода:
public static int[] add(int[] arr, int[] ins, int pos);
Необходимо реализовать метод таким образом, чтобы он возвращал
новый массив, который будет содержать все элементы массива arr,
однако в позицию pos будут вставлены значения массива ins.
Пример:
arr=[1,2,3,4,5]
ins=[7,8,9]
pos=3
результат: [1,2,3,7,8,9,4,5]
 */

import java.util.Arrays;
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int[] ins = {7, 8, 9};
    int pos = 3;

    int[] result = add(arr, ins, pos);

    // Выводим результат
    System.out.println(Arrays.toString(result)); // Вывод: [1, 2, 3, 7, 8, 9, 4, 5]
}

public static int[] add(int[] arr, int[] ins, int pos) {
    // Создаем новый массив с размером arr.length + ins.length
    int[] result = new int[arr.length + ins.length];

    // Копируем элементы из arr до позиции pos
    for (int i = 0; i < pos; i++) {
        result[i] = arr[i];
    }

    // Вставляем элементы из ins
    for (int i = 0; i < ins.length; i++) {
        result[pos + i] = ins[i];
    }

    // Копируем оставшиеся элементы из arr
    for (int i = pos; i < arr.length; i++) {
        result[i + ins.length] = arr[i];
    }

    return result;
}
