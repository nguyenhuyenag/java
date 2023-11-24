package com;

import java.io.File;
import java.nio.file.Paths;

import org.apache.commons.lang3.SystemUtils;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor  
@AllArgsConstructor  
@Getter  
class Car { 
	
    @JsonSetter("carBrand")  
    private String brand;  
    
}

public class Main {

	public static void main(String[] args) throws Exception {
		File file = Paths.get(SystemUtils.USER_DIR, "file/car.json").toFile();  
	    ObjectMapper objectMapper = new ObjectMapper();
		Car car = objectMapper.readValue(file, Car.class); 
		System.out.println(car.getBrand());
	}

}
