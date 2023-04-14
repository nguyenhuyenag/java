package com.basic.json.create;

import com.basic.json.PrettyJson;
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
@JsonFilter("MyBeanName")
public class FieldShowHide implements PrettyJson {

	String field1;
	String field2;
	String field3;
	String field4;
	String field5;

	// Hiển thị các field chỉ định
	public static FilterProvider showFields() {
		return new SimpleFilterProvider() //
				// .setFailOnUnknownId(false) //
				.addFilter("MyBeanName", SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3"));
	}

	// Ẩn các field chỉ định
	public static FilterProvider hiddenFields() {
		return new SimpleFilterProvider() //
				// .setFailOnUnknownId(false) //
				.addFilter("MyBeanName", SimpleBeanPropertyFilter.serializeAllExcept("field3", "field4"));
	}

	public static void main(String[] args) throws JsonProcessingException {
		FieldShowHide bean = new FieldShowHide();
		ObjectMapper mapper = new ObjectMapper();
		mapper.setFilterProvider(hiddenFields());
		System.out.println(bean.toJSON(mapper));
	}

}
