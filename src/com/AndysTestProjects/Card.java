package com.AndysTestProjects;

public class Card {
    private final int rank;
    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static final String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
    };

    public static final String[] RANKS = {
            null, null, "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };

    public String toString() {
        String s;
        if (SUITS[this.suit].equals("Clubs") || SUITS[this.suit].equals("Spades")) {
            s = RANKS[this.rank] + " of " + SUITS[this.suit];
        } else {
            s = RANKS[this.rank] + " of " + SUITS[this.suit];
        }
        return s;
    }
/*
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        return Integer.compare(this.rank, that.rank);
    }
*/
    public int higherOrLower(Card that) {
        return Integer.compare(this.rank, that.rank);
    }
}
