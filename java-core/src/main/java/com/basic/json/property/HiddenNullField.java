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
@JsonInclude(Include.NON_NULL) // Loại bỏ toàn bộ field Null trong class
public class HiddenNullField {

	private int id;
	// @JsonInclude(JsonInclude.Include.NON_NULL) // Loại bỏ field Null trong class
	private String phone;
	private String name;

	/*-
	 * Trong spring boot:
	 * 	
	 * 			spring.jackson.default-property-inclusion=non_null
	 */
	public static void main(String[] args) {
		HiddenNullField bean = new HiddenNullField(123, null, "Jackson");
		// Loại bỏ các thuộc tính Null ở tất cả class
		// ObjectMapper mapper = new ObjectMapper();
        // mapper.setSerializationInclusion(Include.NON_NULL);
		System.out.println(JSONUtils.toJSON(bean));
	}

}
