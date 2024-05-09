package basic.exception;

import java.util.Collections;
import java.util.List;

public class NPE {

	public boolean checkName(String name) {
		return "huyennv".equalsIgnoreCase(name);
	}

	public List<String> findByProductId(String productId) {
		return Collections.emptyList();
	}

	private String getName(int id) {
		return null;
	}

	public void access() {
		String name = getName(1);
		if (name != null) {
			System.out.println(name.toString());
		}
		// or
		try {
			System.out.println(name.toString());
		} catch (NullPointerException npe) {

		}
	}

}
