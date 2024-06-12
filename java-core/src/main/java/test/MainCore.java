package test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainCore {

    public static void test2() {
        try {
            // Get the context ClassLoader for the current thread
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            // Use a known resource in the classpath, such as the root directory or a known file
            // For example, if you have a file named 'example.txt' in the classpath
            URL resource = loader.getResource("file/java-roadmap.pdf");

            if (resource != null) {
                // Convert the URL to a URI and then to a File
                File file = Paths.get(resource.toURI()).toFile();

                // Print the file path
                System.out.println("File path: " + file.getAbsolutePath());

                // Now you can use the file as needed
                if (file.exists()) {
                    System.out.println("File exists.");
                } else {
                    System.out.println("File does not exist.");
                }
            } else {
                System.out.println("Resource not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readResourcesFile() throws IOException, URISyntaxException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        // System.out.println("loader.toString() = " + loader.getResource());
//        try (InputStream inputStream = loader.getResourceAsStream("main/java/resources/" + fileName)) {
//            if (inputStream == null) {
//                throw new FileNotFoundException("File " + fileName + " doesn't exist!");
//            }
//            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
//        }

        // Use a known resource in the classpath, such as the root directory or a known file
        URL resource = loader.getResource("");

        if (resource != null) {
            // Convert the URL to a URI and then to a Path
            String path = Path.of(resource.toURI()).toAbsolutePath().toString();

            // Print the path
            System.out.println("Current ClassLoader path: " + path);
        }
        return "";
    }

    /*
        System.getProperty("user.dir") -> Lấy đường dẫn của
     */
    public static void test() {
        // System.out.println(SystemUtils.USER_HOME);
        System.out.println(SystemUtils.USER_DIR);

        // Lấy đường dẫn thư mục chứa file được thực thi
        String classes = MainCore.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("classes = " + classes);

        String target = FileUtils.getFile(classes).getParent();
        // System.out.println("target = " + target);

        if (StringUtils.isNotEmpty(target)) {
            target = new File(target).getParent();
            System.out.println("Thư mục chứa file MainCore: " + target);
        }
    }

    public static void main(String[] args) throws Exception {
        // test();
        // test2();
        readResourcesFile();
    }

}
