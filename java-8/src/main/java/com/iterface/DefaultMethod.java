package com.iterface;

interface Samsung {

	public default void getName() {
		System.out.println("Samsung");
	}

	public default void getFullname() {

	}

}

/**
 * - Là phương thức cho phép định nghĩa một phần thân của phương thức trong
 * interface
 * 
 * - Có thể sử dụng trực tiếp hoặc override lại default method ()
 * 
 * - Khi Super class & Interface có cùng phương thức thì class con sẽ lấy phương
 * thức của super class
 */
public class DefaultMethod implements Samsung {

	@Override
	public void getFullname() {
		System.out.println("Samsung Company");
	}

	public static void main(String[] args) {
		DefaultMethod c = new DefaultMethod();
		c.getName();
		c.getFullname();
	}

}
