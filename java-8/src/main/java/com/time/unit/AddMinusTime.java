package com.time.unit;

import java.time.Duration;
import java.time.Instant;

public class AddMinusTime {

    public static void main(String[] args) {
        // Lưu thời gian hết hạn là 10 phút sau
        Instant expirationTime = Instant.now().plus(Duration.ofMinutes(10));

        // Kiểm tra nếu đã hết hạn
        if (Instant.now().isAfter(expirationTime)) {
            System.out.println("Đã hết hạn!");
        } else {
            System.out.println("Chưa hết hạn!");
        }
    }

}
