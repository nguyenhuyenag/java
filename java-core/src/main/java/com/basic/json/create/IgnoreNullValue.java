package com.basic.json.create;

import com.basic.json.PrettyJson;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(Include.NON_NULL) // Ignore that field with `empty/null/default` values
public class IgnoreNullValue extends PrettyJson {

	private int id;
	private String name;
	// @JsonInclude(JsonInclude.Include.NON_NULL)
	private String address;

	/*-
	 * Trong spring boot: spring.jackson.default-property-inclusion=non_null
	 */
	public static void main(String[] args) throws JsonProcessingException {
		IgnoreNullValue bean = new IgnoreNullValue(2023, null, "");
		System.out.println(bean.toJSON());
	}

}
