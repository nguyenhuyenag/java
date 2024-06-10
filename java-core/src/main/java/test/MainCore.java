package test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;

public class MainCore {

    public static void main(String[] args) {
        // System.out.println(SystemUtils.USER_HOME);
        // System.out.println(SystemUtils.USER_DIR);

        // Lấy đường dẫn thư mục chứa file được thực thi
        String classes = MainCore.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("classes = " + classes);

        String target = FileUtils.getFile(classes).getParent();
        System.out.println("target = " + target);

        if (StringUtils.isNotEmpty(target)) {
            target = new File(target).getParent();
            System.out.println("Thư mục chứa project: " + target);
        }
    }

}
