package com.basic.net;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;

public class URLBuilder {

	private String url;
	private Map<String, String> params = new LinkedHashMap<>();

	/**
	 * http://localhost:8080/cloud24_ctrl
	 */
	private static String contextPath(HttpServletRequest req) {
		return req.getRequestURL().toString().replace(req.getRequestURI(), req.getContextPath());
	}

	private URLBuilder(final String url) {
		this.url = url;
	}

	public static URLBuilder build(final String url) {
		return new URLBuilder(url);
	}

	public static URLBuilder build(final HttpServletRequest request, final String path) {
		String url = contextPath(request) + "/" + path;
		return new URLBuilder(url);
	}

	/**
	 * Thêm queryString
	 */
	public URLBuilder addParameter(String param, String value) {
		if (StringUtils.isNotEmpty(param) && StringUtils.isNotEmpty(value)) {
			params.put(param, value);
		}
		return this;
	}

	public String toURL() {
		if (this.params.isEmpty()) {
			return this.url;
		}
		StringBuilder join = new StringBuilder();
		Set<String> keys = this.params.keySet();
		for (String k : keys) {
			String v = this.params.get(k);
			join.append("&").append(k).append("=").append(v);
		}
		join.setCharAt(0, '?');
		return this.url + join.toString();
	}

	public static void todo() {
		URLBuilder buider = URLBuilder.build("https://www.youtube.com/watch");
		buider.addParameter("v", "3AtDnEC4zak").addParameter("t", "20s");
		System.out.println(buider.toURL());
	}

	public static void usingUriBuilder() throws URISyntaxException {
		String url = "https://www.youtube.com/watch";
		URI uri = new URIBuilder(url).addParameter("v", "3AtDnEC4zak").addParameter("t", "20s").build();
		System.out.println(uri.toString());
	}

	public static void main(String[] args) throws URISyntaxException {
		todo();
		usingUriBuilder();
	}

}
