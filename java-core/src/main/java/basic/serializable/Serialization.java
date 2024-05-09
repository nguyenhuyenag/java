package basic.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * - Chuyển đổi trạng thái của một object thành một định dạng khác (thường là
 * byte stream) để lưu trữ hoặc truyển qua mạng.
 * 
 * - serialVersionUID là giá trị dùng để định nghĩa thứ tự data của object khi
 * serialize. Chỉ deserialize object chỉ khi serialVersionUID của class đúng với
 * serialVersionUID của instance được lưu trữ.
 * 
 * - Nếu superclass implements Serializable thì subclass không cần implement
 * 
 * - Các thuộc tính static & transient sẽ không được Serializable
 * 
 * - Hàm khởi tạo sẽ không được gọi khi một đối tượng được Deserialization
 * 
 * - Nếu lớp implements Serializable thì các thuộc tính là đối tượng bên trong
 * cũng phải implement Serializable. Ví dụ lớp Person có thuộc tính Address thì
 * lớp Address cũng phải implements Serializable, nếu không sẽ bị lỗi
 * java.io.NotSerializableException.
 */
public class Serialization {

	static String filename = "file/student.txt";

	public static void serialization() {
		try (ObjectOutputStream io = new ObjectOutputStream(new FileOutputStream(filename));) {
			Student student = new Student("Java", 1995);
			io.writeObject(student);
			System.err.println("OK!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deserialization() {
		try (ObjectInputStream io = new ObjectInputStream(new FileInputStream(filename));) {
			Student student = (Student) io.readObject();
			System.err.println(student.getName());
			System.err.println(student.getAge());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// serialization();
		deserialization();
	}

}
