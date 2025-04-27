package ru.Balakireva.geometry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/ultronchic/IdeaProjects/MIPT/src/ru/Balakireva/others/Names.txt"; // Путь к текстовику с именами
        try {
            Map<Integer, List<String>> groupedNames = Files.lines(Paths.get(filePath))
                    .map(line -> line.split(":")) // Разделяем строку на имя и номер
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty()) // Убираем людей без номеров
                    .collect(Collectors.toMap(
                            parts -> Integer.parseInt(parts[1]), // Номер как ключ
                            parts -> capitalize(parts[0]), // Имя с заглавной буквы
                            (existing, replacement) -> existing + ", " + replacement // Объединяем имена с одинаковыми номерами
                    ));

            System.out.println(groupedNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
    }
}