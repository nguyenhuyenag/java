package com.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.SystemUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class ReadByApacheCsv {

    public static void main(String[] args) {
        File filePath = Path.of(SystemUtils.USER_DIR, "file", "data.csv").toFile();
        try (Reader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
             CSVParser csvParser = new CSVParser(reader,
                     CSVFormat.DEFAULT
                             .builder()
                             .setHeader() // Automatically detects the first row as headers
                             .setSkipHeaderRecord(true) // Skips reading the header row
                             .setDelimiter(';')
                             .build())) {
            for (CSVRecord record : csvParser) {
                String timestamp = record.get("Timestamp");
                String isppe = record.get("ISPPE");
                String sequence = record.get("Sequence");
                String code = record.get("Code");
                String severity = record.get("Severity");
                String state = record.get("State");

                System.out.println("Timestamp: " + timestamp +
                        ", ISPPE: " + isppe +
                        ", Sequence: " + sequence +
                        ", Code: " + code +
                        ", Severity: " + severity +
                        ", State: " + state);
            }
        } catch (IOException e) {

        }
    }

}
