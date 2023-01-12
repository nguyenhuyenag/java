package instance;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
		Assert.assertTrue(largeContent.contains("net"));
    }
	
    @Test
    public void testStartWithHTTP() {
    	Assert.assertTrue(largeContent.startsWith("http"));
    }
	
}
