package com;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.passay.CharacterCharacteristicsRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

/**
 * - Phải thỏa mãn ít nhất M trong số N ràng buộc thì mới thỏa điều kiện
 */
public class MOfNRules {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Rule 1: Password length should be in between 8 and 16 characters
		Rule rule1 = new LengthRule(8, 16);
		
		// Rule 2: No whitespace allowed
		Rule rule2 = new WhitespaceRule();
		
		CharacterCharacteristicsRule rule3 = new CharacterCharacteristicsRule();
		
		// M - Mandatory characters count
		rule3.setNumberOfCharacteristics(3);
		
		// Rule 3.a: One Upper-case character
		rule3.getRules().add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
		
		// Rule 3.b: One Lower-case character
		rule3.getRules().add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
		
		// Rule 3.c: One digit
		rule3.getRules().add(new CharacterRule(EnglishCharacterData.Digit, 1));
		
		// Rule 3.d: One special character
		rule3.getRules().add(new CharacterRule(EnglishCharacterData.Special, 1));

		PasswordValidator validator = new PasswordValidator(rule1, rule2, rule3);
		PasswordData password = new PasswordData("microsoft@123");
		RuleResult result = validator.validate(password);

		if (result.isValid()) {
			System.out.println("Password validated.");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
	}

}
