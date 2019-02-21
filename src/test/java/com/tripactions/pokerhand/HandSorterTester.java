package com.tripactions.pokerhand;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tripactions.pokerhand.exception.ApplicationException;
import com.tripactions.pokerhand.util.HandSorter;

/**
 * Tests the sorting of hands based on their values.
 * 
 * @author vishalbogur
 *
 */
public class HandSorterTester {

	@Test
	public void testForSorting() throws ApplicationException {
		
		Hand h1 = Hand.fromString("ts Js qS KS AS");//Royal flush
		Hand h2 = Hand.fromString("5S 6S 7S 8S 9S");//Straight flush
		Hand h3 = Hand.fromString("7S TC TH TS TD");//Four of a kind
		Hand h4 = Hand.fromString("5H 5C QD QC QS");//Full House;
		Hand h5 = Hand.fromString("2D 3D 7D QD AD");//Flush
		Hand h6 = Hand.fromString("4D 5D 6D 7H 8D");//Straight
		Hand h7 = Hand.fromString("TS TC QS TH AS");//Three of a kind
		Hand h8 = Hand.fromString("TS TC QS QH AS");//Two pair
		Hand h9 = Hand.fromString("TS TC QS KH AS");//Pair
		Hand h10 = Hand.fromString("TS 3C QS KH AS");//High card
		
		List<Hand> handsList = new ArrayList<>();
		
		handsList.add(h1);
		handsList.add(h2);
		handsList.add(h3);
		handsList.add(h4);
		handsList.add(h5);
		handsList.add(h6);
		handsList.add(h7);
		handsList.add(h8);
		handsList.add(h9);
		handsList.add(h10);
		
		List<Hand> handsListSorted = new ArrayList<>();
		handsListSorted.add(h10);
		handsListSorted.add(h9);
		handsListSorted.add(h8);
		handsListSorted.add(h7);
		handsListSorted.add(h6);
		handsListSorted.add(h5);
		handsListSorted.add(h4);
		handsListSorted.add(h3);
		handsListSorted.add(h2);
		handsListSorted.add(h1);
		
		HandSorter handSorter = new HandSorter();
		handSorter.sortHands(handsList);
		
		assertEquals(handsList, handsListSorted);
		
	}
}
