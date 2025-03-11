package com.csv.model;

import com.opencsv.bean.CsvBindByName;

@lombok.Data
public class Data {

    @CsvBindByName(column = "Timestamp")
    private String timestamp;

    @CsvBindByName(column = "ISPPE")
    private String isppe;

    @CsvBindByName(column = "Sequence")
    private int sequence;

    @CsvBindByName(column = "Code")
    private String code;

    @CsvBindByName(column = "Severity")
    private String severity;

    @CsvBindByName(column = "State")
    private String state;

}
