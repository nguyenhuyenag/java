package lombox.builder;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
@ToString
class Car {

	private String make;
	private String model;
	@Singular
	private List<String> features;

}

/*-
 * Person person = Person.builder()
 * 		.givenName("Aaron")
 * 		.award("Singer of the Year", LocalDate.now().minusYears(5))		// Map<String, LocalDate>
 * 		.award("Best Dancer", LocalDate.now().minusYears(2)) .build();
 */
public class BuilderSingular {

	public static void main(String[] args) {
		Car car = Car.builder() //
				.make("Toyota") //
				.model("Camry") //
				.feature("Bluetooth").feature("Backup camera") // For @Singular
				// .features(Arrays.asList("Bluetooth", "Backup camera")) // Without @Singular
				.build();

		System.out.println(car);
	}

}
