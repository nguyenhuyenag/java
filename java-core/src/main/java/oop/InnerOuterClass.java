package oop;

public class InnerOuterClass {

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
		InnerOuterClass o = new InnerOuterClass();
		Inner inner1 = o.new Inner();
		inner1.show();

		Inner inner2 = new InnerOuterClass().new Inner();
		inner2.show();

		// Static
		InnerOuterClass.StaticInner sInner1 = new InnerOuterClass.StaticInner();
		sInner1.show();

		StaticInner sInner2 = new InnerOuterClass.StaticInner();
		sInner2.show();
	}

}
