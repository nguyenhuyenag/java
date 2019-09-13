package learn.regex;

import org.apache.commons.lang3.StringUtils;

public class PatternUtils {

	public static final String ANY 				=	".";
	public static final String FIRST 			= 	"^";
	public static final String LAST 			= 	"$";

	public static final String NUMBERS 			= 	"\\d"; 	// [0-9]
	public static final String NOT_NUMBERS		= 	"\\D"; 	// [^0-9]
	public static final String SPACE 			= 	"\\s";
	public static final String NOT_SPACE 		= 	"\\S"; 	// [^\s]
	public static final String SPACES 			= 	"\\s+";
	public static final String NOT_SPACES 		= 	"\\S+";	// not one or multi space 
	public static final String WORD 			= 	"\\w"; 	// [a-zA-Z_0-9]
	public static final String NOT_WORD 		= 	"\\W"; 	// [^\w]
	
	public static final String ZERO_OR_MULTI 	= 	"*"; 		// {0,}
	public static final String ONE_OR_MULTI 	= 	"+"; 		// {1,}
	public static final String ZERO_OR_ONE 		= 	"?"; 		// {0,1}
	public static final String X 				= 	"{X}"; 		// {X}
	public static final String XY 				= 	"{X,Y}"; 	// {X,Y}
	public static final String UNKNOW 			= 	"*?";
	
	public static final String SPEACIE 			= "\\.[{(*+?^$|";	// => \\
	
	public static void main(String[] args) {
		
		String str = "This is  my   text";
		String newText = str.trim().replaceAll("\\s+", "\\s");
		System.out.println(newText);
		System.out.println(StringUtils.normalizeSpace(str));
		
	}
	

}
