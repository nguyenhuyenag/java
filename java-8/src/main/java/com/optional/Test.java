package com.optional;

import java.util.Optional;

import com.util.User;

/**
 * 
 * - empty(): Tạo 1 Optional rỗng
 * 
 * - isEmpty(): 
 * 
 * - of(T): Tạo 1 Optional của T, nếu T null -> NullPointerException
 * 
 * - ofNullable(): Tạo 1 Optional của T, nếu giá trị T null thì trả về empty()
 */
@SuppressWarnings("unused")
public class Test {

	public void orElse() {
		Optional<User> opt = Optional.empty();
		User user = opt.orElse(new User());
	}

	public void orElseGet() {
		Optional<User> optionalUser = Optional.of(null);
		User entity = optionalUser.orElseGet(() -> {
			User newEntity = new User();
			newEntity.setAge(28);
			newEntity.setName("Java");
			return newEntity;
		});
		if (optionalUser.isPresent()) {
			// Ghi log ở đây khi `mst` đã tồn tại
		}
	}

	public static void main(String[] args) {

	}

}
