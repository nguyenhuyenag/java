package com.basic.json.general;

import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JSONFormat {

	public String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	public Date eventDate;

	public static void main(String[] args) throws ParseException, JsonProcessingException {
		JSONFormat event = new JSONFormat("party", new Date());
		String result = new ObjectMapper().writeValueAsString(event);
		System.out.println(result);
	}

}
