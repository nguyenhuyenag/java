package learn.recursion;

public class TowerHaNoi {

	static int total = 0;

	static void move(int n, String a, String b, String c) {
		if (n == 1) {
			System.out.println(a + " -> " + c);
			total++;
			return;
		}
		// chuyển n - 1 đĩa từ cọc nguồn sang cọc trung gian,
		// lấy cọc đích làm cọc phụ
		move(n - 1, a, c, b);
		// chuyển đĩa còn lại từ cọc A -> C
		move(1, a, b, c);
		// chuyễn n - 1 từ cọc trung gian về cọc đích,
		// lấy cọc nguồn làm cọc trung gian
		move(n - 1, b, a, c);
	}

	static void towerHanoi(int n) {
		move(n, "A", "B", "C");
	}

	public static void main(String[] args) {
		int n = 3;
		towerHanoi(n);
		System.out.println("Total: " + total);
	}
}
