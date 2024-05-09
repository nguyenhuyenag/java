package collection.generic.gclass;

/**
 * Có thể chỉ định rõ kiểu cho tham số Generics, giữ nguyên hoặc thêm các tham
 * số Generics.
 */
public class UseExtend extends KeyValuePair<String, Integer> {

	public UseExtend(String key, Integer value) {
		super(key, value);
	}

	public static void main(String[] args) {
		UseExtend entry = new UseExtend("Java", 8);
		String name = entry.getKey();
		Integer id = entry.getValue();
		// Name = Java, Id = 8
		System.out.println("Name = " + name + ", Id = " + id);
	}

}
