//package com.basic.json.deserialization;
//
//import com.fasterxml.jackson.annotation.JsonAlias;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//// @AllArgsConstructor
//public class JSONAlias {
//
//	@JsonAlias({ "fName", "f_name" })
//	private String firstName;
//	
//	private String lastName;
//
//	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
//		String json = "{\"fName\": \"John\", \"lastName\": \"Green\"}";
//		
//		JSONAlias bean = new ObjectMapper() //
//				.readerFor(JSONAlias.class) //
//				.readValue(json);
//		
//		System.out.println(bean.lastName);
//	}
//
//}
