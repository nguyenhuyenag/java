package com;

public class MainCore {

    public static void main(String[] args) {
        System.out.println("Main starting...");

        // Đăng ký một shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Thực hiện công việc sau khi hàm main kết thúc
            System.out.println("Shutdown hook is running...");
        }));

        // Tiếp tục thực hiện các công việc trong hàm main
        System.out.println("Main function is continuing...");

        // Kết thúc hàm main
        System.out.println("Main ending.");
    }

}
