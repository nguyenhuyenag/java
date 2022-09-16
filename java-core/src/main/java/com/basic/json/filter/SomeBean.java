package com.basic.json.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("SomeBeanName")
public class SomeBean {

	String field1;
	String field2;
	String field3;

	public static void main(String[] args) throws JsonProcessingException {
		SomeBean bean = new SomeBean("value1", "value2", "value2");
		// mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		FilterProvider filters = new SimpleFilterProvider() //
				// .setFailOnUnknownId(false) //
				.addFilter("SomeBeanName", SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2"));
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.setFilterProvider(filters).writeValueAsString(bean));
	}

}
