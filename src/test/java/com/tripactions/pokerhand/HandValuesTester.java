package com.tripactions.pokerhand;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tripactions.pokerhand.exception.ApplicationException;
import com.tripactions.pokerhand.util.ApplicationConstants;

/**
 * Tests correctness of the hand values based on the input cards.
 * 
 * @author vishalbogur
 *
 */
public class HandValuesTester {

	@Test
	public void testForRoyalFlush() throws ApplicationException {
		Hand royalFlush = Hand.fromString("TS js QS KS AS");
		assertTrue(royalFlush.getHandValue().equalsIgnoreCase(ApplicationConstants.ROYAL_FLUSH));
	}

	@Test
	public void testForStraightFlush() throws ApplicationException {
		Hand straightFlush = Hand.fromString("5S 6S 7S 8S 9S");
		assertTrue(straightFlush.getHandValue().equalsIgnoreCase(ApplicationConstants.STRAIGHT_FLUSH));
	}

	@Test
	public void testForFourOfAKind() throws ApplicationException {
		Hand fourOfAKind = Hand.fromString("7S TC TH TS TD");
		assertTrue(fourOfAKind.getHandValue().equalsIgnoreCase(ApplicationConstants.FOUR_OF_A_KIND));
	}

	@Test
	public void testForThreeOfAKind() throws ApplicationException {
		Hand threeOfAKind = Hand.fromString("TS TC QS TH AS");
		assertTrue(threeOfAKind.getHandValue().equalsIgnoreCase(ApplicationConstants.THREE_OF_A_KIND));
	}

	@Test
	public void testForFullHouse() throws ApplicationException {
		Hand fullHouse = Hand.fromString("5H 5C QD QC QS");
		assertTrue(fullHouse.getHandValue().equalsIgnoreCase(ApplicationConstants.FULL_HOUSE));
	}

	@Test
	public void testForFlush() throws ApplicationException {
		Hand flush = Hand.fromString("2D 3D 7D QD AD");
		assertTrue(flush.getHandValue().equalsIgnoreCase(ApplicationConstants.FLUSH));
	}

	@Test
	public void testForStraight() throws ApplicationException {
		Hand straight = Hand.fromString("4D 5D 6D 7H 8D");
		assertTrue(straight.getHandValue().equalsIgnoreCase(ApplicationConstants.STRAIGHT));
	}

	@Test
	public void testForTwoPair() throws ApplicationException {
		Hand twoPair = Hand.fromString("TS TC QS QH AS");
		assertTrue(twoPair.getHandValue().equalsIgnoreCase(ApplicationConstants.TWO_PAIR));
	}

	@Test
	public void testForOnePair() throws ApplicationException {
		Hand onePair = Hand.fromString("TS TC QS KH AS");
		assertTrue(onePair.getHandValue().equalsIgnoreCase(ApplicationConstants.ONE_PAIR));
	}

	@Test
	public void testForHighCard() throws ApplicationException {
		Hand highCard = Hand.fromString("TS 3C QS KH AS");
		assertTrue(highCard.getHandValue().equalsIgnoreCase(ApplicationConstants.HIGH_CARD));
	}
	
}
