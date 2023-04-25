package com.lombox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.UnsupportedCharsetException;
import java.util.stream.Collectors;

import lombok.SneakyThrows;

public class CheckedException {

	public String resourceAsString() {
		try (InputStream is = this.getClass().getResourceAsStream("sure_in_my_jar.txt")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			return br.lines().collect(Collectors.joining("\n"));
		} catch (IOException | UnsupportedCharsetException ex) {
			// If this ever happens, then its a bug.
			throw new RuntimeException(ex); // encapsulate into a Runtime ex.
		}
	}

	@SneakyThrows
	public String resourceAsStringLombox() {
		try (InputStream is = this.getClass().getResourceAsStream("sure_in_my_jar.txt")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			return br.lines().collect(Collectors.joining("\n"));
		}
	}

}
