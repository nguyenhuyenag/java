package basic.lang;

import java.io.IOException;

public class RuntimeExample {

    // Chạy 1 hàm khi hàm main đã kết thúc
    public static void addShutdownHook() {
        System.out.println("Main starting...");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Thực hiện công việc sau khi hàm main kết thúc
            System.out.println("Hook is running...");
        }));
        System.out.println("Main function is continuing...");
        System.out.println("Main ending.");
    }

    // Thực hiện lệnh hệ thống từ bên trong chương trình Java
    public static void exec() {
        try {
            // Thực hiện lệnh "ls" (hoặc "dir" trên Windows)
            Process process = Runtime.getRuntime().exec("cmd /c dir");

            // Run 'notepad.exe'
            // Process process = Runtime.getRuntime().exec("notepad.exe");

            java.util.Scanner scanner = new java.util.Scanner(process.getInputStream());
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            // Đóng scanner và đợi quá trình kết thúc
            scanner.close();
            int exitCode = process.waitFor();
            System.out.println("Quá trình đã kết thúc với mã thoát: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exec();
        // addShutdownHook();
    }

}
