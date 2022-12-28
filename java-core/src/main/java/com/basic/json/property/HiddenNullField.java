package com.basic.json.property;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import common.util.JSONUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class HiddenNullField {

	private int id;
	private String phone;
	private String name;

	/*-
	 * Trong spring boot:
	 * 	
	 * 			spring.jackson.default-property-inclusion=non_null
	 */
	public static void main(String[] args) {
		HiddenNullField bean = new HiddenNullField(123, null, "Jackson");
		System.out.println(JSONUtils.toJSON(bean));
	}

}
