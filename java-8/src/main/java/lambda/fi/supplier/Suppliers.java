package lambda.fi.supplier;

import java.util.function.Supplier;

public class Suppliers {

	/**
	 * T get(): Phương thức get() sẽ return một giá trị cụ thể
	 */
	public static void main(String[] args) {
		Supplier<String> supplier = () -> "Welcome to gpcoder.com";
		String hello = supplier.get();
		System.out.println(hello);
	}

}
