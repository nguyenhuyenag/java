package com.in_out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.JsonUtils;

public class MyTest {

    // Input as snake_case, output as snake_case
    public static void snakeToSnake(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TraCuuLoaiGiayRequest request = mapper.readValue(json, TraCuuLoaiGiayRequest.class);
        System.out.println(JsonUtils.toJSON(request));
    }

    public static void snake2(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TraCuuLoaiGiayRequestSnake request = mapper.readValue(json, TraCuuLoaiGiayRequestSnake.class);
        System.out.println(JsonUtils.toJSON(request));
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\n" +
                "  \"ma_so_bhxh\": \"0123194719\",\n" +
                "  \"tu_ngay\": \"01/01/2025\",\n" +
                "  \"den_ngay\": \"01/01/2026\",\n" +
                "  \"ma_nhom_huong\": \"O1\"\n" +
                "}";

        // Convert snake_case to snake_case
        // snakeToSnake(json);
        snake2(json);
    }

}
