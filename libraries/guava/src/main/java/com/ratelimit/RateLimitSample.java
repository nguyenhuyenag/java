package com.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 
 */
public class RateLimitSample {

	public static void main(String[] args) {
		RateLimiter rateLimiter = RateLimiter.create(10);
		for (int i = 1; i <= 20; i++) {
			double waitTime = rateLimiter.acquire(); // Chặn cho đến khi cấp phép
			System.out.println("Request " + i + " được phê duyệt sau " + waitTime + " giây.");
		}
	}

}
