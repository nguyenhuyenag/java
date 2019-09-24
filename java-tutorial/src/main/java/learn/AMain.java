package learn;

import java.util.Vector;
import java.util.stream.IntStream;

public class AMain {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		for (int i = 0; i < 25; i++) {
			vector.add(i);
		}
		System.out.println(vector.capacity());
	}

}
