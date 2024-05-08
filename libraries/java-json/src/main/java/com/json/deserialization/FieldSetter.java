package com.json.deserialization;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*-
 * + @JsonSetter cho phép Jackson xác định tên của thuộc tính Java tương ứng với một key trong JSON
 * 
 * 			@JsonSetter("carBrand") 
 * 			private String brand;
 * 
 * 	 hoặc
 * 
 * 			@JsonSetter("name") 
 * 			public void setName(String name) { 
 * 				this.name = name;
 * 			}
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Car {

	@JsonSetter("carBrand")
	private String brand;

}

public class FieldSetter {

	protected static void jsonSetter() throws Exception {
		String json = "{ \"carBrand\" : \"BMW\"  }";
		ObjectMapper objectMapper = new ObjectMapper();
		Car car = objectMapper.readValue(json, Car.class);
		System.out.println(car.getBrand());
	}

	public static void main(String[] args) throws Exception {
		jsonSetter();
	}

}
