// DataReader.java Задача 9.2.6 Стриминг платформа.
package ru.Balakireva.stream;

import java.util.List;

public interface DataReader {
    List<String> readData();
}

// DataWriter.java
package ru.Balakireva.stream;

import java.util.List;

public interface DataWriter {
    void writeData(List<String> data);
}