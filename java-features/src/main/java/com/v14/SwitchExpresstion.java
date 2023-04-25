package com.v14;

import org.apache.commons.lang3.StringUtils;

/*-
  - Yield isn’t a new keyword in Java. It’s just used in switch expressions
  
    // Ternary operator
	var isMonday = day == Day.Monday ? true : false;

	// Switch expression
	var isMonday = switch (day) {
	    case MONDAY -> true;
	    default -> false;
	};
 */
public class SwitchExpresstion {
	
	public static void main(String[] args) {
		String dayOfWeek = "2";
		String result = switch (dayOfWeek) {
			case "2", "3", "4", "5", "6" -> "Working Day";
			case "0", "7" -> "Day Off";
			default -> {
				if (StringUtils.isEmpty(dayOfWeek))
					yield "Please insert a valid day";
				else
					yield "Looks like wrong!";
			}
		};
		System.out.println(result);
	}

}
