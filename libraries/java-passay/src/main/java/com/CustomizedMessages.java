package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.MessageResolver;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.PropertiesMessageResolver;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

/*-
 * - File `messages.properties`

		HISTORY_VIOLATION=Password matches one of %1$s previous passwords.
		ILLEGAL_WORD=Password contains the dictionary word '%1$s'.
		ILLEGAL_WORD_REVERSED=Password contains the reversed dictionary word '%1$s'.
		ILLEGAL_DIGEST_WORD=Password contains a dictionary word.
		ILLEGAL_DIGEST_WORD_REVERSED=Password contains a reversed dictionary word.
		ILLEGAL_MATCH=Password matches the illegal pattern '%1$s'.
		ALLOWED_MATCH=Password must match pattern '%1$s'.
		ILLEGAL_CHAR=Password %2$s the illegal character '%1$s'.
		ALLOWED_CHAR=Password %2$s the illegal character '%1$s'.
		ILLEGAL_QWERTY_SEQUENCE=Password contains the illegal QWERTY sequence '%1$s'.
		ILLEGAL_ALPHABETICAL_SEQUENCE=Password contains the illegal alphabetical sequence '%1$s'.
		ILLEGAL_NUMERICAL_SEQUENCE=Password contains the illegal numerical sequence '%1$s'.
		ILLEGAL_USERNAME=Password %2$s the user id '%1$s'.
		ILLEGAL_USERNAME_REVERSED=Password %2$s the user id '%1$s' in reverse.
		ILLEGAL_WHITESPACE=Password %2$s a whitespace character.
		ILLEGAL_NUMBER_RANGE=Password %2$s the number '%1$s'.
		ILLEGAL_REPEATED_CHARS=Password contains %3$s sequences of %1$s or more repeated characters, but only %2$s allowed: %4$s.
		INSUFFICIENT_UPPERCASE=Password must contain %1$s or more uppercase characters.
		INSUFFICIENT_LOWERCASE=Password must contain %1$s or more lowercase characters.
		INSUFFICIENT_ALPHABETICAL=Password must contain %1$s or more alphabetical characters.
		INSUFFICIENT_DIGIT=Password must contain %1$s or more digit characters.
		INSUFFICIENT_SPECIAL=Password must contain %1$s or more special characters.
		INSUFFICIENT_CHARACTERISTICS=Password matches %1$s of %3$s character rules, but %2$s are required.
		INSUFFICIENT_COMPLEXITY=Password meets %2$s complexity rules, but %3$s are required.
		INSUFFICIENT_COMPLEXITY_RULES=No rules have been configured for a password of length %1$s.
		SOURCE_VIOLATION=Password cannot be the same as your %1$s password.
		TOO_LONG=Password must be no more than %2$s characters in length.
		TOO_SHORT=Password must be %1$s or more characters in length.
		TOO_MANY_OCCURRENCES=Password contains %2$s occurrences of the character '%1$s', but at most %3$s are allowed.
 */
public class CustomizedMessages {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Rule> rules = new ArrayList<>();
		rules.add(new LengthRule(8, 16));
		rules.add(new WhitespaceRule());
		rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
		rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
		rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
		rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

		Properties props = new Properties();
		props.load(new FileInputStream("E:/Test/messages.properties"));
		MessageResolver resolver = new PropertiesMessageResolver(props);

		PasswordValidator validator = new PasswordValidator(resolver, rules);
		PasswordData password = new PasswordData("microsoft@123");
		RuleResult result = validator.validate(password);
		if (result.isValid()) {
			System.out.println("Password validated.");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
	}

}
