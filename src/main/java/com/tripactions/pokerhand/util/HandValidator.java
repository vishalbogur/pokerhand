package com.tripactions.pokerhand.util;

import java.util.regex.Pattern;

import com.tripactions.pokerhand.exception.ApplicationException;

/**
 * Validates the inputs for creating a hand.
 * 
 * @author vishalbogur
 *
 */
public class HandValidator {

	/**
	 * Validates the input.
	 * 
	 * @param cardsInput
	 * @throws ApplicationException 
	 */
	public static void validateCardsInput(String cardsInput) throws ApplicationException {
		String pattern = "((([2-9]|[Tt|Jj|Qq|Kk|Aa]){1}[Cc|Dd|Hh|Ss]{1})[ ]){5}";
		Pattern p = Pattern.compile(pattern);
		if(!p.matcher(cardsInput+" ").matches()) {
			throw new ApplicationException("Invalid input");
		}
	}

	/**
	 * Checks the input for null and empty values.
	 * 
	 * @param cardsInput the input cards
	 * @return true if the input is not null and not empty, otherwise returns false.
	 */
	public static boolean isEmptyOrNull(String cardsInput) {
		return null != cardsInput && !cardsInput.isEmpty();
	}
}
