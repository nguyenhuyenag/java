package instance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Vòng đời mặt định của Class Test
 * 
 * Các test method addTwo() và addThree() đều sữa đổi giá trị của biến sum tuy
 * nhiên cả 2 đều passed bởi vì một instance DefaultLifeCycle được tạo trước mỗi
 * test method bắt đầu thực thi, do đó giá trị của sum luôn là 1 khi addTwo() và
 * addThree() bắt đầu thực thi.
 */
public class DefaultLifeCycle {

	private int sum = 1;

	@Test
	public void addTwo() {
		sum += 2;
		Assertions.assertEquals(3, sum);
	}

	@Test
	public void addThree() {
		sum += 3;
		Assertions.assertEquals(4, sum);
	}

}
