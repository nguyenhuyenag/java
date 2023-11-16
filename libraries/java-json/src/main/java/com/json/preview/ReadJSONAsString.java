package com.json.preview;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class ReadJSONAsString {

	public static void main(String[] agrs) throws IOException {
		String json = "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}";
		JsonFactory factory = new JsonFactory();
		try (JsonParser parser = factory.createParser(json)) {
			List<String> addresses = new LinkedList<>();
			while (parser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = parser.getCurrentName();
				if ("name".equals(fieldname)) {
					parser.nextToken();
					System.out.println("Name: " + parser.getText());
				}
				if ("age".equals(fieldname)) {
					parser.nextToken();
					System.out.println("Age: " + parser.getIntValue());
				}
				if ("address".equals(fieldname)) {
					parser.nextToken();
					while (parser.nextToken() != JsonToken.END_ARRAY) {
						addresses.add(parser.getText());
					}
					System.out.println("Address: " + String.join(", ", addresses));
				}
			}
		}
	}

}
