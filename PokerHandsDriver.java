package codeeval;

import codeeval.PokerHands.PokerHand;

public class PokerHandsDriver {

	final static int royalFlushRank = 23;
	final static int straightFlushRank = 22;
	final static int quadRank = 21;
	final static int fullHouseRank = 20;
	final static int flushRank = 19;
	final static int straightRank = 18;
	final static int tripsRank = 17;
	final static int twoPairRank = 16;
	final static int onePairRank = 15;

	final static int numOfCardsInHand = 5;

	public static void main(String[] args) throws Exception {

		PokerHand[] hands = new PokerHand[2];

		String line = "4C 3D 7C 3S 9S 9C 3C 3H 7H 2S";
		String line2 = "JS JH 4H 2C 9H QH KC 9D 4D 3S";
		String line3 = "AS 2S 3D 4D 5H 2H 3H 4D 5D 6S"; // h1 = special case
		String line4 = "TD JD QD KD AD TH JH QH KH AH";

		hands = createhands(line4);

		PokerHand h1 = hands[0];
		PokerHand h2 = hands[1];

		System.out.println("hand1 is: " + h1.toString());
		System.out.println("hand2 is: " + h2.toString());

		h1 = sortHand(h1);
		h2 = sortHand(h2);

		System.out.println("post sort");
		System.out.println("hand1 is: " + h1.toString());
		System.out.println("hand2 is: " + h2.toString());

		h1.rank = determineRank(h1);
		h2.rank = determineRank(h2);

		for (int i = 0; i < 5; i++) {
			System.out.println(h1.cardValues[i] + "\t" + h2.cardValues[i]);
		}

		System.out.println(h1.rank + " " + h2.rank);

		System.out
				.println("******************\nTESTING STUFF\n******************");

		System.out.println(isRoyalFlush(h1));
		System.out.println(isRoyalFlush(h2));

		// FIX EQUAL TIE BREAK FOR QUAD
		// System.out.println(tieBreakerMaster(h1, h2));
	}

	static String tieBreakerMaster(PokerHand h1, PokerHand h2) {
		// System.out.println("h1 rank: " + h1.getRank() + " h2 rank: "
		// + h2.getRank());
		if (h1.rank == royalFlushRank && h2.rank == royalFlushRank) {
			return "none";
		} else if (h1.rank == straightFlushRank && h2.rank == straightFlushRank) {

			PokerHand h = getHighCard(h1, h2);
			// no high card
			if (h == null) {
				System.out.println("line 53?");
				return "none";
			}
			if (h1.equals(h)) {
				return "left";
			} else if (h2.equals(h)) {
				return "right";
			} else { // unnecessary
				System.out.println("I should be studying for OS");
			}
		} else if (h1.rank == quadRank && h2.rank == quadRank) {
			return quadTieBreaker(h1, h2);
		} else if (h1.rank == fullHouseRank && h2.rank == fullHouseRank) {
			return fullHouseTieBreaker(h1, h2);
		} else if (h1.rank == flushRank && h2.rank == flushRank) {
			return flushTieBreaker(h1, h2);
		} else if (h1.rank == straightRank && h2.rank == straightRank) {
			return straightTieBreaker(h1, h2);
		} else if (h1.rank == tripsRank && h2.rank == tripsRank) {
			return tripsTieBreaker(h1, h2);
		} else if (h1.rank == twoPairRank && h2.rank == twoPairRank) {
			return twoPairTieBreaker(h1, h2);
		} else if (h1.rank == onePairRank && h2.rank == onePairRank) {
			return onePairTieBreaker(h1, h2);
		} else {
			// checks to see if hand are equal
			for (int i = 0; i < numOfCardsInHand; i++) {
				if (h1.cards[i].charAt(0) != h2.cards[i].charAt(0)) {
					break;
				} else if (i == 4) { // this should work
					return "none";
				}
			}
			// now we know they're different hands
			// loop through hands and compare at each index
			for (int i = numOfCardsInHand - 1; i >= 0; i--) {
				int a = getCardRank(h1.cards[i].charAt(0));
				int b = getCardRank(h2.cards[i].charAt(0));

				if (a > b)
					return "left";
				else if (a < b)
					return "right";

			}
		}
		return "end of tieBreaker";
	}

	/**
	 * TieBreakers
	 */

	static String quadTieBreaker(PokerHand h1, PokerHand h2) {
		int h1qv = 0;
		int h2qv = 0;

		// get quad value for each hand
		if (h1.cards[0].charAt(0) != h1.cards[1].charAt(0))
			h1qv = getCardRank(h1.cardValues[0]);
		else if (h1.cardValues[0] != h1.cardValues[4])
			h1qv = getCardRank(h1.cardValues[0]);

		if (h2.cardValues[0] != h2.cardValues[1])
			h2qv = getCardRank(h1.cardValues[0]);
		else if (h2.cardValues[0] != h2.cardValues[4])
			h1qv = getCardRank(h1.cardValues[0]);

		// compare quad values
		if (h1qv > h2qv) {
			return "left";
		} else if (h2qv > h1qv) {
			return "right";
		}
		// else compare 5th card
		int h1FifthCardVal = 0;
		int h2FifthCardVal = 0;

		char h1FirstCard = h1.cardValues[0];
		char h1SecondCard = h1.cardValues[1];
		char h1FourthCard = h1.cardValues[3];
		char h1FifthCard = h1.cardValues[4];

		char h2FirstCard = h2.cardValues[0];
		char h2SecondCard = h2.cardValues[1];
		char h2FourthCard = h2.cardValues[3];
		char h2FifthCard = h2.cardValues[4];

		// loop through cards if card val doesn't
		// get h1 high if first card is different
		if (h1FirstCard != h1SecondCard) 
			h1FifthCardVal = h1FirstCard;
		
		// h2 highest if first card is not in quad
		if (h2FirstCard != h2SecondCard) 
			h2FifthCardVal = h2FirstCard;
		
		// h1 highest fifth
		if (h1FifthCard != h1FourthCard)
			h1FifthCardVal = h1FifthCard;
			
		// h2 highest fifth
		if (h2FifthCard != h2FourthCard)
			h2FifthCardVal = h2FourthCard;

		if (h1FifthCardVal > h2FifthCardVal)
			return "left";
		else if (h2FifthCardVal > h1FifthCardVal)
			return "right";
		return "none";
	}

	static String fullHouseTieBreaker(PokerHand h1, PokerHand h2) {

		int h1TripsVal, h1PairVal;
		int h2TripsVal, h2PairVal;

		char h1FirstCard = h1.cardValues[0];
		char h1SecondCard = h1.cardValues[1];
		char h1ThirdCard = h1.cardValues[2];
		char h1FourthCard = h1.cardValues[3];

		char h2FirstCard = h2.cardValues[0];
		char h2SecondCard = h2.cardValues[1];
		char h2ThirdCard = h2.cardValues[2];
		char h2FourthCard = h2.cardValues[3];

		if ((h1FirstCard == h1SecondCard) && (h1FirstCard == h1ThirdCard)) {
			h1TripsVal = h1FirstCard; // first three cards will be index 0-2
			h1PairVal = h1FourthCard; // 4th and 5th card will be index 3-4
		} else {
			h1TripsVal = h1FourthCard;
			h1PairVal = h1FirstCard;
		}

		if ((h2FirstCard == h2SecondCard) && (h2FirstCard == h2ThirdCard)) {
			h2TripsVal = h2FirstCard; // we first three cards will be index 0-2
			h2PairVal = h2FourthCard; // 4th and 5th card will be index 3-4
		} else {
			h2TripsVal = h2FourthCard;
			h2PairVal = h2FirstCard;
		}

		if (h1TripsVal > h2TripsVal) {
			return "left";
		} else if (h2TripsVal > h1TripsVal) {
			return "right";
		} else if (h1PairVal > h2PairVal) {
			return "left";
		} else if (h2PairVal > h1PairVal) {
			return "right";
		} else {
			return "none";
		}

	}

	static String flushTieBreaker(PokerHand h1, PokerHand h2) {

		for (int i = numOfCardsInHand - 1; i >= 0; i--) {
			// get card rank
			int temp1 = Character.getNumericValue(h1.cards[i].charAt(0));
			if (temp1 >= 10) {
				temp1 = getFaceCardRank((h1.cards[i].charAt(0)));
			}

			int temp2 = Character.getNumericValue(h2.cards[i].charAt(0));
			if (temp2 >= 10) {
				temp2 = getFaceCardRank((h2.cards[i].charAt(0)));
			}

			if (temp1 > temp2)
				return "left";
			else if (temp2 > temp1)
				return "right";
		}
		return "none";

	}

	static String straightTieBreaker(PokerHand h1, PokerHand h2) {

		// check for special case where A-5 straight
		if (h1.cardValues[4] == 'A' && h2.cardValues[4] == 'A') {
			return "none";
		} else if (h1.cardValues[4] == 'A') {
			return "right";
		} else if (h2.cardValues[4] == 'A') {
			return "left";
		}

		for (int i = numOfCardsInHand - 1; i >= 0; i--) {
			// get card rank
			int temp1 = getCardRank(h1.cardValues[i]);
			int temp2 = getCardRank(h2.cardValues[i]);

			if (temp1 > temp2)
				return "left";
			else if (temp2 > temp1)
				return "right";
		}
		return "none";

	}

	static String tripsTieBreaker(PokerHand h1, PokerHand h2) {

		char h1FirstCard = h1.cardValues[0];
		char h1SecondCard = h1.cardValues[1];
		char h1ThirdCard = h1.cardValues[2];
		char h1FourthCard = h1.cardValues[3];
		char h1FifthCard = h1.cardValues[4];

		char h2FirstCard = h2.cardValues[0];
		char h2SecondCard = h2.cardValues[1];
		char h2ThirdCard = h2.cardValues[2];
		char h2FourthCard = h2.cardValues[3];
		char h2FifthCard = h2.cardValues[4];

		int firstTripVal = 0;
		int secondTripVal = 0;

		int h1Kicker = 0;
		int h1SecondK = 0, h2SecondK = 0;
		int h2Kicker = 0;

		// if trips is first 3 cards
		if (h1FirstCard == h1SecondCard && h1FirstCard == h1ThirdCard) {
			firstTripVal = getCardRank(h1FirstCard);

			h1Kicker = getCardRank(h1FourthCard);
			h1SecondK = getCardRank(h1FifthCard);

			if (h1SecondK > h1Kicker) {
				int temp = h1SecondK;
				h1SecondK = h1Kicker;
				h1Kicker = temp;
			}

		}

		if (h2FirstCard == h2SecondCard && h2FirstCard == h2ThirdCard) {
			secondTripVal = getCardRank(h2FirstCard);

			h2Kicker = getCardRank(h2FourthCard);
			h2SecondK = getCardRank(h2FifthCard);

			if (h2SecondK > h2Kicker) {
				int temp = h2SecondK;
				h2SecondK = h2Kicker;
				h2Kicker = temp;
			}

		}

		// if trips is mid 3 cards
		if (h1SecondCard == h1ThirdCard && h1SecondCard == h1FourthCard) {
			firstTripVal = getCardRank(h1SecondCard);
			h1Kicker = getCardRank(h1FirstCard);
			h1SecondK = getCardRank(h1FifthCard);

			if (h1SecondK > h1Kicker) {
				int temp = h1SecondK;
				h1SecondK = h1Kicker;
				h1Kicker = temp;
			}
		}

		if (h2SecondCard == h2ThirdCard && h2SecondCard == h2FourthCard) {
			secondTripVal = getCardRank(h2SecondCard);
			h2Kicker = getCardRank(h2FirstCard);
			h2SecondK = getCardRank(h2FifthCard);

			if (h2SecondK > h2Kicker) {
				int temp = h2SecondK;
				h2SecondK = h2Kicker;
				h2Kicker = temp;
			}
		}

		// if trips is last 3 cards
		if (h1ThirdCard == h1FourthCard && h1ThirdCard == h1FifthCard) {
			firstTripVal = getCardRank(h1ThirdCard);
			h1Kicker = getCardRank(h1FirstCard);
			h1SecondK = getCardRank(h1SecondCard);

			if (h1SecondK > h1Kicker) {
				int temp = h1SecondK;
				h1SecondK = h1Kicker;
				h1Kicker = temp;
			}
		}

		if (h2ThirdCard == h2FourthCard && h2ThirdCard == h2FifthCard) {
			secondTripVal = getCardRank(h2ThirdCard);
			h2Kicker = getCardRank(h2FirstCard);
			h2SecondK = getCardRank(h2SecondCard);

			if (h2SecondK > h2Kicker) {
				int temp = h2SecondK;
				h2SecondK = h2Kicker;
				h2Kicker = temp;
			}
		}

		if (firstTripVal > secondTripVal) {
			return "left";
		} else if (secondTripVal > firstTripVal) {
			return "right";
		}

		if (h1Kicker > h2Kicker) {
			return "left";
		} else if (h2Kicker > h1Kicker) {
			return "right";
		} else if (h1SecondK > h2SecondK) {
			return "left";
		} else if (h2SecondK > h1SecondK) {
			return "right";
		}

		return "none";
	}

	static String twoPairTieBreaker(PokerHand h1, PokerHand h2) {

		int h1TopVal = 0;
		int h1LowerVal = 0;
		int h1Kicker = 0;

		int h2TopVal = 0;
		int h2LowerVal = 0;
		int h2Kicker = 0;

		char h1FirstCard = h1.cardValues[0];
		char h1SecondCard = h1.cardValues[1];
		char h1ThirdCard = h1.cardValues[2];
		char h1FourthCard = h1.cardValues[3];
		char h1FifthCard = h1.cardValues[4];

		char h2FirstCard = h2.cardValues[0];
		char h2SecondCard = h2.cardValues[1];
		char h2ThirdCard = h2.cardValues[2];
		char h2FourthCard = h2.cardValues[3];
		char h2FifthCard = h2.cardValues[4];

		/* 3 possible scenarios for locations of two pair */

		// first 4 slots have pairs
		if (h1FirstCard == h1SecondCard && h1ThirdCard == h1FourthCard) {
			h1TopVal = getCardRank(h1FirstCard); // or second
			h1LowerVal = getCardRank(h1ThirdCard);// or fourth

			if (h1LowerVal > h1TopVal) {
				int temp = h1LowerVal;
				h1LowerVal = h1TopVal;
				h1TopVal = temp;
			}

			h1Kicker = getCardRank(h1FifthCard);
		}

		if (h2FirstCard == h2SecondCard && h2ThirdCard == h2FourthCard) {
			h2TopVal = getCardRank(h2FirstCard); // or second
			h2LowerVal = getCardRank(h2ThirdCard);// or fourth

			if (h2LowerVal > h2TopVal) {
				int temp = h2LowerVal;
				h2LowerVal = h2TopVal;
				h2TopVal = temp;
			}

			h2Kicker = getCardRank(h2FifthCard);
		}

		// two pair is split
		if (h1FirstCard == h1SecondCard && h1FourthCard == h1FifthCard) {
			h1TopVal = getCardRank(h1FirstCard); // or second
			h1LowerVal = getCardRank(h1FourthCard);// or fifth

			if (h1LowerVal > h1TopVal) {
				int temp = h1LowerVal;
				h1LowerVal = h1TopVal;
				h1TopVal = temp;
			}

			h1Kicker = getCardRank(h1ThirdCard);
		}

		if (h2FirstCard == h2SecondCard && h2FourthCard == h2FifthCard) {
			h2TopVal = getCardRank(h2FirstCard); // or second
			h2LowerVal = getCardRank(h2FourthCard);// or fifth

			if (h2LowerVal > h2TopVal) {
				int temp = h2LowerVal;
				h2LowerVal = h2TopVal;
				h2TopVal = temp;
			}

			h2Kicker = getCardRank(h2ThirdCard);
		}

		// last 4 slots have pairs
		if (h1SecondCard == h1ThirdCard && h1FourthCard == h1FifthCard) {
			h1TopVal = getCardRank(h1SecondCard); // or third
			h1LowerVal = getCardRank(h1FourthCard);// or fifth

			if (h1LowerVal > h1TopVal) {
				int temp = h1LowerVal;
				h1LowerVal = h1TopVal;
				h1TopVal = temp;
			}

			h1Kicker = getCardRank(h1FirstCard);
		}

		if (h2SecondCard == h2ThirdCard && h2FourthCard == h2FifthCard) {
			h2TopVal = getCardRank(h2SecondCard); // or third
			h2LowerVal = getCardRank(h2FourthCard);// or fifth

			if (h2LowerVal > h2TopVal) {
				int temp = h2LowerVal;
				h2LowerVal = h2TopVal;
				h2TopVal = temp;
			}

			h2Kicker = getCardRank(h2FirstCard);
		}

		if (h1TopVal > h2TopVal) {
			return "left";
		} else if (h2TopVal > h1TopVal) {
			return "right";
		} else if (h1LowerVal > h2LowerVal) {
			return "left";
		} else if (h2LowerVal > h1LowerVal) {
			return "right";
		} else if (h1Kicker > h2Kicker) {
			return "left";
		} else if (h2Kicker > h1Kicker) {
			return "right";
		}

		return "none";
	}

	static String onePairTieBreaker(PokerHand h1, PokerHand h2) {

		int h1pairVal = 0;
		int h2pairVal = 0;

		// find pair values
		for (int i = 0; i < numOfCardsInHand - 1; i++) {
			if (h1.cards[i].charAt(0) == h1.cards[++i].charAt(0)) {
				h1pairVal = getCardRank(h1.cards[i].charAt(0));
				break;
			}
			--i;
		}

		for (int i = 0; i < numOfCardsInHand - 1; i++) {
			if (h2.cards[i].charAt(0) == h2.cards[++i].charAt(0)) {
				h2pairVal = getCardRank(h2.cards[i].charAt(0));
				break;
			}
			--i;
		}

		// compare pair values
		if (h1pairVal > h2pairVal) {
			return "left";
		} else if (h2pairVal > h1pairVal) {
			return "right";
		}

		/*
		 * compare kicker
		 */

		int top = 0, mid = 0, bottom = 0;
		int top2 = 0, mid2 = 0, bottom2 = 0;

		for (int i = 0; i < numOfCardsInHand; i++) {

			int currentRank = getCardRank(h1.cards[i].charAt(0));

			if (currentRank == h1pairVal) {
				continue;
			} else if (bottom == 0) {
				bottom = currentRank;
			} else if (mid == 0) {
				mid = currentRank;
			} else if (top == 0) {
				top = currentRank;
			}

		}

		for (int i = 0; i < numOfCardsInHand; i++) {

			int currentRank = getCardRank(h2.cards[i].charAt(0));

			if (currentRank == h2pairVal) {
				continue;
			} else if (bottom2 == 0) {
				bottom2 = currentRank;
			} else if (mid2 == 0) {
				mid2 = currentRank;
			} else if (top2 == 0) {
				top2 = currentRank;
			}

		}

		if (top > top2)
			return "left";
		else if (top < top2)
			return "right";
		else if (mid > mid2)
			return "left";
		else if (mid < mid2)
			return "right";
		else if (top > top2)
			return "left";
		else if (bottom > bottom2)
			return "left";
		else if (bottom < bottom2)
			return "right";

		return "none";
	}

	/**
	 * Poker hand deciders
	 */

	static boolean isRoyalFlush(PokerHand hand) {
		if (isFlush(hand) && isStraight(hand) && ('T' == hand.cardValues[0])) {
			return true;
		}
		return false;
	}

	static boolean isStraightFlush(PokerHand hand) {
		if (isFlush(hand) && isStraight(hand)) {
			return true;
		}
		return false;
	}

	static boolean isQuad(PokerHand hand) {
		char firstCard = hand.cardValues[0];
		char secondCard = hand.cardValues[1];
		char thirdCard = hand.cardValues[2];
		char fourthCard = hand.cardValues[3];
		char fifthCard = hand.cardValues[4];
		// first 4 cards are a match
		if ((firstCard == secondCard) && (firstCard == thirdCard)
				&& ((firstCard == fourthCard))) {
			return true;
		} else if ((secondCard == thirdCard) && (secondCard == fourthCard)
				&& (secondCard == fifthCard)) {
			// last 4 cards are a match
			return true;
		}
		return false;
	}

	static boolean isFullHouse(PokerHand hand) {
		char firstCard = hand.cardValues[0];
		char secondCard = hand.cardValues[1];
		char thirdCard = hand.cardValues[2];
		char fourthCard = hand.cardValues[3];
		char fifthCard = hand.cardValues[4];
		if ((firstCard == secondCard)
				&& (thirdCard == fourthCard && thirdCard == fifthCard)) {
			return true;
		} else if ((firstCard == secondCard && firstCard == thirdCard)
				&& (fourthCard == fifthCard)) {
			return true;
		}
		return false;
	}

	static boolean isFlush(PokerHand hand) {
		char firstSuit = hand.cards[0].charAt(1);
		char secondSuit = hand.cards[1].charAt(1);
		char thirdSuit = hand.cards[2].charAt(1);
		char fourthSuit = hand.cards[3].charAt(1);
		char fifthSuit = hand.cards[4].charAt(1);
		if ((firstSuit == secondSuit) && (firstSuit == thirdSuit)
				&& (firstSuit == fourthSuit) && (firstSuit == fifthSuit)) {
			return true;
		}
		return false;
	}

	static boolean isStraight(PokerHand hand) {
		if ('2' == hand.cardValues[0] && '3' == hand.cardValues[1]
				&& '4' == hand.cardValues[2] && '5' == hand.cardValues[3]
				&& 'A' == hand.cardValues[4]) {
			return true;
		}
		int valArray[] = new int[5];
		for (int i = 0; i < numOfCardsInHand; i++) {

			int temp = getCardRank(hand.cardValues[i]);
			valArray[i] = temp;
		}
		for (int j = 0; j < 4; j++) {
			int curr = valArray[j];
			int next = valArray[j + 1];
			if (next != ++curr) {
				return false;
			}
		}
		return true;
	}

	static boolean isTrips(PokerHand hand) {
		char firstCard = hand.cardValues[0];
		char secondCard = hand.cardValues[1];
		char thirdCard = hand.cardValues[2];
		char fourthCard = hand.cardValues[3];
		char fifthCard = hand.cardValues[4];
		// first 3 cards are a match
		if ((firstCard == secondCard) && (firstCard == thirdCard)) {
			return true;
		} else if ((secondCard == thirdCard) && (secondCard == fourthCard)) {
			// middle 3 cards are a match
			return true;
		} else if ((thirdCard == fourthCard) && (thirdCard == fifthCard)) {
			return true;
		}
		return false;
	}

	static boolean isTwoPair(PokerHand hand) {
		char firstCard = hand.cardValues[0];
		char secondCard = hand.cardValues[1];
		char thirdCard = hand.cardValues[2];
		char fourthCard = hand.cardValues[3];
		char fifthCard = hand.cardValues[4];
		if ((firstCard == secondCard) && (thirdCard == fourthCard)) {
			return true;
		} else if ((firstCard == secondCard) && (fourthCard == fifthCard)) {
			return true;
		} else if ((secondCard == thirdCard) && (fourthCard == fifthCard)) {
			return true;
		}
		return false;
	}

	static boolean isOnePair(PokerHand hand) {
		char firstCard = hand.cardValues[0];
		char secondCard = hand.cardValues[1];
		char thirdCard = hand.cardValues[2];
		char fourthCard = hand.cardValues[3];
		char fifthCard = hand.cardValues[4];

		if (firstCard == secondCard) {
			return true;
		} else if (secondCard == thirdCard) {
			return true;
		} else if (thirdCard == fourthCard) {
			return true;
		} else if (fourthCard == fifthCard) {
			return true;
		}
		return false;
	}

	/**
	 * Utilities
	 */

	private static PokerHand[] createhands(String line) {
		PokerHand h1 = new PokerHand();
		PokerHand h2 = new PokerHand();
		String tokens[] = line.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			// fill first hand
			if (i <= 4) {
				h1.cards[i] = tokens[i];
				// fill second hand
			} else {
				h2.cards[i - 5] = tokens[i];
			}
		}

		PokerHand[] tuple = new PokerHand[2];
		tuple[0] = h1;
		tuple[1] = h2;
		return tuple;
	}

	static PokerHand sortHand(PokerHand hand) {

		// insertion sort
		for (int i = 0; i < numOfCardsInHand; i++) {
			// compare to remaining elements in array
			for (int j = i + 1; j < numOfCardsInHand; j++) {
				int temp = getCardRank(hand.cards[i].charAt(0));
				int temp2 = getCardRank(hand.cards[j].charAt(0));

				// if smaller than current index than swap
				if (temp2 < temp) {
					String s = hand.cards[i];
					hand.cards[i] = hand.cards[j];
					hand.cards[j] = s;
				}
			}
			hand.cardValues[i] = hand.cards[i].charAt(0);
		}

		return hand;
	}

	static int determineRank(PokerHand hand) {
		if (isRoyalFlush(hand)) {
			return royalFlushRank;
		}
		if (isStraightFlush(hand)) {
			return straightFlushRank;
		}
		if (isQuad(hand)) {
			return quadRank;
		}
		if (isFullHouse(hand)) {
			return fullHouseRank;
		}
		if (isFlush(hand)) {
			return flushRank;
		}
		if (isStraight(hand)) {
			return straightRank;
		}
		if (isTrips(hand)) {
			return tripsRank;
		}
		if (isTwoPair(hand)) {
			return twoPairRank;
		}
		if (isOnePair(hand)) {
			return onePairRank;
		}
		// else get high card
		int max = 0;
		for (int i = 0; i < numOfCardsInHand; i++) {

			int temp = getCardRank(hand.cardValues[i]);
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	static int getCardRank(char c) {
		int rank;
		rank = Character.getNumericValue(c);
		if (rank >= 10) {
			rank = getFaceCardRank(c);
		}
		return rank;
	}

	static int getFaceCardRank(char c) {
		int r = 0;
		switch (c) {
		case 'T':
			r = 10;
			break;
		case 'J':
			r = 11;
			break;
		case 'Q':
			r = 12;
			break;
		case 'K':
			r = 13;
			break;
		case 'A':
			r = 14;
			break;
		default:
			System.out.println("error in switch in getFaceCardRank"); // should never happen
			break;
		}
		return r;
	}

	static PokerHand getHighCard(PokerHand h1, PokerHand h2) {
		PokerHand high = null;
		int h1Val = 0;
		int h2Val = 0;

		for (int i = numOfCardsInHand - 1; i >= 0; i--) {
			// get card rank
			int temp1 = getCardRank(h1.cardValues[i]);

			if (temp1 > h1Val) {
				h1Val = temp1;
			}

			int temp2 = getCardRank(h2.cardValues[i]);

			if (temp2 > h2Val) {
				h2Val = temp2;
			}
		}
		// compare rank
		if (h1Val > h2Val) {
			high = h1;
			return high;
		} else if (h2Val > h1Val) {
			high = h2;
			return high;
		}
		return high;
	}

	/* Poker Hand class */
	public static class PokerHand {
		String[] cards;
		char[] cardValues;
		int rank;

		public PokerHand() {
			this.cards = new String[5];
			this.cardValues = new char[5];
			this.rank = 0;
		}

		public int getRank() {
			return this.rank;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof PokerHand)) {
				return false;
			}
			PokerHand that = (PokerHand) other;
			// Custom equality check here.
			return this.cards.equals(that.cards)
					&& this.cardValues.equals(that.cardValues)
					&& this.rank == that.rank;
		}

		public String toString() {
			return this.cards[0] + " " + this.cards[1] + " " + this.cards[2]
					+ " " + this.cards[3] + " " + this.cards[4];
		}
	}
