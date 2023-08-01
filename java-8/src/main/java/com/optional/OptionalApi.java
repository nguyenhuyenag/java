package com.optional;

import java.util.Optional;
import java.util.function.Supplier;

import com.util.User;

/*-
 * - empty(): Tạo 1 Optional rỗng
 * 
 * - of(T): Tạo một Optional, nếu giá trị truyền vào null -> NullPointerException
 * 
 * - ofNullable(T): Tạo 1 Optional của T, nếu giá trị T null thì trả về empty()
 * 
 * - orElse(): Cung cấp một giá trị mặc định khi Optional rỗng (truyền trực tiếp)
 * - orElseGet(): Cung cấp một giá trị mặc định khi Optional rỗng (bằng Supplier)
 * 
 * - orElseThrow(): Trả về giá trị nếu có hoặc ném ra NoSuchElementException nếu rỗng
 * - orElseThrow(Supplier): Tương tự như trên nhưng ném ra Supplier<Exception> nếu rỗng
 * 
 * - isEmpty(): Kiểm tra Optional có rỗng hay không
 * 
 * - isPresent(): Kiểm tra Optional có chứa giá trị không
 * - ifPresent(): Làm gì đó nếu Optional có giá trị
 * - ifPresentOrElse(): Thực hiện 1 hành động nếu Optional có giá trị và 1 hành động khác nếu rỗng
 * 
 * - stream(): Chuyển đổi Optional thành Stream
 * 
 */
@SuppressWarnings("unused")
public class OptionalApi {

	public static void orElse() {
		Optional<User> opt = Optional.empty();
		User user = opt.orElse(new User());
	}

	public static void orElseGet() {
		Optional<User> optionalUser = Optional.of(null);
		User entity = optionalUser.orElseGet(() -> {
			User newEntity = new User();
			newEntity.setAge(28);
			newEntity.setName("Java");
			return newEntity;
		});
	}

	public static void orElseThrow() {
		Optional<Integer> numberOptional = Optional.of(10);
		int result1 = numberOptional.orElseThrow();
		System.out.println("Result 1: " + result1);
		Optional<Integer> emptyOptional = Optional.empty();
		int result2 = emptyOptional.orElseThrow();
		// Dòng này không được thực thi vì ngoại lệ được ném ở trên
		System.out.println("Result 2: " + result2);
	}

	public static void orElseThrowWithSupplier() {
		Optional<Integer> emptyOptional = Optional.empty();
		Supplier<RuntimeException> exceptionSupplier = () -> new RuntimeException("Optional is empty");
		int result = emptyOptional.orElseThrow(exceptionSupplier);
		// Dòng này không được thực thi vì ngoại lệ được ném ở trên
		System.out.println("Result: " + result);
	}

	public static void ifPresent() {
		// Not change
		Optional<String> optionalValue = Optional.of("Hello, world!");
		optionalValue.ifPresent(value -> {
			value = "Modified value";
			System.out.println("Inside ifPresent(): " + value);
		});
		// Change
		System.out.println("After ifPresent(): " + optionalValue.get());
		Optional<User> optionalUser = Optional.of(new User("James", 20));
		optionalUser.ifPresent(value -> {
			value.setAge(22);
		});
		System.out.println(optionalUser.get());
	}

	public static void ifPresentOrElse() {
		Optional<String> emptyOptional = Optional.empty();
		Optional<String> valueOptional = Optional.of("Hello, world!");
		// Thực hiện hành động khi Optional có giá trị và khi rỗng
		valueOptional.ifPresentOrElse( //
				val -> System.out.println("Value exists: " + val), //
				() -> System.out.println("Value is empty") //
		);
		emptyOptional.ifPresentOrElse( //
				val -> System.out.println("Value exists: " + val), //
				() -> System.out.println("Value is empty") //
		);
	}

	public static void main(String[] args) {
		// orElse();
		// orElseGet();
		// orElseThrow();
		orElseThrowWithSupplier();
		// ifPresent();
		// ifPresentOrElse();
	}

}
