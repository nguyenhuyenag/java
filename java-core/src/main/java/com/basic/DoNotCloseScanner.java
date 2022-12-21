package com.basic;

import java.io.IOException;
import java.util.Scanner;

class ConsoleProgram {
	 
    public static final Scanner kbd = new Scanner(System.in);
 
}

public class DoNotCloseScanner {

	/**
	 * - Lý do chúng ta không nên làm những điều trên là vì đối tượng System.in được
	 * mở bởi JVM và nó nên được đóng bởi nó. Nếu bạn đóng nó, thì sau này các bạn
	 * sẽ không thể sử dụng lại đối tượng System.in
	 * 
	 * - Khai báo một biến static và sử dụng lại ở tất cả những nơi cần thiết
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		scanner.close();
		System.out.println(System.in.available()); // <- Exeption
	}

}
