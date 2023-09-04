package com.allow;

import java.util.ArrayList;
import java.util.List;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

/**
 * - CharacterRule helps in defining a set of characters and minimum no of
 * characters required in a password
 */
public class CharacterRuleAtLeast {

	public static void main(String[] args) {
		List<Rule> rules = new ArrayList<>();

		// Password length should be in between 8 and 16 characters
		rules.add(new LengthRule(8, 16));

		// No whitespace allowed
		rules.add(new WhitespaceRule());

		// At least one Upper-case character
		rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));

		// At least one Lower-case character
		rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));

		// At least one digit
		rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));

		// At least one special character
		rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

		PasswordValidator validator = new PasswordValidator(rules);
		PasswordData password = new PasswordData("Microsoft@123");
		RuleResult result = validator.validate(password);

		if (result.isValid()) {
			System.out.println("Password validated.");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
	}

}
