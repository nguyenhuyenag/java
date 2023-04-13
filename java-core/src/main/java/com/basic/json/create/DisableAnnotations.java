package com.basic.json.create;

import com.basic.json.PrettyJson;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonPropertyOrder({ "name", "id" }) // sắp xếp field
public class DisableAnnotations extends PrettyJson {

	public int id;
	public String name;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws JsonProcessingException {
		DisableAnnotations bean = new DisableAnnotations(1, null);

		 ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.disable(MapperFeature.USE_ANNOTATIONS); // disable all Jackson annotations

		System.out.println(bean.toJSON(objectMapper));
	}

}
