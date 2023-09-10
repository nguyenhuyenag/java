package com.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

/**
 * - Refresh cache sau một khoảng thời gian kể từ khi nó được khởi tạo hoặc
 * write/read lần cuối.
 */
public class RefreshAfterWrite {

	public static void main(String[] args) {
		Cache<String, String> cache = CacheBuilder.newBuilder() //
				.refreshAfterWrite(5, TimeUnit.SECONDS) //
				.build(CacheLoader.from((String k) -> k.toUpperCase()));

		// Đặt dữ liệu vào cache
		cache.put("key1", "value1");

		// Lấy giá trị từ cache
		String value1 = cache.getIfPresent("key1");
		System.out.println("Value1: " + value1);

		// Đợi một khoảng thời gian
		try {
			TimeUnit.SECONDS.sleep(9);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Lấy lại giá trị từ cache sau khi đã được làm mới
		String refreshedValue1 = cache.getIfPresent("key1");
		System.out.println("Refreshed Value1: " + refreshedValue1);
	}

}
