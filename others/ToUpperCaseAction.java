// ToUpperCaseAction.java Задача 9.2.6 Стриминг платформа.

package ru.Balakireva.stream;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ToUpperCaseAction {

    public List<String> execute(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}

// RemoveAAction.java
package ru.Balakireva.stream;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RemoveAAction {

    public List<String> execute(List<String> data) {
        return data.stream()
                .map(s -> s.replace("A", ""))
                .collect(Collectors.toList());
    }
}

// FilterLongWordsAction.java
package ru.Balakireva.stream;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterLongWordsAction {

    public List<String> execute(List<String> data) {
        return data.stream()
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList());
    }
}