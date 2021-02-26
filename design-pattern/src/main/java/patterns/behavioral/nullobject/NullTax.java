package patterns.behavioral.nullobject;

import org.apache.commons.lang3.StringUtils;

public class NullTax implements Tax {

	private String country = "UNKNOWN_COUNTRY";

	/**
	 * <p>Null Object Pattern</p>
	 * @param country là tên quốc gia
	 */
	public NullTax(String country) {
		if (!StringUtils.isEmpty(country)) {
			this.country = country;
		}
	}

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public double apply(double price) {
		return price * 1;
	}

}
