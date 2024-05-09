package basic.iterface;

interface SafeDeletable {
}

class Order {
}

class Customer implements SafeDeletable {
}

/**
 * - Marker Interface là một interface không có bất kỳ phương thức và thuộc tích
 * nào bên trong nó. Nó cung cấp thông tin run-time type về object, vì vậy
 * compiler và JVM có thêm thông tin về đối tượng thể thực hiện một số hoạt động
 * hữu ích
 * 
 * - Một số Built-in marker interface trong Java
 * 
 * + java.io.Serializable -> Dùng để đánh dấu đối tượng Serialize. Khi chúng ta
 * gọi phương thức ObjectOutputStream.writeObject(), JVM sẽ kiểm tra đối tượng
 * có implement một marker interface Serializable hay không. Nếu không, sẽ throw
 * một exception NotSerializableException
 * 
 * + java.lang.Cloneable -> Là một marker interface để nói với JVM rằng, đối
 * tượng có thể call Object.clone() method. Nếu chúng ta thực hiện clone một
 * object mà không được implement một marker interface Clonable, thì sẽ gặp một
 * exception CloneNotSupportedException
 */
public class MarkerInterface {

	public static void delete(Object obj) {
		if (obj instanceof SafeDeletable) {
			System.out.println("Set flag to delete: " + obj.getClass());
		} else {
			System.out.println("Call delete object from database: " + obj.getClass());
		}
	}

	public static void main(String[] args) {
		delete(new Order());
		delete(new Customer());
	}

}
