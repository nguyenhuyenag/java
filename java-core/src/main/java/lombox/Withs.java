package lombox;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

@Getter
@Setter
@ToString
@AllArgsConstructor
class Person {
	private String name;
	private int age;

	@With
	private String job;
}

/**
 * Annotation này giúp tạo ra một bản sao của đối tượng hiện tại, nhưng có một
 * số trường được thay đổi
 */
public class Withs {

	public static void main(String[] args) {
		Person person = new Person("Alice", 30, "Software Engineer");
		Person newPerson = person.withJob("Product Manager");
		person.setAge(25);
		System.out.println(person);
		System.out.println(newPerson);
	}

}
