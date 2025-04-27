// StreamProcessor.java 9.2.6 Стриминг платформа.
package ru.Balakireva.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StreamProcessor {

    private final DataReader dataReader;
    private final DataWriter dataWriter;
    private final ToUpperCaseAction toUpperCaseAction;
    private final RemoveAAction removeAAction;
    private final FilterLongWordsAction filterLongWordsAction;

    @Autowired
    public StreamProcessor(DataReader dataReader,
                           DataWriter dataWriter,
                           ToUpperCaseAction toUpperCaseAction,
                           RemoveAAction removeAAction,
                           FilterLongWordsAction filterLongWordsAction) {
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
        this.toUpperCaseAction = toUpperCaseAction;
        this.removeAAction = removeAAction;
        this.filterLongWordsAction = filterLongWordsAction;
    }

    public void process() {
        List<String> data = dataReader.readData();

        // Применяем действия последовательно
        data = toUpperCaseAction.execute(data);
        data = removeAAction.execute(data);
        data = filterLongWordsAction.execute(data);

        // Записываем результат в файл
        dataWriter.writeData(data);
    }
}