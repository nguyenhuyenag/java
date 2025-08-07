package com.in_out;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TraCuuLoaiGiayRequestSnake {

    private String maSoBHXH;
    private String tuNgay;
    private String denNgay;
    private String maNhomHuong;

}
