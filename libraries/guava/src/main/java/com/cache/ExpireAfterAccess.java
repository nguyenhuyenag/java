package com.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * - expireAfterAccess(): Cache sẽ bị xóa sau một khoảng thời gian nhất định kể
 * từ lần truy cập cuối cùng
 */
public class ExpireAfterAccess {

	public static void main(String[] args) throws Exception {
		Cache<String, String> cache = CacheBuilder.newBuilder() //
				.expireAfterAccess(5, TimeUnit.SECONDS) //
				.build();

		// Đặt giá trị vào cache
		cache.put("key1", "value1");

		// Truy cập giá trị từ cache
		String value1 = cache.getIfPresent("key1");
		System.out.println("Value 1: " + value1); // In ra: "Value 1: value1"

		// Chờ 6 giây để mục "key1" hết hạn sau mỗi lần truy cập
		TimeUnit.SECONDS.sleep(6);

		// Truy cập lại giá trị từ cache
		String valueAfterExpiration = cache.getIfPresent("key1");
		System.out.println("Value 1 after expiration: " + valueAfterExpiration);
	}

}
