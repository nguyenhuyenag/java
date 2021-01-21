package problem.number;

import java.util.Random;

public class RandomNonDuplicate {

	public static void rand() {
		Random ran = new Random();
		int cur, pre = ran.nextInt(4);
		for (int i = 0; i < 10; i++) {
			cur = ran.nextInt(4);
			while (cur == pre) {
				cur = ran.nextInt(4);
			}
			pre = cur;
			System.out.println(cur);
		}
	}
	
	public static void main(String[] args) {
		rand();
	}

}
