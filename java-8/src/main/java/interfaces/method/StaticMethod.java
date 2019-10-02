package interfaces.method;

interface StaticMethod {

	default void print() {
		if (isValid()) {
			System.out.println("Vehicle printed");
		}
	}

	static boolean isValid() {
		System.out.println("Vehicle is valid");
		return true;
	}

	void showLog();
}

class Car implements StaticMethod {

	@Override
	public void showLog() {
		print();
		StaticMethod.isValid();
	}
	
}
