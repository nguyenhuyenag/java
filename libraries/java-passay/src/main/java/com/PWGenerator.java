package com;

import java.util.ArrayList;
import java.util.List;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class PWGenerator {

	public void example_1() {
		CharacterRule alphabets = new CharacterRule(EnglishCharacterData.Alphabetical);
		CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
		CharacterRule special = new CharacterRule(EnglishCharacterData.Special);

		PasswordGenerator passwordGenerator = new PasswordGenerator();
		String password = passwordGenerator.generatePassword(8, alphabets, digits, special);
		System.out.println(password);
	}

	public String passayPassGenerator(int len, boolean uppr, boolean lowr, boolean num, boolean spec) {
		CharacterRule numbers = new CharacterRule(EnglishCharacterData.Digit);
		CharacterRule special = new CharacterRule(EnglishCharacterData.Special);
		CharacterRule upperCase = new CharacterRule(EnglishCharacterData.UpperCase);
		CharacterRule lowerCase = new CharacterRule(EnglishCharacterData.LowerCase);
		List<CharacterRule> rules = new ArrayList<>();
		if (uppr) {
			rules.add(upperCase);
		}
		if (lowr) {
			rules.add(lowerCase);
		}
		if (num) {
			rules.add(numbers);
		}
		if (spec) {
			rules.add(special);
		}
		PasswordGenerator passwordGenerator = new PasswordGenerator();
		return passwordGenerator.generatePassword(len, rules);
	}

	public static void main(String[] args) {
		// example1();
	}

}
