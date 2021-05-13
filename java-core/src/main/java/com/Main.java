package com;

import com.basic.net.URLBuider;

public class Main {

	public static void main(String[] args) {
		URLBuider buider = new URLBuider("https://www.youtube.com/watch");
		buider.addParameter("v", "3AtDnEC4zak").addParameter("t", "20s");
		System.out.println(buider.toURL());
	}

}
