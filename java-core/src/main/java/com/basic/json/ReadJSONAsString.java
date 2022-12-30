package com.basic.json;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class ReadJSONAsString {

	public static void main(String[] agrs) throws IOException {
		String json = "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}";
		JsonFactory jfactory = new JsonFactory();
		try (JsonParser jParser = jfactory.createParser(json)) {
			List<String> addresses = new LinkedList<>();
			while (jParser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = jParser.getCurrentName();
				if ("name".equals(fieldname)) {
					jParser.nextToken();
					System.out.println("Name: " + jParser.getText());
				}
				if ("age".equals(fieldname)) {
					jParser.nextToken();
					System.out.println("Age: " + jParser.getIntValue());
				}
				if ("address".equals(fieldname)) {
					jParser.nextToken();
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						addresses.add(jParser.getText());
					}
					System.out.println("Address: " + String.join(", ", addresses));
				}
			}
		}
	}

}
