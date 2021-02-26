package patterns.creational.singleton.init;

/*-
 *	- Singleton Pattern
 *
 *		- Private constructor để hạn chế truy cập từ class bên ngoài
 *		- Đặt private static final variable đảm bảo biến chỉ được khởi tạo trong class
 *		- Có một method public static để return instance được khởi tạo ở trên
 *
 * - Implement Singleton Pattern
 * 
 * 		- Eager
 * 		- Static block
 * 		- Lazy
 * 		- Thread safe
 * 		- Thread safe upgrade
 * 		- Lazy holder
 */

// Đây là cách dễ nhất nhưng cách này mặc dù instance đã được khởi tạo nhưng có thể sẽ không dùng tới
public class Eager {

	// private static final variable
	private static final Eager INSTANCE = new Eager();

	// Private constructor
	private Eager() {

	}

	// method public static
	public static Eager getInstance() {
		return INSTANCE;
	}

	public void showMessage() {
		System.out.println("Hello World!");
	}

}
