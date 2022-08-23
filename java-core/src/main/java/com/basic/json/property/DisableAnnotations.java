package com.basic.json.property;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
// @JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "name", "id" }) // sắp xếp field
public class DisableAnnotations {
	
	public int id;
    public String name;
    
    public static void main(String[] args) throws JsonProcessingException {
    	DisableAnnotations bean = new DisableAnnotations(1, null);
    	ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(MapperFeature.USE_ANNOTATIONS); // disable all Jackson annotations
        String result = mapper.writeValueAsString(bean);
        System.out.println(result);
	}
	
}
