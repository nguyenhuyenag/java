package com.lambda.fi.function;

import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

public class FunctionExample5 {

	/**
	 * IntFunction: chấp nhận một đối số đầu vào kiểu int và kết quả đầu ra là kiểu
	 * bất kỳ.
	 * 
	 * LongFunction: chấp nhận một đối số đầu vào kiểu long và kết quả đầu ra là
	 * kiểu bất kỳ.
	 * 
	 * DoubleFunction: chấp nhận một đối số đầu vào kiểu double và kết quả đầu ra là
	 * kiểu bất kỳ.
	 */

	public static void main(String[] args) {

		IntFunction<String> ifunc = (x) -> Integer.toString(x * x);
		LongFunction<String> lfunc = (x) -> Long.toString(x * x);
		DoubleFunction<String> dfunc = (x) -> Double.toString(x * x);

		System.out.println(ifunc.apply(3)); // 9
		System.out.println(lfunc.apply(5)); // 25
		System.out.println(dfunc.apply(10)); // 100.0
	}
}
