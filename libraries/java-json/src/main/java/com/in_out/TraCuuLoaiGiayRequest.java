package com.in_out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
    Jackson mặc định ưu tiên getter/setter. Nếu không dùng @JsonProperty trên getter,
    thì nó sẽ lấy tên biến `maSoBHXH` thay vì `ma_so_bhxh`
 */
@Data
public class TraCuuLoaiGiayRequest {

    @JsonProperty("ma_so_bhxh")
    private String maSoBHXH;

    @JsonProperty("tu_ngay")
    private String tuNgay;

    @JsonProperty("den_ngay")
    private String denNgay;

    @JsonProperty("ma_nhom_huong")
    private String maNhomHuong; // "O1"

}
