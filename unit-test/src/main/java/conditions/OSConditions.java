package conditions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OSConditions {

	@Test
	@EnabledOnOs({ OS.WINDOWS, OS.LINUX }) // chỉ cho phép test method chạy trên LINUX hoặc WINDOWS
	public void test1() {

	}

	@Test
	@DisabledOnOs(OS.MAC) // vô hiệu hóa khi chạy trên MAC
	public void test2() {

	}

}
