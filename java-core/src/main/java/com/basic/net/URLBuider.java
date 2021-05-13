package com.basic.net;

import java.util.LinkedHashMap;
import java.util.Map;

public class URLBuider {

	private String url;
	private Map<String, String> params = new LinkedHashMap<>();

	public URLBuider(final String url) {
		this.url = url;
	}

	public URLBuider addParameter(String param, String value) {
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

	public static void main(String[] args) {
		URLBuider buider = new URLBuider("https://www.youtube.com/watch");
		buider.addParameter("v", "3AtDnEC4zak").addParameter("t", "20s");
		System.out.println(buider.toURL());
	}

}
