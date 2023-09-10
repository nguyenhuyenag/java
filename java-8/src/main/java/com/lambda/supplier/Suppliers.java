package com.lambda.supplier;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/*-
 * - Supplier là một functional interface dùng để cung cấp (supply) một giá trị.
 * Ví dụ khi chúng ta muốn tạo ra một đối tượng mới, nhưng không muốn xác định 
 * trước đối tượng đó trong thời điểm khởi tạo. Thay vào đó, chúng ta sẽ cung 
 * cấp một cách linh hoạt để tạo đối tượng đó, và đối tượng Supplier sẽ lấy và 
 * trả về giá trị đó cho chúng ta khi được yêu cầu bằng phương thức get()
 * 
 * 		public interface Supplier<T> { 
 * 			T get();
 * 		}
 * 
 * - Hàm get() -> Trả về giá trị trong context mà nó đang được sử dụng
 */
public class Suppliers {

	/**
	 * Dùng Supplier để tạo một đối tượng ngẫu nhiên của lớp Integer
	 */
	public static void main(String[] args) {
		// Hàm nextInt() trả về kiểu `int` nên ta khai báo là Supplier<Integer>
		Supplier<Integer> randomInt = () -> ThreadLocalRandom.current().nextInt();
		System.out.println(randomInt.get());
	}

}
