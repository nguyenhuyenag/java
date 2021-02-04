package codewars.string;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ConvertStringToCamelCase {

	public static String toCamelCase(String str) {
		String res = "";
		boolean flag = false;
		for (String s : str.split("")) {
			if ("-".equals(s) || "_".equals(s)) {
				flag = true;
				continue;
			}
			if (!flag) {
				res += s;
			} else {
				flag = false;
				res += s.toUpperCase();
			}
		}
		return res;
	}

	@Test
	public void testSomeDashLowerStart() {
		Map<String, String> map = new HashMap<>();
		map.put("theStealthWarrior", "the-Stealth-Warrior");
		map.put("theStealthWarrior", "the_Stealth_Warrior");
		map.put("theStealthWarrior", "the_stealth_warrior");
		map.forEach((k, v) -> {
			assertEquals(k, ConvertStringToCamelCase.toCamelCase(v));
		});
	}

}
