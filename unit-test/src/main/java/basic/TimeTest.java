package basic;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * assertTimeout() và assertTimeoutPreemptively() đều được dùng để xác định
 * khoảng thời gian chạy tối đa của test case. Điểm khác biệt duy nhất giữa
 * chúng là với assertTimeoutPreemptively() quá trình thực thi của test case sẽ
 * dừng lại khi hết thời gian được định, còn assertTimeout() thì không
 */
public class TimeTest {

	@Test
	public void whenAssertingTimeout_thenNotExceeded() {
		Assertions.assertTimeout( //
				Duration.ofSeconds(2), //
				() -> {
					// code that requires less then 2 minutes to execute
					Thread.sleep(1000);
				});
	}

}
