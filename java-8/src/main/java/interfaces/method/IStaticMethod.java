package interfaces.method;

interface IStaticMethod {

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

class Car implements IStaticMethod {

	@Override
	public void showLog() {
		print();
		IStaticMethod.isValid();
	}
	
}
