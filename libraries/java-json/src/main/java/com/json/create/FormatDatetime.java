package com.json.create;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.json.PrettyJson;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatDatetime implements PrettyJson {

	private String name;
	private Date date;

	// (1)
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	// (2)
	@JsonFormat(pattern = "yyyy/MM/dd")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate localDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime localDateTime;

	/**
	 * Mặc định Jackson sẽ chuyển Date sang Timestamp (long) tính từ 1-1-1970 UTC
	 * khi serialize sang Json
	 */
	public static void main(String[] args) throws ParseException, JsonProcessingException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		FormatDatetime bean = FormatDatetime.builder()
				.name("Jame")
				.date(new Date())
				.localDate(LocalDate.now())
				.localDateTime(LocalDateTime.now())
				.build();

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());

		System.out.println("Without format: ");
		System.out.println(mapper.writeValueAsString(bean));

		System.out.println("Format: ");
		// mapper.setDateFormat(df);
		System.out.println(mapper.writeValueAsString(bean));
	}

}
