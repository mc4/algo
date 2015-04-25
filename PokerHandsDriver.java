//package practice;

public class PokerHandsDriver {

	final static int numOfCardsInHand = 5;
	final static int royalFlushRank = 23;
	final static int straightFlushRank = 22;
	final static int quadRank = 21;
	final static int fullHouseRank = 20;
	final int flushRank = 19;
	final int straightRank = 18;
	final int tripsRank = 17;
	final int twoPairRank = 16;
	final int onePairRank = 15;

	public static void main(String[] args) throws Exception {

		String line = null;
		PokerHand[] hands = new PokerHand[2];

		line = "4H 4D 3C 4S 4C 5D 4S 5C 5H 5D";

		hands = createhands(line);
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

		System.out.println(h1.getRank());
		System.out.println(h2.getRank());

		// FIX EQUAL TIE BREAK FOR QUAD
		System.out.println(tieBreaker(h1, h2));

	}

	/* THIS IS WHY THEY TELL YOU TO MODULARIZE STUFF LOL */
	static String tieBreaker(PokerHand h1, PokerHand h2) {

		// System.out.println("h1 rank: " + h1.getRank() + " h2 rank: "
		// + h2.getRank());

		if (h1.rank == royalFlushRank && h2.rank == royalFlushRank) {
			return "none";
		} else if (h1.rank == straightFlushRank && h2.rank == straightFlushRank) {
			/* might want to modularize this? */
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
			} else {
				System.out.println("I should be studying for OS");
			}

		} else if (h1.rank == quadRank && h2.rank == quadRank) {
			int h1qv = 0;
			int h2qv = 0;

			System.out.println("*********hi from quad check*********");

			// get quad value for each hand
			if (h1.cards[0].charAt(0) != h1.cards[1].charAt(0)) {

				h1qv = Character.getNumericValue(h1.cards[0].charAt(0));
				if (h1qv >= 10) {
					h1qv = getFaceCardRank((h1.cards[0].charAt(0)));
				}

			} else if (h1.cards[0].charAt(0) != h1.cards[4].charAt(0)) {

				h1qv = Character.getNumericValue(h1.cards[4].charAt(0));
				if (h1qv >= 10) {
					h1qv = getFaceCardRank((h1.cards[4].charAt(0)));
				}
			}

			if (h2.cards[0].charAt(0) != h2.cards[1].charAt(0)) {

				h2qv = Character.getNumericValue(h2.cards[0].charAt(0));
				if (h2qv >= 10) {
					h2qv = getFaceCardRank((h2.cards[0].charAt(0)));
				}

			} else if (h2.cards[0].charAt(0) != h2.cards[4].charAt(0)) {
				h2qv = Character.getNumericValue(h2.cards[4].charAt(0));
				if (h2qv >= 10) {
					h2qv = getFaceCardRank((h2.cards[4].charAt(0)));
				}
			}

			System.out.println(h1qv + " vs " + h2qv);
			// compare quad values
			if (h1qv > h2qv) {
				return "left";
			} else if (h2qv > h1qv) {
				return "right";
			}

			// else compare 5th card
			int h1FifthCard = 0;
			int h2FifthCard = 0;

			// loop through cards if card val doesn't

			// get h1 high if first card is different
			if (h1.cardValues[0] != h1.cardValues[1]) {
				h1FifthCard = h1.cardValues[0];
			}
			// h2 highest if first card is not in quad
			if (h2.cardValues[0] != h2.cardValues[1]) {
				h2FifthCard = h2.cardValues[0];
			}

			// h1 highest fifth
			if (h1.cardValues[4] != h1.cardValues[3]) {
				h1FifthCard = h1.cardValues[4];
			}
			// h2 highest fifth
			if (h2.cardValues[4] != h2.cardValues[3]) {
				h2FifthCard = h2.cardValues[3];
			}

			if (h1FifthCard > h2FifthCard) {
				return "left";
			} else if (h2FifthCard > h1FifthCard) {
				return "right";
			}

			return "none";
		} else if (h1.rank == fullHouseRank && h2.rank == fullHouseRank) {

		}

		System.out.println("line 153");
		return null;
	}

	// returns the hand in first index and index of high card in second index
	// return null if no high card is found
	static PokerHand getHighCard(PokerHand h1, PokerHand h2) {

		PokerHand high = null;
		int h1Val = 0;
		int h2Val = 0;

		// System.out.println();
		// System.out.println(h1.toString() + " in gHC");
		// System.out.println(h2.toString() + " in gHC");
		// System.out.println();

		for (int i = numOfCardsInHand - 1; i >= 0; i--) {

			// get card rank
			int temp1 = Character.getNumericValue(h1.cards[i].charAt(0));
			if (temp1 >= 10) {
				temp1 = getFaceCardRank((h1.cards[i].charAt(0)));
			}

			if (temp1 > h1Val) {
				h1Val = temp1;
			}

			int temp2 = Character.getNumericValue(h2.cards[i].charAt(0));
			if (temp2 >= 10) {
				temp2 = getFaceCardRank((h2.cards[i].charAt(0)));
			}

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

	static boolean isRoyalFlush(PokerHand hand) {
		if (isFlush(hand) && isStraight(hand)) {
			int a = getMinIndex(hand);
			if ('T' == hand.cards[a].charAt(0))
				return true;
		}

		return false;
	}

	private static boolean isStraightFlush(PokerHand hand) {
		if (isFlush(hand) && isStraight(hand)) {
			return true;
		}
		return false;
	}

	private static boolean isQuad(PokerHand hand) {

		char firstCard = hand.cards[0].charAt(0);
		char secondCard = hand.cards[1].charAt(0);
		char thirdCard = hand.cards[2].charAt(0);
		char fourthCard = hand.cards[3].charAt(0);
		char fifthCard = hand.cards[4].charAt(0);

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

		char firstCard = hand.cards[0].charAt(0);
		char secondCard = hand.cards[1].charAt(0);
		char thirdCard = hand.cards[2].charAt(0);
		char fourthCard = hand.cards[3].charAt(0);
		char fifthCard = hand.cards[4].charAt(0);

		if ((firstCard == secondCard)
				&& (thirdCard == fourthCard && thirdCard == fifthCard)) {
			return true;
		} else if ((firstCard == secondCard && firstCard == thirdCard)
				&& (fourthCard == fifthCard)) {
			return true;
		}

		return false;
	}

	public static boolean isFlush(PokerHand hand) {

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

		if ('2' == hand.cards[0].charAt(0) && '3' == hand.cards[1].charAt(0)
				&& '4' == hand.cards[2].charAt(0)
				&& '5' == hand.cards[3].charAt(0)
				&& 'A' == hand.cards[4].charAt(0)) {
			return true;
		}

		int valArray[] = new int[5];
		for (int i = 0; i < numOfCardsInHand; i++) {
			int temp = Character.getNumericValue(hand.cards[i].charAt(0));
			if (temp >= 10) {
				temp = getFaceCardRank((hand.cards[i].charAt(0)));
			}
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

	private static boolean isTrips(PokerHand hand) {

		char firstCard = hand.cards[0].charAt(0);
		char secondCard = hand.cards[1].charAt(0);
		char thirdCard = hand.cards[2].charAt(0);
		char fourthCard = hand.cards[3].charAt(0);
		char fifthCard = hand.cards[4].charAt(0);

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

	private static boolean isTwoPair(PokerHand hand) {

		char firstCard = hand.cards[0].charAt(0);
		char secondCard = hand.cards[1].charAt(0);
		char thirdCard = hand.cards[2].charAt(0);
		char fourthCard = hand.cards[3].charAt(0);
		char fifthCard = hand.cards[4].charAt(0);

		if ((firstCard == secondCard) && (thirdCard == fourthCard)) {
			return true;
		} else if ((firstCard == secondCard) && (fourthCard == fifthCard)) {
			return true;
		} else if ((secondCard == thirdCard) && (fourthCard == fifthCard)) {
			return true;
		}

		return false;
	}

	private static boolean isOnePair(PokerHand hand) {

		char firstCard = hand.cards[0].charAt(0);
		char secondCard = hand.cards[1].charAt(0);
		char thirdCard = hand.cards[2].charAt(0);
		char fourthCard = hand.cards[3].charAt(0);
		char fifthCard = hand.cards[4].charAt(0);

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

	/***************
	 * Utilities *
	 ***************/
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
			System.out.println("error in switch in getFaceCardRank");
			break;
		}
		return r;
	}

	// returns index of smallest card in hand
	static int getMinIndex(PokerHand hand) {

		int min = 100;
		int minIndex = 0;

		// handle this error more gracefully?
		if (hand == null)
			return 1000;

		// get smallest card value in hand
		for (int i = 0; i < numOfCardsInHand; i++) {

			int currCard = Character.getNumericValue(hand.cards[i].charAt(0));

			// if min is number card
			if ((currCard >= 2) && (currCard <= 9) && (currCard < min)) {
				min = currCard;
				minIndex = i;
				continue;
			}

			/*
			 * if min is face card numeric vals of face card char T: 29 J: 19 Q:
			 * 26 K: 20 A: 10
			 */
			if ((currCard == 29) && (10 < min)) {
				min = 10;
				minIndex = i;
			} else if (currCard == 19 && (11 < min)) {
				min = 11;
				minIndex = i;
			} else if ((currCard == 26) && (12 < min)) {
				min = 12;
				minIndex = i;
			} else if (currCard == 20 && (13 < min)) {
				min = 13;
				minIndex = i;
			} else if (currCard == 10 && (14 < min)) {
				min = 14;
				minIndex = i;
			}

		}
		return minIndex;
	}

	static PokerHand sortHand(PokerHand hand) {

		// insertion sort
		for (int i = 0; i < numOfCardsInHand; i++) {

			// compare to remaining elements in array
			int j;
			for (j = i + 1; j < numOfCardsInHand; j++) {
				int temp = Character.getNumericValue(hand.cards[i].charAt(0));
				if (temp >= 10) {
					temp = getFaceCardRank((hand.cards[i].charAt(0)));
				}
				int temp2 = Character.getNumericValue(hand.cards[j].charAt(0));
				if (temp2 >= 10) {
					temp2 = getFaceCardRank((hand.cards[j].charAt(0)));
				}
				// if smaller than current index than swap
				if (temp2 < temp) {
					String c = hand.cards[i];
					hand.cards[i] = hand.cards[j];
					hand.cards[j] = c;
				}

			}

		}

		return hand;
	}

	static int determineRank(PokerHand hand) {
		if (isRoyalFlush(hand)) {
			return 23;
		}
		if (isStraightFlush(hand)) {
			return 22;
		}
		if (isQuad(hand)) {
			return 21;
		}
		if (isFullHouse(hand)) {
			return 20;
		}
		if (isFlush(hand)) {
			return 19;
		}
		if (isStraight(hand)) {
			return 18;
		}
		if (isTrips(hand)) {
			return 17;
		}
		if (isTwoPair(hand)) {
			return 16;
		}
		if (isOnePair(hand)) {
			return 15;
		}

		// else get high card
		int max = 0;
		for (int i = 0; i < numOfCardsInHand; i++) {
			int temp = Character.getNumericValue(hand.cards[i].charAt(0));
			if (temp >= 10) {
				temp = getFaceCardRank((hand.cards[i].charAt(0)));
			}
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	private static PokerHand[] createhands(String line) {

		PokerHand h1 = new PokerHand();
		PokerHand h2 = new PokerHand();
		String tokens[] = line.split(" ");

		for (int i = 0; i < tokens.length; i++) {
			// fill first hand
			if (i <= 4) {
				h1.cards[i] = tokens[i];

				if (Character.isDigit(h1.cards[i].charAt(0))) {
					h1.cardValues[i] = Character.getNumericValue(h1.cards[i]
							.charAt(0)) - 1;
				} else {
					h1.cardValues[i] = getFaceCardRank(h1.cards[i].charAt(0)) - 1;
				}

				// fill second hand
			} else {
				h2.cards[i - 5] = tokens[i];

				if (Character.isDigit(h2.cards[i - 5].charAt(0))) {
					h2.cardValues[i - 5] = Character
							.getNumericValue(h2.cards[i - 5].charAt(0)) - 1;
				} else {
					h2.cardValues[i - 5] = getFaceCardRank(h2.cards[i - 5]
							.charAt(0)) - 1;
				}

			}
		}

		PokerHand[] tuple = new PokerHand[2];
		tuple[0] = h1;
		tuple[1] = h2;

		return tuple;
	}

	/* Poker Hand class */
	public static class PokerHand {

		String[] cards;
		int[] cardValues;
		int rank;

		public PokerHand() {
			this.cards = new String[5];
			this.cardValues = new int[5];
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
}
