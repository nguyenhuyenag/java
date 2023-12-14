package com.v9.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandlingResponseBody {

	private static final HttpClient client = HttpClient.newHttpClient();
	private static final HttpRequest request = HttpRequest.newBuilder() //
			.uri(URI.create("https://reqres.in/api/users/2")) //
			.build();

	// Handling a Response Body as a String
	public static void ofString() throws IOException, InterruptedException {
		HttpResponse<String> responseOfString = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("Status code: " + responseOfString.statusCode());
		System.out.println("Body: " + responseOfString.body());
	}

	// Handling a Response Body as a File
	public static void ofFile() throws IOException, InterruptedException {
		HttpResponse<Path> responseOfFile = client.send(request,
				HttpResponse.BodyHandlers.ofFile(Path.of("file/response.json")));
		System.out.println("Status code: " + responseOfFile.statusCode());
		System.out.println("Body: " + responseOfFile.body());
	}

	// Handling a Response Body as a Byte Array
	public static void ofByteArray() throws IOException, InterruptedException {
		HttpResponse<byte[]> responseOfByteArray = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
		System.out.println("Status code: " + responseOfByteArray.statusCode());
		System.out.println("Body: " + new String(responseOfByteArray.body()));
	}

	// Handling a Response Body as an Input Stream
	public static void ofInputStream() throws IOException, InterruptedException {
		HttpResponse<InputStream> responseOfInputStream = client.send(request,
				HttpResponse.BodyHandlers.ofInputStream());
		System.out.println("Status code: " + responseOfInputStream.statusCode());
		try (InputStream fromIs = responseOfInputStream.body()) {
			byte[] allBytes = fromIs.readAllBytes();
			System.out.println("Body: " + new String(allBytes, StandardCharsets.UTF_8));
		}
	}

	// Handling a Response Body as a Stream of Strings
	public static void ofLines() throws IOException, InterruptedException {
		HttpResponse<Stream<String>> responseOfLines = client.send(request, HttpResponse.BodyHandlers.ofLines());
		System.out.println("Status code: " + responseOfLines.statusCode());
		System.out.println("Body: " + responseOfLines.body().collect(Collectors.toList()));
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// ofString();
		// ofFile();
		// ofByteArray();
		// ofInputStream();
		ofLines();
	}

}
