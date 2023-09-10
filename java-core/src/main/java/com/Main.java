package com;

public class Main {

	public static void main(String[] args) throws Exception {
		String uri = "/cp/static/css/bootstrap.min.css";
		String item = "/cp/static/";
		System.out.println(uri.startsWith(item));
	}

}
