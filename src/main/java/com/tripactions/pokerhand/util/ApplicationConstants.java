package com.tripactions.pokerhand.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Class represents the application constants.
 * 
 * @author vishalbogur
 *
 */
public class ApplicationConstants {

	public static final String[] VALUES = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };

	public static final String[] SUITS = { "C", "D", "H", "S" };

	public static final String[] ROYAL_FLUSH_VALUES = { "T", "J", "Q", "K", "A" };

	public static final String SINGLE_QUOTE = "'";

	public static final String COMMA = ",";
	
	public static final String DELIMITER_SPACE = " ";

	public static final String HAND_STRING = "hand";
	
	public static final String HIGH_CARD = "HIGH_CARD";

	public static final String ONE_PAIR = "ONE_PAIR";

	public static final String TWO_PAIR = "TWO_PAIR";

	public static final String THREE_OF_A_KIND = "THREE_OF_A_KIND";

	public static final String FULL_HOUSE = "FULL_HOUSE";

	public static final String FOUR_OF_A_KIND = "FOUR_OF_A_KIND";

	public static final String STRAIGHT = "STRAIGHT";

	public static final String FLUSH = "FLUSH";

	public static final String STRAIGHT_FLUSH = "STRAIGHT_FLUSH";

	public static final String ROYAL_FLUSH = "ROYAL_FLUSH";
	
	public static final String ERROR_MESSAGE = "Null or Empty input";
	
	public static final String VALIDATION_PATTERN = "((([2-9]|[Tt|Jj|Qq|Kk|Aa]){1}[Cc|Dd|Hh|Ss]{1})[ ]){5}";
	
	public static final String INVALID_INPUT = "Invalid input";
	
	public static final Map<String,Integer> VALUES_MAP = new HashMap<>();
	
	static {
		VALUES_MAP.put(HIGH_CARD,1);
		VALUES_MAP.put(ONE_PAIR,2);
		VALUES_MAP.put(TWO_PAIR,3);
		VALUES_MAP.put(THREE_OF_A_KIND,4);
		VALUES_MAP.put(STRAIGHT,5);
		VALUES_MAP.put(FLUSH,6);
		VALUES_MAP.put(FULL_HOUSE,7);
		VALUES_MAP.put(FOUR_OF_A_KIND,8);
		VALUES_MAP.put(STRAIGHT_FLUSH,9);
		VALUES_MAP.put(ROYAL_FLUSH,10);
	}
}
