package com.basic.lombok;

import lombok.val;
import lombok.var;

public class ValAndVar {

	public static void main(String[] args) {

		val s = "1234"; // final String s = "1234"
		// s += "5"; 	// error
		System.out.println(s);

		var str = "1234"; // String s = "1234"
		str += "5";
		System.out.println(str);

	}

}
