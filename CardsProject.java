package com.gurukul.day17;

import java.util.Random;
import java.util.Scanner;

class Cards {

    String face;
    String Suit;

    public Cards() {
    }

    public Cards(String face, String suit) {
	super();
	this.face = face;
	Suit = suit;
    }

    public String getFace() {
	return face;
    }

    public void setFace(String face) {
	this.face = face;
    }

    public String getSuit() {
	return Suit;
    }

    public void setSuit(String suit) {
	Suit = suit;
    }

    @Override
    public String toString() {
	return "Cards [face=" + face + ", Suit=" + Suit + "]";
    }
}

public class CardsProject {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	String face[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	String Suit[] = { "Spades", "Hearts", "Diamonds", "Clubs" };
	Random rand = new Random();
	Cards arr[] = new Cards[10];

	for (int i = 0; i < 10; i++) {
	    arr[i] = new Cards(face[rand.nextInt(13)], Suit[rand.nextInt(4)]);
	}

	int Score = 0;
	Scanner sc = new Scanner(System.in);

	System.out.println("Welcome to Memory!\r\n"
		+ "Your goal is to match two cards, using either the same face (i.e. King) or the\r\n"
		+ "same suit (i.e. Clubs).\r\n" + "If you get an exact match, you get 2 points!\r\n");

	char ch;
	int totalScore = 0, percentage = 0, totalRound = 0, totalG = 0, currectG = 0;
	out: do {

	    System.out.println("How many points do you want to shoot for?\r\n");
	    Score = sc.nextInt();
	    System.out.println("The round will end after you get" + Score + " points.\r\n" + "Pick two cards:");
	    while (totalScore < Score) {
//		totalRound += 1;
		System.out.println("Pick two cards:\r\n" + "| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |\r\n"
			+ "Select first card (or 'q' to quit this round): ");
		String v = sc.next();
		if (v == "q") {
		    break;
		}
		int card1 = Integer.parseInt(v);
		System.out.println("First card is: " + arr[card1].getFace() + " of " + arr[card1].getSuit());
		System.out.println("Select second card: \r\n");
		int card2 = sc.nextInt();
		if (card1 == card2) {
		    do {
			System.out.println("Select second card (different from the first card): ");
			card2 = sc.nextInt();
		    } while (card2 == card1);
		}
		// sc.next();f
		System.out.println("Second card is: " + arr[card2].getFace() + " of " + arr[card2].getSuit());

		for (int i = 0; i < arr.length; i++) {
		    if (i == card1) {
			System.out.print("| " + arr[card1]);
		    } else if (i == card2) {
			System.out.print("| " + arr[card2]);

		    } else {
			System.out.print("| " + i);
		    }
		}

		if (arr[card1].getFace() == arr[card2].getFace() && arr[card1].getSuit() == arr[card2].getSuit()) {
		    totalScore += 2;
		    currectG++;
		    System.out.println("*** Found an EXACT match!! " + arr[card1].getFace() + " and "
			    + arr[card2].getSuit() + " ***\r\n" + "");
		    System.out.println("Replacing those with two new cards.\r\n" + "Current score is " + totalScore);
		    System.out.println();
		    System.out.println("Replacing those with two new cards.");
		    arr[card1].setFace(face[rand.nextInt(13)]);
		    arr[card1].setSuit(Suit[rand.nextInt(4)]);
		    arr[card2].setFace(face[rand.nextInt(13)]);
		    arr[card2].setSuit(Suit[rand.nextInt(4)]);

		} else if (arr[card1].getFace() == arr[card2].getFace()) {
		    totalScore += 1;
		    currectG++;
		    System.out.println("* Found a match!! " + arr[card1] + " and " + arr[card2] + " *");
		    System.out.println();
		    System.out.println("Replacing those with two new cards.");
		    arr[card1].setFace(face[rand.nextInt(13)]);
		    arr[card1].setSuit(Suit[rand.nextInt(4)]);
		    arr[card2].setFace(face[rand.nextInt(13)]);
		    arr[card2].setSuit(Suit[rand.nextInt(4)]);
		} else if (arr[card1].getSuit() == arr[card2].getSuit()) {
		    totalScore += 1;
		    currectG++;
		    System.out.println("* Found a match!! " + arr[card1] + " and " + arr[card2] + " *");
		    System.out.println();
		    System.out.println("Replacing those with two new cards.");
		    arr[card1].setFace(face[rand.nextInt(13)]);
		    arr[card1].setSuit(Suit[rand.nextInt(4)]);
		    arr[card2].setFace(face[rand.nextInt(13)]);
		    arr[card2].setSuit(Suit[rand.nextInt(4)]);
		} else {
		    System.out.println("Sorry, no match! :( Try again.");
		}
		System.out.println("Your Total Score is : " + totalScore);
		totalG++;
	    }
	    System.out.println(
		    "Congrats, you won!! Your guess score is : " + getPercent((double) currectG, (double) totalG));
	    System.out.println("Wow, that was fun! You want to play again?");
	    ch = sc.next().charAt(0);
	    if (ch == 'n' || ch == 'N') {
		System.out.println("That was fun, come back if you want more practice!");
		break out;
	    } else if (!(ch == 'y') && !(ch == 'Y')) {
		System.out.println("Enter a valid input!");
	    }
	} while (true);

    }

    public static double getPercent(double x, double y) {

	return (x / y) * 100;
    }

}
