package interfaces.method.idefault;

public interface Company {

	interface Samsung {

		void sam();

		default void getLocation() {
			System.out.println("Samsung location");
		}

	}

	interface Asus {

		void asus();

		default void getLocation() {
			System.out.println("Asus location");
		}

	}

}
