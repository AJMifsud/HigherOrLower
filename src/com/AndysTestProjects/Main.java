package com.AndysTestProjects;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Deck deck = new Deck();
        Scanner console = new Scanner(System.in);
        String c = "";
        int score = 0;
        Card prev = new Card(0, 0);
        boolean gotRight = true;

        System.out.println("Welcome to Andy's Higher or Lower!");
        System.out.println("Press any key to shuffle");
        System.in.read();
        deck.shuffle();
        int r = (int) (Math.random() * (deck.cards.length));
        prev = deck.cards[r];
        //System.out.println(deck.cards[0]);
        do {
            while (gotRight = true) {
                c = "";
                r = (int) (Math.random() * (deck.cards.length));
                System.out.println(prev);
                System.out.print("Higher or Lower? (H/L): ");
                String input = console.next();
                System.out.println("Drawn: " + deck.cards[r]);
                if (!input.equalsIgnoreCase("H") && !input.equalsIgnoreCase("L")) {
                    System.out.println("Booo game over, do as I say.");
                    gotRight = false;
                } else {
                    int value = deck.cards[r].higherOrLower(prev);
                    if (input.equalsIgnoreCase("H")) {
                        System.out.println("You guessed: Higher");
                        if (value >= 0) {
                            gotRight = true;
                            score++;
                            System.out.println("Nice!\r\nScore: " + score + "\r\n");
                        } else {
                            gotRight = false;
                            score = 0;
                            System.out.println("\r\nToo Bad!\r\n");
                        }
                        prev = deck.cards[r];
                    } else if (input.equalsIgnoreCase("L")) {
                        System.out.println("You guessed: Lower");
                        if (value <= 0) {
                            gotRight = true;
                            score++;
                            System.out.println("Nice!\r\nScore: " + score + "\r\n");

                        } else {
                            gotRight = false;
                            score = 0;
                            System.out.println("\r\nToo Bad!\r\n");
                            while (!c.equalsIgnoreCase("Y") && !c.equalsIgnoreCase("N")) {
                                System.out.print("Try again? (Y/N): ");
                                c = console.next();
                            if (!c.equalsIgnoreCase("Y") && !c.equalsIgnoreCase("N")) {
                            System.out.println("Enter Y or N!");
                            c = "";
                            } else if (c.equalsIgnoreCase("N")) {
                                c = "N";
                            } else {
                                c = "Y";
                            }
                            }
                        }
                    } prev = deck.cards[r];
                }
            }
        } while (c.equalsIgnoreCase("Y")) ;
    }
}