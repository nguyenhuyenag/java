package bigocoder.nmlt;

/*-
 > Đoạn thẳng AB dài s (mét), từ A một vật di chuyển với vận tốc a (m/s) đến B,
 cùng lúc ở đầu B một vật di chuyển với vận tốc b (m/s) đến A. Tính thời gian
 2 vật gặp nhau.
 
 Input
 Ba số nguyên dương s, a, b
 
 Output
 In kết quả theo yêu cầu bài toán (Làm tròn 2 chữ số thập phân)
  
 Gọi t là thời gian A và B gặp nhau
 A đi được t*a (m)
 B đi được t*b (m)
 Và t*a + t*b = s => t = s/(a+b)
*/
import java.util.Scanner;

public class TGGapNhau {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int s = io.nextInt();
			int a = io.nextInt();
			int b = io.nextInt();
			float t = (float) s / (a + b);
			t = (float) Math.round(t * 100) / 100;
			System.out.println(String.format("%.2f", t));
		}
	}
}
