package com.example.uno;

import java.util.ArrayList;

public class Hand {
    private ArrayList<UnoCard> unoHand = new ArrayList<>(1);
    private int handSize;
    private DiscardPile discardPile;
    public Hand(){
    }
    public void discard(int cardNo){
        if(discardPile.validDiscard(unoHand.get(cardNo))==true) {
            discardPile.addCard(unoHand.get(cardNo));
            unoHand.remove(cardNo);
            handSize--;
        } else{
            System.out.println("Cannot play card");
        }
    }


    public void draw(Deck deck){
        deck.sendCard(unoHand);
        handSize++;
    }


    public void dealHand(Deck deck){
        for(int i = 0; i<7; i++) {
            deck.sendCard(unoHand);
        }
        handSize = unoHand.size();
    }
    public int getHandSize(){
        return handSize;
    }

    public ArrayList<UnoCard> getUnoHand() {
        return unoHand;
    }
    public void decrementHandSize(){
        handSize--;
    }
}
