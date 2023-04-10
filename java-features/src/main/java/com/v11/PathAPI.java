package com.v11;

import java.nio.file.Path;

public class PathAPI {
	
	public static void main(String[] args) {
		// Relative path foo/bar/baz
		Path.of("foo/bar/baz");
		Path.of("foo", "bar/baz");
		Path.of("foo", "bar", "baz");

		// Absolute path /foo/bar/baz
		Path.of("/foo/bar/baz");
		Path.of("/foo", "bar", "baz");
		Path.of("/", "foo", "bar", "baz");
	}
	
}
