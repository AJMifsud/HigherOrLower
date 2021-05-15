package com.AndysTestProjects;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Deck deck = new Deck();
        Scanner console = new Scanner(System.in);
        String c = "Y";
        int score = 0;

        System.out.println("Welcome to Andy's Higher or Lower!");
        System.out.println("Press any key to shuffle");
        System.in.read();
        deck.shuffle();
        int r = (int) (Math.random() * (deck.cards.length));
        Card play = deck.cards[r];
        while (c.equalsIgnoreCase("Y")) {
            System.out.println(play);
            System.out.print("Higher or Lower? (H/L): ");
            String input = console.next();
            //Guess "H" or "L"
            if (!input.equalsIgnoreCase("H") && !input.equalsIgnoreCase("L")) {
                System.out.println("Booo game over, do as I say.");
                c = "";
            } else {
                //Draw a new card
                r = (int) (Math.random() * (deck.cards.length));
                System.out.println("Drawn: " + deck.cards[r]);
                int value = deck.cards[r].higherOrLower(play);
                if (input.equalsIgnoreCase("H")) {
                    //"Higher" guess
                    System.out.println("You guessed: Higher");
                    if (value >= 0) {
                        //If correct
                        c = "Y";
                        score++;
                        System.out.println("Nice!\r\nScore: " + score + "\r\n");
                        play = deck.cards[r];
                    } else {
                        //If wrong
                        c = "";
                        score = 0;
                        System.out.println("\r\nToo Bad!\r\n");
                        while (!c.equalsIgnoreCase("Y") && !c.equalsIgnoreCase("N")) {
                            //Loop until input is Y or N
                            System.out.print("Try again? (Y/N): ");
                            c = console.next();
                            if (!c.equalsIgnoreCase("Y") && !c.equalsIgnoreCase("N")) {
                                System.out.println("Enter Y or N!");
                                c = "";
                            }
                        }
                    }
                } else if (input.equalsIgnoreCase("L")) {
                    //"Lower" guess
                    System.out.println("You guessed: Lower");
                    if (value <= 0) {
                        //If correct
                        c = "Y";
                        score++;
                        System.out.println("Nice!\r\nScore: " + score + "\r\n");
                        play = deck.cards[r];
                    } else {
                        //If wrong
                        c = "";
                        score = 0;
                        System.out.println("\r\nToo Bad!\r\n");
                        while (!c.equalsIgnoreCase("Y") && !c.equalsIgnoreCase("N")) {
                            //Loop until input is Y or N
                            System.out.print("Try again? (Y/N): ");
                            c = console.next();
                            if (!c.equalsIgnoreCase("Y") && !c.equalsIgnoreCase("N")) {
                                System.out.println("Enter Y or N!");
                                c = "";
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Thanks for playing!");
        System.in.read();
    }
}