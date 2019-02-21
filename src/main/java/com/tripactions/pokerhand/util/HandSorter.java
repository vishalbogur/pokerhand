package com.tripactions.pokerhand.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tripactions.pokerhand.Hand;

/**
 * Class to sort the hands according to their values.
 * @author vishalbogur
 *
 */
public class HandSorter {
	
	public static final Comparator<Hand> handComparator = new HandComparator();
	
	public void sortHands(List<Hand> handsList) {
		
		Collections.sort(handsList, handComparator);
		
	}
	
}
