
package com.basic;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.text.CaseUtils;

public class CamelCase {

	private static String toCamel(String str) {
		return CaseUtils.toCamelCase(str, false, new char[] { '_' });
	}

	public static void main(String[] args) {
		List<String> keys = Arrays.asList("opened_by", "ticket_owner", "close_reason", "full_name");
		List<String> fields = Arrays.asList("openedBy", "ticketOwner", "closeReason");
		keys.forEach(t -> {
			if (fields.contains(toCamel(t))) {
				System.out.println(t);
			}
		});
	}

}