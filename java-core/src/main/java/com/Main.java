package com;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void start(TimeUnit unit, int limit) {
		long time = unit.toMillis(limit);
		System.out.println(time);
	}
	
	public static void main(String[] args) {
		// start(TimeUnit.HOURS, 2);
		String str = "Bài toán nghiên cứu. Ta có thể dựng được các n giác đều nào bằng thước, com-pa và trisector? Các trường hợp riêng: n = 7, 13, 19, 37.\r\n" + 
				"Bài toán nghiên cứu. Xây dựng thuật toán tìm bậc của mỗi số đại số từ mở rộng trường \\[\\mathbb{Q}(\\sqrt[k]{{{p}_{1}}},...,\\sqrt[k]{{{p}_{n}}})\\] với \\[{{p}_{1}},...,{{p}_{n}}\\] là các số nguyên tố phân biệt. Các trường hợp đặc biệt: \\[k=2\\], k là số nguyên tố. \r\n";
		System.out.println(str.replace("\\[", "$").replace("\\]", "$").replace("$,", ",$").replace("$.", ".$"));
	}

}
