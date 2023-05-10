package com.basic.gc;

/**
 * System.gc(): Gọi trình thu gom rác để nó tiến hành giải phóng các object
 * không còn được sử dụng
 * 
 * finalize(): Method này sẽ được trình thu gon rác gọi khi một object được xác
 * định là không còn reference nào đến nó.
 */
@SuppressWarnings("unused")
public class Garbage {

	// to store object name
	String obj_name;

	public Garbage(String obj_name) {
		this.obj_name = obj_name;
	}

	public static void t1() {
		new Garbage("t1");
	}

	public static void t2() {
		Garbage t2 = new Garbage("t2");
		t2 = null;
	}
	
	public static void t3() {
		Garbage t1 = new Garbage("t1");
		Garbage t2 = new Garbage("t2");
		t1 = t2;
	}

	// Driver method
	public static void main(String args[]) {
		t3();
		System.gc();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println(this.obj_name + " successfully garbage collected");
	}

}
