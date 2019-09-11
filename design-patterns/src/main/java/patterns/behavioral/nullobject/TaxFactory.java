package patterns.behavioral.nullobject;

import java.util.HashMap;
import java.util.Map;

public class TaxFactory {

	private static final Map<String, Double> VATS = new HashMap<>();

	static {
		VATS.put("Switzerland", 1.22);
		VATS.put("Germany", 1.33);
		VATS.put("Vietnam", 1.44);
	}
	
	/**
	 * <p>Get Tax by country.</p>
	 * @param country là tên quốc gia, có thể null.
	 * @return RealTax (country thuộc VATS) hoặc NullTax (ngược lại).
	 */
	public static Tax getTaxByCountry(String country) {
		Double vat = VATS.get(country);
		if (vat != null) {
			return new RealTax(country, vat);
		}
		return new NullTax(country);
	}

}
