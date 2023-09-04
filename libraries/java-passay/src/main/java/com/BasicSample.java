package com;

import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.RuleResultDetail;

public class BasicSample {

	public static void main(String[] args) {
		PasswordValidator passwordValidator = new PasswordValidator(new LengthRule(5));
		PasswordData passwordData = new PasswordData();
		passwordData.setPassword("1234");
		RuleResult validate = passwordValidator.validate(passwordData);
		System.out.println("IsValid: " + validate.isValid());

		RuleResultDetail ruleResultDetail = validate.getDetails().get(0);
		System.out.println(ruleResultDetail.getErrorCode());
		System.out.println(ruleResultDetail.getParameters().get("minimumLength"));
		System.out.println(ruleResultDetail.getParameters().get("maximumLength"));
	}

}
