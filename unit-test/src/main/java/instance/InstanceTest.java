package instance;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Đôi lúc chúng ta cần một object tồn tại xuyên suốt qua các test method mà
 * không phải khởi tạo lại
 */
public class InstanceTest {

    private static String largeContent;

    @BeforeAll
    public static void setup() {
        largeContent = "https://java.net/";
    }

    @Test
    public void testContainNet() {
        assertTrue(largeContent.contains("net"));
    }

    @Test
    public void testStartWithHTTP() {
        assertTrue(largeContent.startsWith("http"));
    }

}
