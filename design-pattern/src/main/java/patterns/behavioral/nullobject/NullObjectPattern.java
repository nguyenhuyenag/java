package patterns.behavioral.nullobject;

public class NullObjectPattern {

	static void applyCountryTaxToPrice(String country, double price) {
		Tax tax = TaxFactory.getTaxByCountry(country);
		System.out.println(tax.getCountry() + ": " + tax.apply(price));
	}

	public static void main(String[] args) {

		final double price = 1000;

		// country thuộc VATS
		applyCountryTaxToPrice("Switzerland", price);
		applyCountryTaxToPrice("Germany", price);
		applyCountryTaxToPrice("Vietnam", price);

		// country không thuộc VATS nhưng có tên cụ thể
		applyCountryTaxToPrice("Thailand", price);

		// country không xác định
		applyCountryTaxToPrice("", price);
		applyCountryTaxToPrice(null, price);
	}

}
