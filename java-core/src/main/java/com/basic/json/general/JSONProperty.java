package com.basic.json.general;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// then @JsonProperty annotation to indicate the property name in JSON
public class JSONProperty {

	@JsonProperty("_id") // Đóng dòng này và run
	public int id;
	
	private String name;

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "{\"_id\": 12, \"name\": \"Green\"}";
		JSONProperty bean = new ObjectMapper().readerFor(JSONProperty.class).readValue(json);
		System.out.println(bean.getName());
	}

}
