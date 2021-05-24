package com.AndysTestProjects;

public class Deck {
    public Card[] cards;

    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 2; rank <= 14; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }
    public void shuffle() {
        for (int i = 0; i < this.cards.length; i++) {
            int r = i + (int) (Math.random() * (this.cards.length - i));
            Card temp = this.cards[r];
            this.cards[r] = this.cards[i];
            this.cards[i] = temp;
        }
        System.out.println("\r\nSHUFFLING...\r\n");
    }
    public Card drawCard(){
        int r = (int) (Math.random() * (this.cards.length));
        Card drawnCard = this.cards[r];
        return drawnCard;
    }

    /*public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }*/
}
