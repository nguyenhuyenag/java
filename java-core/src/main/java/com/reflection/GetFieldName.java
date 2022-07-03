package com.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@FieldNameConstants
public class GetFieldName {

	private String name;
	private int age;
	private double height;

	private static List<String> getFieldNamesForClass(Class<?> clazz) throws Exception {
		List<String> fieldNames = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fieldNames.add(fields[i].getName());
		}
		return fieldNames;
	}

	public static void main(String[] args) throws Exception {
		List<String> list = getFieldNamesForClass(GetFieldName.class);
		list.forEach(t -> System.out.println(t));
	}

}
