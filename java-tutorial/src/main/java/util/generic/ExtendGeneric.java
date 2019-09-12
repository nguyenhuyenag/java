package util.generic;

/**
 * Có thể chỉ định rõ kiểu cho tham số Generics, giữ nguyên hoặc thêm các tham
 * số Generics.
 */
public class ExtendGeneric extends KeyValuePair<String, Integer> {

	public ExtendGeneric(String key, Integer value) {
		super(key, value);
	}

	public static void main(String[] args) {
		ExtendGeneric entry = new ExtendGeneric("Java", 8);
		String name = entry.getKey();
		Integer id = entry.getValue();
		// Name = Java, Id = 8
		System.out.println("Name = " + name + ", Id = " + id);
	}

}
