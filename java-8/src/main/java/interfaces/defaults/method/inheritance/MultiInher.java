package interfaces.defaults.method.inheritance;

import interfaces.defaults.method.Geometry;
import interfaces.defaults.method.Shape;

public class MultiInher implements Shape, Geometry {

	@Override
	public void show() {

	}

	@Override
	public void draw() {

	}

	@Override
	public void setColor(String color) {
		// Chỉ Override phương thức setColor của Shape bằng từ khóa super
		Shape.super.setColor(color);
	}

	public static void main(String[] args) {
		MultiInher m = new MultiInher();
		m.setColor("red");
	}

}
