package com.AndysTestProjects;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Deck deck = new Deck();
        Scanner console = new Scanner(System.in);
        String c = "Y";
        int score = 0;
        Card prev = new Card(0, 0);

        System.out.println("Welcome to Andy's Higher or Lower!");
        System.out.println("Press any key to shuffle");
        System.in.read();
        deck.shuffle();
        while (c.equalsIgnoreCase("Y")) {
            int r = (int) (Math.random() * (deck.cards.length));
            prev = deck.cards[r];
                c = "";
                r = (int) (Math.random() * (deck.cards.length));
                System.out.println(prev);
                System.out.print("Higher or Lower? (H/L): ");
                String input = console.next();
                System.out.println("Drawn: " + deck.cards[r]);
                if (!input.equalsIgnoreCase("H") && !input.equalsIgnoreCase("L")) {
                    System.out.println("Booo game over, do as I say.");
                    c = "Y";
                } else {
                    int value = deck.cards[r].higherOrLower(prev);
                    if (input.equalsIgnoreCase("H")) {
                        System.out.println("You guessed: Higher");
                        if (value >= 0) {
                            c = "Y";
                            score++;
                            System.out.println("Nice!\r\nScore: " + score + "\r\n");
                        } else {
                            c = "N";
                            score = 0;
                            System.out.println("\r\nToo Bad!\r\n");
                        }
                        prev = deck.cards[r];
                    } else if (input.equalsIgnoreCase("L")) {
                        System.out.println("You guessed: Lower");
                        if (value <= 0) {
                            c = "Y";
                            score++;
                            System.out.println("Nice!\r\nScore: " + score + "\r\n");

                        } else {
                            c = "";
                            score = 0;
                            System.out.println("\r\nToo Bad!\r\n");
                            while (!c.equalsIgnoreCase("Y") && !c.equalsIgnoreCase("N")) {
                                System.out.print("Try again? (Y/N): ");
                                c = console.next();
                                if (!c.equalsIgnoreCase("Y") && !c.equalsIgnoreCase("N")) {
                                    System.out.println("Enter Y or N!");
                                    c = "";
                                }
                            }
                        }
                        prev = deck.cards[r];
                    }
                }
            }
        }
    }