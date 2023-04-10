package com.v11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class HttpClient11 {

	public String post(String url, String data) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder() //
				.uri(URI.create(url)) //
				.header("Content-Type", "application/json") //
				// ofByteArray(), ofByteArrays(), ofFile(), ofInputStream()
				.POST(BodyPublishers.ofString(data)) //
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		if (response.statusCode() != 200) {
			throw new IOException("HTTP response status: " + response.statusCode());
		}
		return response.body();
	}

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		// HttpClient httpClient = HttpClient.newHttpClient();
		HttpClient httpClient = HttpClient.newBuilder() //
				.version(HttpClient.Version.HTTP_2) //
				.connectTimeout(Duration.ofSeconds(10)) //
				.build();
		try {
			HttpRequest request = HttpRequest.newBuilder() //
					.GET() //
					.uri(URI.create("https://www.google.com")) //
					.build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println("Status code: " + response.statusCode());
			System.out.println("Headers: " + response.headers().allValues("content-type"));
			System.out.println("Body: " + response.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
