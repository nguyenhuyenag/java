package com.json.deserialization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // <- important for @JsonAlias
public class FieldAlias {

	@JsonAlias({ "fName", "f_name" })
	private String firstName;
	private String lastName;

	public static void main(String[] args) throws JsonProcessingException {
		String json = "{\"f_name\": \"John\", \"lastName\": \"Green\"}";

		FieldAlias bean = new ObjectMapper() //
				.readerFor(FieldAlias.class) //
				.readValue(json);

		System.out.println(bean.getLastName());
	}

}
