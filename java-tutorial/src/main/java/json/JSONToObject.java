package json;

import java.io.IOException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Student {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Student() {

	}

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public boolean hasFieldNull() {
		// return Stream.of(name, age).anyMatch(s -> s == null);
		return Stream.of(name, age).anyMatch(Objects::isNull);
	}
}

public class JSONToObject {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		String jsonStr = "[ \r\n" + "    {\r\n" + "        \"firstName\" : \"abc\",\r\n"
				+ "        \"lastName\" : \"xyz\"\r\n" + "    }, \r\n" + "    {\r\n"
				+ "        \"firstName\" : \"pqr\",\r\n" + "        \"lastName\" : \"str\"\r\n" + "    } \r\n" + "]";

		ObjectMapper mapper = new ObjectMapper();

		TypeReference<List<Student>> types = new TypeReference<List<Student>>() {
		};
		List<Student> details = mapper.readValue(jsonStr, types);

		details.forEach(d -> System.out.println(d.toString()));

	}

}