package interfaces.defaults.method;

public interface Geometry {

	void show();

	// Phương thức có thể không cần override
	default void setColor(String color) {
		System.out.println("Draw geometry with color " + color);
	}

}
