package learn;

import common.util.DataTypes;

public class Main {

	public static void main(String[] args) {
		DataTypes dataTypes = DataTypes.getInstance();
		System.out.println(dataTypes.MAX_INT);
		System.out.println(dataTypes.MAX_LONG);
		System.out.println(dataTypes.MAX_BYTE);
		System.out.println(dataTypes.MAX_SHORT);
	}
}
