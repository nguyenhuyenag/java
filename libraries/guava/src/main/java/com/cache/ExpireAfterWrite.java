package com.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * - Cache sẽ tự động xóa sau một khoảng thời gian cố định kể từ khi nó được tạo
 * hoặc thay thế giá trị gần nhất của nó
 */
public class ExpireAfterWrite {

	public static void main(String[] args) throws InterruptedException {
		Cache<String, String> cache = CacheBuilder.newBuilder() //
				.expireAfterWrite(5, TimeUnit.SECONDS) // Mục sẽ tồn tại tối đa 30 giây
				.build();

		// Đặt dữ liệu vào cache
		cache.put("key1", "value1");

		// Đợi một khoảng thời gian để mục trong cache hết hạn
		TimeUnit.SECONDS.sleep(10);

		// Kiểm tra xem mục đã bị xóa chưa
		String value1 = cache.getIfPresent("key1"); // Trả về null

		System.out.println("Value1 after expiration: " + value1);
	}

}
