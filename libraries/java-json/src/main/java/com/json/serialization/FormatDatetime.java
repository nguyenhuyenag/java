package com.json.serialization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormatDatetime {

    private String name;
    private Date date;

    // (1)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    // (2)
    // @JsonFormat(pattern = "dd/MM/yyyy")
    // @JsonSerialize(using = LocalDateSerializer.class)
    // @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate localDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime localDateTime;

    /**
     * Mặc định Jackson sẽ chuyển Date sang Timestamp (long) tính từ 1-1-1970 UTC
     * khi serialize sang Json
     */
    public static void basicDateWithoutFormat() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        FormatDatetime bean = FormatDatetime.builder()
                .date(new Date())
                .build();
        System.out.println(mapper.writeValueAsString(bean));
    }

    public static void basicDateFormat() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"));
        FormatDatetime bean = FormatDatetime.builder()
                .date(new Date())
                .build();
        System.out.println(mapper.writeValueAsString(bean));
    }

    public static void localDateWithoutFormat() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        FormatDatetime bean = FormatDatetime.builder()
                .localDate(LocalDate.now())
                .localDateTime(LocalDateTime.now())
                .build();
        System.out.println(mapper.writeValueAsString(bean));
    }

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        basicDateWithoutFormat();
        basicDateFormat();
        localDateWithoutFormat();
    }

}
