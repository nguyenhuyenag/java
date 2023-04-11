package com.basic;

/**
 * Các giá trị của kiểu Integer trong khoảng từ -128 đến 127 được lưu trữ trong
 * một bộ nhớ đệm "Integer Cache". Khi khởi tạo một biến Integer với giá trị
 * trong khoảng này, Java sẽ trả về một đối tượng đã được lưu trữ trong Integer
 * Cache. Và khi so sánh hai biến Integer được khởi tạo với giá trị trong khoảng
 * này bằng toán tử ==, chúng sẽ có cùng địa chỉ bộ nhớ và kết quả sẽ là true.
 * 
 * Tuy nhiên, nếu giá trị của Integer nằm ngoài khoảng từ -128 đến 127, hoặc
 * được khởi tạo bằng cách sử dụng từ khóa new, thì sẽ không sử dụng Integer
 * Cache và kết quả so sánh bằng toán tử == sẽ là false.
 * 
 * Tương tự cho các kiểu dữ liệu Wrapper
 *
 */
public class NumberCache {

	public static void main(String[] args) {
		Integer a1 = 1;
		Integer a2 = 1;
		System.out.println(a1 == a2); // true

		Integer b1 = 1000;
		Integer b2 = 1000;
		System.out.println(b1 == b2); // false
	}

}
