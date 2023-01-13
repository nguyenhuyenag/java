package interfaces.defaults;

import interfaces.defaults.Company.Asus;
import interfaces.defaults.Company.Samsung;

/**
 * Without override default method
 */
class Laptop implements Samsung {

	@Override
	public void sam() {

	}

	public static void main(String[] args) {
		Laptop lap = new Laptop();
		lap.getLocation();
	}

}

/**
 * Override default method
 */
class PC implements Samsung {

	@Override
	public void sam() {

	}

	@Override
	public void getLocation() {

	}

}

/**
 * - Duplicate default method
 * 
 * - Không thể triển khai 2 interface có phương thức trùng tên nhưng khác kiểu
 * trả về
 */
public class Computer implements Samsung, Asus {

	@Override
	public void sam() {

	}

	@Override
	public void asus() {

	}

	@Override
	public void getLocation() {
		Asus.super.getLocation();
	}

	public static void main(String[] args) {
		Computer c = new Computer();
		c.getLocation();
	}

}
