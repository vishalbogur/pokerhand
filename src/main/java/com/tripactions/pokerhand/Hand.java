package com.tripactions.pokerhand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.tripactions.pokerhand.exception.ApplicationException;
import com.tripactions.pokerhand.util.ApplicationConstants;
import com.tripactions.pokerhand.util.HandValidator;

/**
 * Represents a hand in the game of poker.
 * 
 * @author vishalbogur
 *
 */
public class Hand {


	/**
	 * Cards in a hand.
	 */
	private List<String> cards;

	/**
	 * Value of the hand.
	 */
	private String handValue;
	
	

	/**
	 * Creates a hand if a valid input is passed.
	 * @param cardsInput
	 * @return hand in case of valid input.
	 * @throws ApplicationException
	 */
	public static Hand fromString(String cardsInput) throws ApplicationException {
		if(HandValidator.isNotEmptyOrNull(cardsInput)) {
			HandValidator.validateCardsInput(cardsInput);
			cardsInput = cardsInput.toUpperCase();
			String[] cardValues = cardsInput.split(ApplicationConstants.DELIMITER_SPACE);
			return new Hand(Arrays.asList(cardValues));
		}
		throw new ApplicationException(ApplicationConstants.ERROR_MESSAGE);
	}


	/**
	 * Makes sure that constructor is not visible for initialization thus enforcing
	 * the initialization via fromString().
	 */
	private Hand() {
	}

	private Hand(List<String> cardsValues) {
		this.cards = cardsValues;
		this.determineHandValue();
	}

	/**
	 * Check the cards to determine the value of the hand.
	 */
	private void determineHandValue() {

		List<String> suitsList = Arrays.asList(ApplicationConstants.SUITS);

		List<String> cardsList = this.cards;

		suitsList = suitsList.stream().filter(suit -> Hand.count(this.cards.toString(), suit) == 5)
				.collect(Collectors.toList());

		cardsList = cardsList.stream().map(card -> Character.toString(card.charAt(0))).collect(Collectors.toList());

		if (!suitsList.isEmpty()) {
			// FLUSH, ROYAL FLUSH, STRAIGHT FLUSH
			 checkFlushCategory(cardsList);
		} 
		else if(checkIfTheCardsAreInSequence(cardsList)){
			//STRAIGHT
			this.setHandValue(ApplicationConstants.STRAIGHT);
		}
		else {
				Collections.sort(cardsList);
				String prevValue = null;
				List<Integer> similarCardCount = new ArrayList<>();
				int valueCount = 0;
				for (String s : cardsList) {
					valueCount = Hand.count(this.cards.toString(), s);
					// FOUR OF A KIND, 
					if (valueCount == 4) {
						this.setHandValue(ApplicationConstants.FOUR_OF_A_KIND);
						return;
					}
					if (!s.equalsIgnoreCase(prevValue)) {
						similarCardCount.add(1);
					}
					prevValue = s;

				}
				// FULL_HOUSE, TWO PAIR, ONE PAIR, HIGH CARD, THREE OF A KIND
				checkIfPairsAndOthers(similarCardCount,valueCount);
			}
		
	}
	

	private void checkFlushCategory(List<String> cardsList) {

		if (cardsList.containsAll(Arrays.asList(ApplicationConstants.ROYAL_FLUSH_VALUES))) {
			this.setHandValue(ApplicationConstants.ROYAL_FLUSH);
		} else {
			// straight flush or flush
			if (checkIfTheCardsAreInSequence(cardsList)) {
				this.setHandValue(ApplicationConstants.STRAIGHT_FLUSH);
			} else {
				this.setHandValue(ApplicationConstants.FLUSH);
			}
		}
	}


	private void checkIfPairsAndOthers(List<Integer> similarCardCount, int vauleCount) {
		switch (similarCardCount.size()) {
		case 2:
			this.setHandValue(ApplicationConstants.FULL_HOUSE);
			break;

		case 3:
			if (vauleCount == 3) {
				this.setHandValue(ApplicationConstants.THREE_OF_A_KIND);
			}
			else {
				this.setHandValue(ApplicationConstants.TWO_PAIR);}
			break;

		case 4:
			this.setHandValue(ApplicationConstants.ONE_PAIR);
			break;

		default:
			this.setHandValue(ApplicationConstants.HIGH_CARD);
		}
	}


	


	/**
	 * Checks if the hand has sequential values of cards. 
	 * For ex: [TS, JD, QC, KS, AH] or [2S, 3H, 4H, 5S ,6C]
	 * @param cardsList the cards to be checked.
	 * @return true if the cards are in sequence otherwise false.
	 */
	private boolean checkIfTheCardsAreInSequence(List<String> cardsList) {
		
		List<String> cardValuesList = Arrays.asList(ApplicationConstants.VALUES);
		int index = cardValuesList.indexOf(cardsList.get(0));
		int count = 0;
		for (int i = 0; i < 5; i++) {
			// To-DO: Possible that if index=13 then break the code and result will be FLUSH
			index = index == 13 ? 0 : index;
			if (cardsList.get(i).equalsIgnoreCase(cardValuesList.get(index))) {
				count++;
			}
			index++;
		}

		if (count == 5) {
			return true;
		}
		
		return false;
	}

	/**
	 * Checks how many times a character(particular suit) is present in a string(the cards).
	 * 
	 * @param source source string in which the given character needs to be counted.
	 * @param target character to be counted.
	 * @return the count of the occurrence of the character.
	 */
	public static int count(String source, String target) {
		return (source.length() - source.replace(target, "").length()) / target.length();
	}

	@Override
	public String toString() {

		StringBuffer handString = new StringBuffer(ApplicationConstants.HAND_STRING + this.cards.toString() + ApplicationConstants.COMMA);

		handString.append(ApplicationConstants.SINGLE_QUOTE + this.handValue + ApplicationConstants.SINGLE_QUOTE);

		return handString.toString();
	}

	public String getHandValue() {
		return handValue;
	}

	public void setHandValue(String handValue) {
		this.handValue = handValue;
	}

}
