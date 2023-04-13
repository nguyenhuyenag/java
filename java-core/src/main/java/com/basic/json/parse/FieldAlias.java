package com.basic.json.parse;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // <- important for @JsonAlias
@JsonIgnoreProperties(ignoreUnknown = true) // ignore field that exists in json but not in bean, or using
											// objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
											// false);
public class FieldAlias {

	@JsonAlias({ "fName", "f_name" })
	private String firstName;
	private String lastName;

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "{\"f_name\": \"John\", \"lastName\": \"Green\", \"age\": 25}";

		FieldAlias bean = new ObjectMapper() //
				.readerFor(FieldAlias.class) //
				.readValue(json);

		System.out.println(bean.getLastName());
	}

}
