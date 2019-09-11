package patterns.creational.singleton;

/**
 * <p>Note</p>
 * <ul>
 * 	<li>Private constructor để hạn chế truy cập từ class bên ngoài.</li>
 * 	<li>Đặt private s tatic final variable đảm bảo biến chỉ được khởi tạo trong class.</li>
 * 	<li>Có một method public static để return instance được khởi tạo ở trên.</li>
 * </ul>
 * <p>Implement Singleton Pattern<p>
 * <ul>
 * 	<li>Eager initialization</li>
 * 	<li>Static block</li>
 * 	<li>Lazy initialization</li>
 * 	<li>Thread safe</li>
 * 	<li>Thread safe upgrade</li>
 * 	<li>Lazy holder</li>
 * </ul>
 */
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
