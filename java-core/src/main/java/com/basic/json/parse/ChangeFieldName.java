package com.basic.json.parse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.util.JsonUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeFieldName {

	@JsonProperty("_id") // Đóng dòng này và run
	public int id;

	private String name;

	// @JsonProperty annotation to indicate the property name in JSON
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "{\"_id\": 12, \"name\": \"Green\"}";
		ChangeFieldName bean = new ObjectMapper() //
				.readerFor(ChangeFieldName.class) //
				.readValue(json);
		System.out.println(JsonUtils.toJSON(bean));
	}

}
