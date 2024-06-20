package collection.concurrent;

import java.util.*;
import java.util.concurrent.*;

public class SomeTest {

    // => java.util.ConcurrentModificationException
    public static void test1() {
        final int N = 1_000;
        List<Integer> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 1; i < N; i++) {
            executor.submit(() -> {
                list.add(ThreadLocalRandom.current().nextInt());
            });
        }
        executor.shutdown();
        try {
            // Đợi cho tất cả các nhiệm vụ hoàn thành hoặc hết thời gian chờ
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow(); // Buộc dừng nếu các nhiệm vụ không hoàn thành trong thời gian chờ
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // Buộc dừng nếu bị gián đoạn
            Thread.currentThread().interrupt(); // Khôi phục trạng thái gián đoạn
        }

        // Chờ cho tất cả các nhiệm vụ hoàn thành trong vòng 1 phút
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow(); // Buộc dừng nếu không hoàn thành trong thời gian chờ
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("list = " + list);
    }

    // Thread safe
    public static void test2() {
        final int N = 1_000;
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 1; i < N; i++) {
            executor.submit(() -> {
                list.add(ThreadLocalRandom.current().nextInt());
            });
        }
        executor.shutdown();
        try {
            // Đợi cho tất cả các nhiệm vụ hoàn thành hoặc hết thời gian chờ
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow(); // Buộc dừng nếu các nhiệm vụ không hoàn thành trong thời gian chờ
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // Buộc dừng nếu bị gián đoạn
            Thread.currentThread().interrupt(); // Khôi phục trạng thái gián đoạn
        }

        // Chờ cho tất cả các nhiệm vụ hoàn thành trong vòng 1 phút
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow(); // Buộc dừng nếu không hoàn thành trong thời gian chờ
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("list = " + list);
    }

    /**
     * Sử dụng ConcurrentLinkedQueue để quản lý hàng đợi các yêu cầu trong một hệ thống đa luồng.
     * Thêm 10 yêu cầu vào hàng đợi từ nhiều luồng và xử lý các yêu cầu này từ một luồng khác
     */
    public static void test3() {
        ConcurrentLinkedQueue<String> requests = new ConcurrentLinkedQueue<>();
        ExecutorService producerExecutor = Executors.newFixedThreadPool(2);
        ExecutorService consumerExecutor = Executors.newSingleThreadExecutor();

        // Thêm yêu cầu vào hàng đợi từ nhiều luồng
        for (int i = 0; i < 10; i++) {
            final int requestId = i;
            producerExecutor.submit(() -> {
                String request = "Request " + requestId;
                requests.add(request);
                System.out.println("Thêm: " + request);
            });
        }

        producerExecutor.shutdown();

        while (!producerExecutor.isTerminated()) {}

        // Xử lý yêu cầu từ hàng đợi
        consumerExecutor.submit(() -> {
            while (!requests.isEmpty()) {
                String request = requests.poll();
                System.out.println("Xử lý: " + request);
            }
        });

        consumerExecutor.shutdown();
    }

    public static void main(String[] args) {
        // test1();
        // test2();
        test3();
    }

}
