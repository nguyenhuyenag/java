package com.basic.json.create;

import com.basic.json.PrettyJson;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonRootName(value = "__USER")
public class RootName extends PrettyJson {

	public int id;
	public String name;

	public static void main(String[] args) throws JsonProcessingException {
		RootName bean = new RootName(2, "Java");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE); // wrapping is enabled
		System.out.println(bean.toJSON(mapper));
	}

}
