package com.csv;

import com.csv.model.LogEntry;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;

public class ReadByOpenCsv {

    public static void main(String[] args) {
        File filePath = Path.of(SystemUtils.USER_DIR, "file", "data.csv").toFile();
        try (Reader reader = new FileReader(filePath)) {
            CsvToBean<LogEntry> csvToBean = new CsvToBeanBuilder<LogEntry>(reader)
                    .withType(LogEntry.class)
                    .withSeparator(';')  // Use semicolon as delimiter
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withThrowExceptions(false) // Prevent exception on bad rows
                    .build();

            List<LogEntry> logEntries = csvToBean.parse();

            // Print parsed data
            logEntries.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
