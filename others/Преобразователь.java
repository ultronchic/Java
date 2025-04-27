package ru.Balakireva.others;

@FunctionalInterface
interface DocumentOpener {
    String open(String filename);
}

@FunctionalInterface
interface DataTransformer {
    String transform(String data);
}

@FunctionalInterface
interface DocumentWriter {
    void write(String data, String filename);
}
public class Преобразователь {
    private final DocumentOpener opener;
    private final DataTransformer transformer;
    private final DocumentWriter writer;

    public Преобразователь(DocumentOpener opener, DataTransformer transformer, DocumentWriter writer) {
        this.opener = opener;
        this.transformer = transformer;
        this.writer = writer;
    }

    public void convert(String inputFilename, String outputFilename) {
        // Открываем документ
        String data = opener.open(inputFilename);
        // Преобразуем данные
        String transformedData = transformer.transform(data);
        // Записываем новый документ
        writer.write(transformedData, outputFilename);
    }
}