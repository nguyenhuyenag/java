package com.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * - Lắng nghe sự kiện khi một mục bị loại bỏ (removed) từ cache. Mục đích sử
 * dụng removalListener() cho phép ta thực hiện các hành động cụ thể khi các mục
 * bị loại bỏ từ cache
 */
public class OnRemoval {

	public static void main(String[] args) {
		RemovalListener<String, String> removalListener = new RemovalListener<String, String>() {
			@Override
			public void onRemoval(RemovalNotification<String, String> notification) {
				System.out.println("Removed item: [key=" + notification.getKey() //
						+ ", value=" + notification.getValue() + "]");
			}
		};

		Cache<String, String> cache = CacheBuilder.newBuilder() //
				.removalListener(removalListener) //
				.build();

		// Đặt dữ liệu vào cache
		cache.put("key1", "value1");

		// Xóa mục khỏi cache
		cache.invalidate("key1");
	}

}
