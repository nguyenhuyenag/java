package com.cache;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.UncheckedExecutionException;

@SuppressWarnings("unused")
public class CacheExceptionExample {

	private static Cache<String, String> cache = CacheBuilder.newBuilder().build();

	public static void ex1() throws ExecutionException {
		try {
			// Trường hợp 1: Dữ liệu không tồn tại trong cache và CacheLoader ném ra ngoại
			// lệ
			String value = cache.get("key1", () -> {
				throw new RuntimeException("Something went wrong!");
			});
		} catch (UncheckedExecutionException e) {
			// Xử lý ngoại lệ
			Throwable cause = e.getCause();
			System.err.println("Error: " + cause.getMessage()); // In ra thông báo lỗi
		}
	}

	public static void ex2() throws ExecutionException {
		try {
			// Truy xuất với từ khóa null
			String value = cache.get(null, () -> {
				throw new RuntimeException("Something went wrong!");
			});
		} catch (NullPointerException e) {
			// Xử lý ngoại lệ
			System.err.println("Error: Key is null");
		}
	}

	public static void main(String[] args) throws ExecutionException {
		ex1();
		ex2();
	}
}
