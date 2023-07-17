package com;

enum MyEnum {

	PULL_UP {
		@Override
		public int getValue() {
			return 1;
		}
	},
	PULL_DOWN {
		@Override
		public int getValue() {
			return 0;
		}
	};

	public abstract int getValue();

}

public class Main {

	public static void main(String[] args) {
		int myInt = 1;
		MyEnum myEnum = MyEnum.PULL_DOWN;
		System.out.println(MyEnum.PULL_DOWN);
		// Using equals() method
		if (myEnum.equals(myInt)) {
			System.out.println("Enum and int are equal");
		} else {
			System.out.println("Enum and int are not equal");
		}
	}
}
