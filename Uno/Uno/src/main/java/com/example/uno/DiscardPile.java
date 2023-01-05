package com.example.uno;

import java.util.ArrayList;

public class DiscardPile {

    private ArrayList<UnoCard> discard = new ArrayList<>(1);
    private UnoCard topCard;
    private int discardSize;
    public void setDiscardSize(int discardSize){
        this.discardSize = discardSize;
    }

    public UnoCard getTopCard(){
        return topCard;
    }

    public void increment(){
        discardSize++;
    }
    public void addCard(UnoCard card){
        topCard = card;
        discard.add(card);
    }
    public void clearPile(Deck deck){
        for(int i=0; i<discard.size()-1; i++){
            deck.getUnoDeck().add(discard.get(i));
            discard.remove(i);
        }
        deck.setSize(deck.getUnoDeck().size());
        discardSize = discard.size();
    }
    public boolean validDiscard(UnoCard card){
        // if it is the first card in the discard pile (start of game)
        // and the colour is black, any colour can be placed
        if(discardSize==1 && topCard.getColour()==4){
            return true;
        }
        // if black return true
        if(card.getColour()==4){
            return true;
        } else if(card.getColour()== topCard.getColour()){
            // returns true if card colour matches
            return true;
        } else if(card.getId()==topCard.getId()){
            // returns true if topCard id matches passed card
            return true;
        } else return false;
    }

    public ArrayList<UnoCard> getDiscard() {
        return discard;
    }
}
