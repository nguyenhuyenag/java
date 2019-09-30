package interfaces.defaults.method;

public interface Shape {

	void draw();

	// Phương thức có thể không cần override
	default void setColor(String color) {
		System.out.println("Draw shape with color " + color);
	}

}
