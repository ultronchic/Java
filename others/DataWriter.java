// FileDataReader.java
package ru.Balakireva.stream;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileDataReader implements DataReader {

    private String inputFileName;

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    @Override
    public List<String> readData() {
        try {
            return Files.readAllLines(Paths.get(inputFileName));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + inputFileName, e);
        }
    }
}

// FileDataWriter.java
package ru.Balakireva.stream;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileDataWriter implements DataWriter {

    private String outputFileName;

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    @Override
    public void writeData(List<String> data) {
        try {
            Files.write(Paths.get(outputFileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи в файл: " + outputFileName, e);
        }
    }
}