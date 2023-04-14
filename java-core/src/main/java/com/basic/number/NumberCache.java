package com.basic.number;

public class NumberCache {

	/*-
	 * Giá trị khởi tạo
	 * 
	 * 		object					=>	null
	 * 
	 * 		int/short/byte/long 	=> 	0
	 * 
	 * 		float/double 			=> 	0.0
	 * 
	 * 		boolean 				=> 	false
	 * 
	 * 		char					=>	'\u0000'
	 */
	public final byte	BYTE_MIN 		= -128;						// -2^7
	public final byte 	BYTE_MAX 		= 127; 						//  2^7	 - 1
	public final short	SHORT_MIN 		= -32768; 					// -2^15
	public final short 	SHORT_MAX 		= 32767; 					//  2^15 - 1
	public final int 	INT_MIN 		= -2147483648; 				// -2^31
	public final int 	INT_MAX 		= 2147483647; 				//  2^31 - 1
	public final long 	LONG_MIN 		= -9223372036854775808L;	// -2^63
	public final long 	LONG_MAX 		= 9223372036854775807L; 	//  2^63 - 1
	
	/**
	 * Các giá trị của Integer thuộc [-128, 127] được lưu trữ trong một bộ nhớ đệm
	 * "Integer Cache". Khi khởi tạo một biến Integer với giá trị trong khoảng này,
	 * Java sẽ trả về một đối tượng đã được lưu trữ trong Integer Cache. Và khi so
	 * sánh hai biến Integer được khởi tạo với giá trị trong khoảng này bằng toán tử
	 * ==, chúng sẽ có cùng địa chỉ bộ nhớ và kết quả sẽ là true.
	 * 
	 * Tuy nhiên, nếu giá trị của Integer nằm ngoài khoảng từ -128 đến 127, hoặc
	 * được khởi tạo bằng cách sử dụng từ khóa new, thì sẽ không sử dụng Integer
	 * Cache và kết quả so sánh bằng toán tử == sẽ là false.
	 * 
	 * Tương tự cho các kiểu dữ liệu Wrapper
	 */
	public static void test() {
		Integer a1 = 1;
		Integer a2 = 1;
		System.out.println(a1 == a2); // true

		Integer b1 = 1000;
		Integer b2 = 1000;
		System.out.println(b1 == b2); // false
	}

}
