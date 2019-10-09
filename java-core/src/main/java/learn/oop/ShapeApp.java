package learn.oop;

class Circle extends Shape {

	@Override
	public void draw() {
		System.out.println("Draw " + super.getColor() + " circle");
	}

}

class Rectangle extends Shape {

	@Override
	public void draw() {
		System.out.println("Draw " + super.getColor() + " rectangle");
	}

}

public class ShapeApp {

	public static void main(String[] args) {
		Shape rect = new Rectangle();
		rect.draw();
		System.out.println("---");
		Shape circle = new Circle();
		circle.draw();
	}

}
