package patterns.behavioral.nullobject;

public class RealTax implements Tax {

	private double vat;
	private String country;

	public RealTax(String country, double vat) {
		this.vat = vat;
		this.country = country;
	}

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public double apply(double price) {
		return price * vat;
	}

}
