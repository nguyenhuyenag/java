package com.basic;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;

/*-
 * equals(): Kiểm tra 2 đối tượng có bằng nhau không
 * 
 * hashCode(): HashMap, HashTable sử dụng key để tìm kiếm value tương ứng. Để
 * tối ưu cho việc này, Java sử dụng các hash value lấy từ phương thức
 * hashCode() của key để gom chúng lại (gọi là bucket).
 * 
 * - Để tìm kiếm một trong HashMap hay HashTable, Java sẽ lấy hash value của key,
 * sau đó so sánh với các bucket nếu trùng khớp thì sẽ trả về value tương ứng.
 * 
 * - Nhiều đối tượng có thể có cùng hash value, do đó chúng có thể nằm chung một
 * bucket. Lúc này, Java sẽ sử dụng tiếp phương thức equals() để tìm chính xác
 * đối tượng value cần tìm.
 * 
 * - Ở đây chúng ta có một khái niệm gọi là contract giữa phương thức equals() và
 * phương thức hashCode() đó là:
 * 
 * 		+ Khi override phương thức equals() thì cũng phải override phương thức hashCode().
 * 
 *		+ Nếu hai đối tượng bằng nhau thì chúng phải có cùng hashCode().
 * 
 * 		+ Nếu hai đối tượng có cùng hashCode() thì chúng có thể bằng nhau hoặc là không.
 */
@AllArgsConstructor
class Student {

	private String id;
	private String name;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student std = (Student) obj;
			if (this.id.equals(std.id) && this.name.equals(std.name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}

public class HashCodeAndEquals {

	public static void main(String[] args) {
		Student std1 = new Student("001", "Cong");
		Student std2 = new Student("001", "Cong");
		Student std3 = new Student("003", "Dung");

		Set<Student> set = new HashSet<>();
		set.add(std1);
		set.add(std2);
		set.add(std3);

		// Nếu không override phương thức equals và hashCode thì sẽ in ra 3 Student
		for (Student student : set) {
			System.out.println(student);
		}
	}

}
