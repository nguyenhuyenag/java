package com.v9.httpclient;

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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HandlingRequestBody {

	// Setting header
	public static HttpRequest settingHeader() {
		return HttpRequest.newBuilder() //
				.uri(URI.create("https://postman-echo.com/get?username=huyennv")) //
				.timeout(Duration.ofMinutes(1)) //
				.header("Content-Type", "application/json") //
				.header("key1", "value1") //
				.header("key2", "value2") //
				.GET() //
				.build();
	}

	// Creating a Body From a String
	public static HttpRequest fromAString() {
		return HttpRequest.newBuilder() //
				.header("Content-Type", "application/json") //
				.POST(HttpRequest.BodyPublishers.ofString("{\"name\": \"morpheus\",\"job\": \"leader\"}"))
				.uri(URI.create("https://reqres.in/api/users")).build();
	}

	// Creating a body from InputStream
	public static HttpRequest fromInputStream() throws URISyntaxException {
		byte[] sampleData = "Sample request body".getBytes();
		return HttpRequest.newBuilder() //
				.uri(new URI("https://postman-echo.com/post")) //
				.headers("Content-Type", "text/plain;charset=UTF-8") //
				.POST(HttpRequest.BodyPublishers.ofInputStream(() -> new ByteArrayInputStream(sampleData))) //
				.build();
	}

	public static HttpRequest fromByArray() throws URISyntaxException {
		byte[] sampleData = "Sample request body".getBytes();
		return HttpRequest.newBuilder() //
				.uri(new URI("https://postman-echo.com/post")) //
				.headers("Content-Type", "text/plain;charset=UTF-8") //
				.POST(HttpRequest.BodyPublishers.ofByteArray(sampleData)) //
				.build();
	}

	public static HttpRequest fromFile() throws FileNotFoundException, URISyntaxException {
		return HttpRequest.newBuilder() //
				.uri(new URI("https://postman-echo.com/post")) //
				.headers("Content-Type", "text/plain;charset=UTF-8") //
				.POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file/Java9ImmutableCollections.webp"))) //
				.build();
	}

	public static void main(String[] args)
			throws FileNotFoundException, URISyntaxException, InterruptedException, ExecutionException {
		HttpRequest requestBody = fromFile();
		CompletableFuture<String> thenApply = HttpClient.newHttpClient() //
				.sendAsync(requestBody, BodyHandlers.ofString()) //
				.thenApply(HttpResponse::body); //
				// .thenAccept(System.out::println) //
				// .join();
		System.out.println(thenApply.get());
	}

}
