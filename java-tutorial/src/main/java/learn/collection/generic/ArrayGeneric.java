package learn.collection.generic;

// Array generic
class AGeneric<T> {

	/*-
	 * Có thể khai báo một mảng Generic, nhưng không thể khởi tạo một mảng Generic
	 * T[] arr; 			// Ok
	 * T[] arr2 = new T[5];	// Error
	 */

	private T[] array;

	// Contructor
	public AGeneric(T[] array) {
		this.array = array;
	}

	public T[] getArray() {
		return array;
	}

	// Trả về phần tử cuối cùng của mảng
	public T getLastElement() {
		if (this.array == null || this.array.length == 0) {
			return null;
		}
		return this.array[this.array.length - 1];
	}

}

public class ArrayGeneric {

	public static void main(String[] args) {
		// Mảng String
		String[] arr = new String[] { "Tom", "Jerry" };
		AGeneric<String> generic = new AGeneric<>(arr);
		System.out.println("Last Element: " + generic.getLastElement());
	}
}
