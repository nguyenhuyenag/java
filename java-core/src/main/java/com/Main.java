package com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import lombok.SneakyThrows;

public class Main {

	@SneakyThrows
	public String resourceAsString() {
		try (InputStream is = this.getClass().getResourceAsStream("sure_in_my_jar.txt")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			return br.lines().collect(Collectors.joining("\n"));
		}
	}

	public static void main(String[] args) {

	}

}
