package interfaces.defaults;

import interfaces.defaults.Company.Samsung;

class LG {

	public void getLocation() {
		System.out.println("LG location");
	}

}

public class Phone extends LG implements Samsung {

	@Override
	public void sam() {

	}

	/*-
	 * - Khi Super class & Interface có cùng phương thức thì class con sẽ lấy phương
	 * thức của super class
	 */
	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.getLocation();
	}

}