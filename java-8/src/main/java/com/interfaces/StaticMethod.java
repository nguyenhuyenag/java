package com.interfaces;

interface Car {

	public static void isValid() {
		System.out.println("Vehicle is valid");
	}

	public void showLog();
}

public class StaticMethod implements Car {

	@Override
	public void showLog() {
		Car.isValid();
	}

}
