package com.json.jsonobject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("./file/data.json");
		String jsonString = Files.readString(path);
		// System.out.println(jsonString);
		JSONObject jsonObject = new JSONObject(jsonString);
		// JSONArray
		JSONArray family = jsonObject.getJSONArray("family");
		System.out.println(family);
		// JSONArray[1]
		JSONObject sonObject = family.getJSONObject(1);
		System.out.println(sonObject);
		JSONObject sonData = sonObject.getJSONObject("son");
		System.out.println(sonData);
		// JSONObject
		JSONObject address = jsonObject.getJSONObject("address");
		System.out.println(address);
	}

}
