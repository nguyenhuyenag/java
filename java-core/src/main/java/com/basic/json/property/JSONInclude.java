package com.basic.json.property;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonInclude(Include.NON_NULL) // to exclude properties with empty/null/default values
public class JSONInclude {

	public int id;
	public String name;

	public static void main(String[] args) throws JsonProcessingException {
		JSONInclude bean = new JSONInclude(1, null);
		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

}
