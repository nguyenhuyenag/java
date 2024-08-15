
package basic.strings;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.text.CaseUtils;

public class CamelCase {

	private static String toCamel(String str) {
		return CaseUtils.toCamelCase(str, false, new char[] { '_' });
	}

	public static void test() {
		List<String> keys = Arrays.asList("opened_by", "ticket_owner", "close_reason", "full_name");
		List<String> fields = Arrays.asList("openedBy", "ticketOwner", "closeReason");
		keys.forEach(t -> {
			if (fields.contains(toCamel(t))) {
				System.out.println(t);
			}
		});
	}

	public static void main(String[] args) {
		String s = "Construct the max number with given sum of digits";
		System.out.println("s = " + toCamel(s));
	}

}
