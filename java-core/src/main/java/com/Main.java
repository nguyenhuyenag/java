package com;

import java.util.LinkedHashMap;
import java.util.Map;

class URLBuider {

	private String url;
	private Map<String, String> params = new LinkedHashMap<>();

	public URLBuider(String url) {
		this.url = url;
	}

	public URLBuider addParam(String param, String value) {
		params.put(param, value);
		return this;
	}

	public String toURL() {
		StringBuilder join = new StringBuilder();
		this.params.forEach((k, v) -> {
			join.append("&").append(k).append("=").append(v);
		});
		join.setCharAt(0, '?');
		return this.url + join.toString();
	}

}

public class Main {

	public static void main(String[] args) {
		URLBuider buider = new URLBuider("https://www.youtube.com/watch");
		buider.addParam("key", "M9ENO7Liee4") //
				.addParam("name", "huyennv");
		System.out.println(buider.toURL());
	}

}
