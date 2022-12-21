package com.basic;

public class PrimitiveData {

	/**
	 * Giá trị khởi tạo
	 * 
	 * 		object					=>	NULL
	 * 
	 * 		int/short/byte/long 	=> 	0
	 * 
	 * 		float/double 			=> 	0.0
	 * 
	 * 		boolean 				=> 	false
	 * 
	 * 		char					=>	'\u0000'
	 */
	private static class Helper {
		private static final PrimitiveData INSTANCE = new PrimitiveData();
	}

	public static PrimitiveData getInstance() {
		return Helper.INSTANCE;
	}

	public final byte	BYTE_MIN 	= -128;						// -2^7
	public final byte 	BYTE_MAX 	= 127; 						//  2^7	 - 1
	public final short	SHORT_MIN 	= -32768; 					// -2^15
	public final short 	SHORT_MAX 	= 32767; 					//  2^15 - 1
	public final int 	INT_MIN 	= -2147483648; 				// -2^31
	public final int 	INT_MAX 	= 2147483647; 				//  2^31 - 1
	public final long 	LONG_MIN 	= -9223372036854775808L;	// -2^63
	public final long 	LONG_MAX 	= 9223372036854775807L; 	//  2^63 - 1
	
	/**
	 * Nếu 2 số integer giá trị 127 thì là true, còn 128 là false vì kiểu
	 * wrap này từ -128 tới 127 là range lưu trên memory. Ngoài khoảng này thì nó
	 * lại so sánh kiểu object
	 */
	public static void test() {
		Integer x = 128;
		Integer y = 128;
		System.out.println(x == y); // false
	}

}
