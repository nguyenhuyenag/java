package interfaces.defaults.method.inheritance;

import interfaces.defaults.method.Shape;

public class MultiInhers extends Parent implements Shape {

	@Override
	public void draw() {

	}

	/**
	 * - Class Parent & Interface Shape có cùng phương thức setColor
	 * - Lớp con kế thừa cả 2 thì nó sẽ chạy super class, bỏ qua interface
	 */
	public static void main(String[] args) {
		MultiInhers t = new MultiInhers();
		t.setColor("yellow");
	}

}
