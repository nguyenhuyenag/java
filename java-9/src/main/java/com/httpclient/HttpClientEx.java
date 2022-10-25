package com.httpclient;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Paths;
import java.time.Duration;

public class HttpClientEx {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		HttpRequest getRequest = HttpRequest.newBuilder() //
				.uri(URI.create("https://postman-echo.com/get?username=huyennv")) //
				.timeout(Duration.ofMinutes(1)) //
				.header("Content-Type", "application/json") //
				.header("key1", "value1") //
				.header("key2", "value2") //
				.GET() //
				.build();

		HttpRequest postRequest = HttpRequest.newBuilder() //
				.uri(new URI("https://postman-echo.com/post")) //
				.headers("Content-Type", "text/plain;charset=UTF-8") //
				.POST(HttpRequest.BodyPublishers.ofString("Sample request body")).build();

		byte[] sampleData = "Sample request body".getBytes();
		HttpRequest postRequestInputStream = HttpRequest.newBuilder() //
				.uri(new URI("https://postman-echo.com/post")) //
				.headers("Content-Type", "text/plain;charset=UTF-8") //
				.POST(HttpRequest.BodyPublishers.ofInputStream(() -> new ByteArrayInputStream(sampleData))) //
				.build();

		// byte[] sampleData = "Sample request body".getBytes();
		HttpRequest postRequestByteArray = HttpRequest.newBuilder() //
				.uri(new URI("https://postman-echo.com/post")) //
				.headers("Content-Type", "text/plain;charset=UTF-8") //
				.POST(HttpRequest.BodyPublishers.ofByteArray(sampleData)) //
				.build();

		HttpRequest postRequestFile = HttpRequest.newBuilder() //
				.uri(new URI("https://postman-echo.com/post")) //
				.headers("Content-Type", "text/plain;charset=UTF-8") //
				.POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file/Java9ImmutableCollections.webp"))) //
				.build();

		HttpClient.newHttpClient() //
				.sendAsync(postRequestFile, BodyHandlers.ofString()) //
				.thenApply(HttpResponse::body) //
				.thenAccept(System.out::println) //
				.join();
	}

}
