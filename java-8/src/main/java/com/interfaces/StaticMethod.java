package com.interfaces;

interface Car {

	public void showLog();

	public static void isValid() {
		System.out.println("Vehicle is valid");
	}

}

public class StaticMethod implements Car {

	@Override
	public void showLog() {
		Car.isValid();
	}

}
