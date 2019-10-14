package learn.basic.innerclass;

public class Outer {

	public class Inner {
		void show() {
			System.out.println("I'm Inner class");
		}
	}

	public static class StaticInner {
		void show() {
			System.out.println("I'm Inner class");
		}
	}

	public static void main(String[] args) {

		// Non-static
		Outer o = new Outer();
		Inner inner1 = o.new Inner();
		inner1.show();

		Inner inner2 = new Outer().new Inner();
		inner2.show();

		// Static
		Outer.StaticInner sInner1 = new Outer.StaticInner();
		sInner1.show();

		StaticInner sInner2 = new Outer.StaticInner();
		sInner2.show();

	}

}
