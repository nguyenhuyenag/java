package test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;

public class MainCore {

    public static void main(String[] args) {
        System.out.println(SystemUtils.USER_HOME);
        System.out.println(SystemUtils.USER_DIR);
        // System.out.println(System.getProperty("java.class.path"));

        // Lấy đường dẫn thư mục chứa file được thực thi
        String pathToExecutable = MainCore.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String projectDirectory = FileUtils.getFile(pathToExecutable).getParent();

        // Kiểm tra xem thư mục gốc của dự án có chứa tệp pom.xml không
        File pomFile = new File(projectDirectory, "pom.xml");
        if (!pomFile.exists()) {
            // Nếu không tìm thấy tệp pom.xml, ta có thể giả định rằng thư mục target không phải là thư mục gốc của dự án
            // Do đó, ta sẽ lấy thư mục cha của thư mục hiện tại
            projectDirectory = new File(projectDirectory).getParent();
        }

        System.out.println("Thư mục chứa project: " + projectDirectory);
    }

}
