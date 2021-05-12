
package com;

import org.json.JSONObject;

import common.util.JsonUtils;

public class Main {

	public static void main(String[] args) {
		String jsonString = "{\"record\": {\"sample\": \"Hello World\",\"sample_2\": \"Hello World_2\"},  \"metadata\": {\"id\": \"value\",\"private\": \"true\"}}";
		System.out.println(jsonString);
		JSONObject json = JsonUtils.toJSONObject(jsonString);
		System.out.println(json.get("record"));
	}

}
