package com.basic.json;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.basic.ClipboardUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.util.Base64Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class A {

	String name;
	int age;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class B extends A {

	@JsonIgnore
	String name;
	int height;

}

public class KeThua {

	public static void main(String[] args) throws JsonProcessingException {
		// test();
		B bean = new B("Lac", 177);
		bean.setAge(24);
		System.out.println(new ObjectMapper().writeValueAsString(bean));
	}

	public static void test() {
		Path path = Paths.get("C:/Users/huyennv/Desktop/tax-conver/05_GTGT_TT80_2022.xlsx");
		String base64 = Base64Utils.encodeToString(path);
		System.out.println(base64.trim());
		ClipboardUtils.copy(base64);
	}

}
