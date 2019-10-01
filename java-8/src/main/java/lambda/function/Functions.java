package lambda.function;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class Functions {

	/**
	 * - R apply(T t) : Phương thức này thực hiện một hành động cụ thể trên đối số đã
	 * cho và trả về một đối khác
	 * - Thường dùng để chuyển kiểu dữ liệu này sang kiểu dữ liệu khác
	 * 
	 *  - compose, andThen, identity
	 *  
	 *  @see interfaces.function.api.Functions
	 */
	public static void main(String[] args) {

		// List<String> list = new ArrayList<>();
		// list.stream().map(Integer::parseInt).collect(Collectors.toList());

		// Đối số đầu vào là String, đầu ra là Integer
		Function<String, Integer> numberConverter = s -> Integer.parseInt(s);
		System.out.println(numberConverter.apply("1"));

		Function<LocalDate, String> dateConverter = d -> d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(dateConverter.apply(LocalDate.now()));

	}

}
