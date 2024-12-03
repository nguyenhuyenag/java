package crypto.util;

import org.apache.commons.lang3.SystemUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataUtils {

    public static String xml() {
        try {
            String text = Files.readString(Path.of(SystemUtils.USER_DIR, "src", "main", "resources", "plant_catalog.xml"));
            return text.trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
