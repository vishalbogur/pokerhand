package com.tripactions.pokerhand.util;

import java.util.Comparator;

import com.tripactions.pokerhand.Hand;

/**
 * @author vishalbogur
 *
 */
public class HandComparator implements Comparator<Hand> {
	
	@Override
	public int compare(Hand o1, Hand o2) {
		if(ApplicationConstants.VALUES_MAP.get(o1.getHandValue()) > ApplicationConstants.VALUES_MAP.get(o2.getHandValue())) {
			return 0;
		}
		return -1;
	}

}
