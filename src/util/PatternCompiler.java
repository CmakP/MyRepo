package util;

import java.util.regex.Pattern;

public class PatternCompiler {

	/**
	 * Validates the input based on the desired pattern.
	 * 
	 * @param input to be validated
	 * @param pattern to be used as a regex
	 * @return true if the input matches the regex and false otherwise
	 */
	public static boolean checkPattern(final String input, final String pattern) {
		return Pattern.compile(pattern).matcher(input).matches();
	}
}
