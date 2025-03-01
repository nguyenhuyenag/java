package com.time.unit;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
    - ChronoUnit là một enum trong gói java.time.temporal, được sử dụng để đại diện cho các
    đơn vị thời gian như năm, tháng, ngày, giờ, phút, giây, v.v.

        ChronoUnit.YEARS	    Năm
        ChronoUnit.MONTHS	    Tháng
        ChronoUnit.WEEKS	    Tuần
        ChronoUnit.DAYS	        Ngày
        ChronoUnit.HOURS	    Giờ
        ChronoUnit.MINUTES	    Phút
        ChronoUnit.SECONDS	    Giây
        ChronoUnit.MILLIS	    Mili giây
        ChronoUnit.MICROS	    Micro giây
        ChronoUnit.NANOS	    Nano giây

    - Mục đích chính của ChronoUnit:
        (1) Hỗ trợ cộng/trừ thời gian (plus(), minus()).
        (2) Tính khoảng cách giữa hai thời điểm (between()).
        (3) Hoạt động với các lớp LocalDate, LocalTime, LocalDateTime, Instant, v.v.
 */
public class ChronoUnitExample {

    public static void calBetween() {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 3, 1);

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);

        System.out.println("Số ngày giữa hai mốc: " + daysBetween);
        System.out.println("Số tháng giữa hai mốc: " + monthsBetween);

        Instant start = Instant.now();
        Instant end = Instant.now();
        // Giả lập xử lý mất thời gian
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
        long millis = ChronoUnit.MILLIS.between(start, end);
        long seconds = ChronoUnit.SECONDS.between(start, end);
        System.out.println("Thời gian chạy (ms): " + millis);
        System.out.println("Thời gian chạy (s): " + seconds);
    }

    public static void basic() {
        LocalDate today = LocalDate.now();

        // Month
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        LocalDate nextMonth2 = today.plusMonths(1);

        // Year
        LocalDate lastYear = today.minus(1, ChronoUnit.YEARS);
        LocalDate lastYear2 = today.minusYears(1);

        System.out.println("Hôm nay: " + today);
        System.out.println("Tháng sau: " + nextMonth);
        System.out.println("Năm ngoái: " + lastYear);
    }

    public static void main(String[] args) {
        basic();
        // calBetween();
    }

}
