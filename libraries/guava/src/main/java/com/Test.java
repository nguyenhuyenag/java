package com;

import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Test {
	
	public static void main(String[] args) {
		// Tạo một đối tượng Ticker tùy chỉnh
        Ticker customTicker = new Ticker() {
            @Override
            public long read() {
                // Giả định rằng đây là một đồng hồ đo thời gian tùy chỉnh
                return System.currentTimeMillis() * 1000L; // Ví dụ: đọc thời gian theo giây
            }
        };

        // Sử dụng Ticker để cấu hình cache
        Cache<String, String> cache = CacheBuilder.newBuilder()
            .ticker(customTicker)
            .build();

        // Đặt dữ liệu vào cache
        cache.put("key1", "value1");

        // Lấy thời gian bằng Ticker
        long currentTime = cache.stats().totalLoadTime();

        System.out.println("Current Time: " + currentTime);
    }
	
}
