package com.allow;

import org.passay.AllowedCharacterRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;

/**
 * - Chỉ cho phép các ký tự trong rule
 */
public class AllowedCharacter {

	public static void main(String[] args) {
		example_1();
	}

	public static void example_1() {
		// Password should contains only a, b and c
		Rule rule1 = new AllowedCharacterRule(new char[] { 'a', 'b', 'c' });

		// 8 and 16 characters
		Rule rule2 = new LengthRule(8, 16);

		PasswordValidator validator = new PasswordValidator(rule1, rule2);
		PasswordData password = new PasswordData("abcabcab1");
		RuleResult result = validator.validate(password);

		if (result.isValid()) {
			System.out.println("Password validated.");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
	}

}
