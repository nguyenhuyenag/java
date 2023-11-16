package com.json.preview;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.JsonUtils;

public class JACKSONInject {

	@JacksonInject
	public int id;

	public String name;

	public static void main(String[] args) throws Exception {
		String json = "{\"name\": \"Injectable Values\"}";

		InjectableValues inject = new InjectableValues.Std() //
				.addValue(int.class, 100000);
		
		JACKSONInject bean = new ObjectMapper() //
				.reader(inject) //
				.forType(JACKSONInject.class) //
				.readValue(json);
		
		System.out.println(JsonUtils.toJSON(bean));
	}

}
