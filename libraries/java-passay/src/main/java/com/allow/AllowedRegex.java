package com.allow;

import org.passay.AllowedRegexRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;

public class AllowedRegex {

	public static void main(String[] args) {
		// Rule: Password should contains alphabets only
		Rule rule1 = new AllowedRegexRule("^[A-Za-z]+$");
		// 8 and 16 characters
		Rule rule2 = new LengthRule(8, 16);

		PasswordValidator validator = new PasswordValidator(rule1, rule2);
		PasswordData password = new PasswordData("microsoft@123");
		RuleResult result = validator.validate(password);

		if (result.isValid()) {
			System.out.println("Password validated.");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
	}

}
