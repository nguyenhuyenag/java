package lambda.function;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * - R apply(T t) : Phương thức này thực hiện một hành động cụ thể trên đối số đã
 * cho và trả về một đối khác
 *
 * - Thường dùng để chuyển kiểu dữ liệu này sang kiểu dữ liệu khác
 *  
 *  @see interfaces.function.api.Functions
 */
public class Functions {

	public static void main(String[] args) {

		// List<String> -> List<Integer>
		List<String> list = new ArrayList<>();
		list.stream().map(Integer::parseInt).collect(Collectors.toList());

		// String -> Integer
		Function<String, Integer> numberConverter = s -> Integer.parseInt(s);
		System.out.println(numberConverter.apply("1"));

		// LocalDate -> String
		Function<LocalDate, String> dateConverter = d -> d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(dateConverter.apply(LocalDate.now()));

	}

}
