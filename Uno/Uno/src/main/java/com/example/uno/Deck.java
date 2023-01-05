package com.example.uno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<UnoCard> unoDeck = new ArrayList<>(1);
    private int deckSize;

    public Deck() throws IOException {
        createDeck();
        deckSize = unoDeck.size();
        shuffleDeck();
        System.out.println(unoDeck);
    }
    public void decrementDeckSize(){
        deckSize--;
    }
    public void sendCard(ArrayList<UnoCard> hand){
            hand.add(unoDeck.get(0));
            unoDeck.remove(0);
    }
    public void sendCardToDiscardPile(DiscardPile dp){
        dp.addCard(unoDeck.get(0));
        unoDeck.remove(0);
        dp.increment();
    }

    public ArrayList<UnoCard> getUnoDeck() {
        return unoDeck;
    }

    public void shuffleDeck(){
        Collections.shuffle(unoDeck);
    }

    public void createDeck() throws IOException {
        // Adds the cards to the uno deck based on the official uno rules
        for(int i = 0; i<13; i++){
            unoDeck.add(new UnoCard(i,0));
            unoDeck.add(new UnoCard(i,1));
            unoDeck.add(new UnoCard(i,2));
            unoDeck.add(new UnoCard(i,3));
        }
        for(int i = 1; i<13; i++){
            unoDeck.add(new UnoCard(i,0));
            unoDeck.add(new UnoCard(i,1));
            unoDeck.add(new UnoCard(i,2));
            unoDeck.add(new UnoCard(i,3));
        }
        for(int i = 13; i<15; i++){
            unoDeck.add(new UnoCard(i,4));
            unoDeck.add(new UnoCard(i,4));
            unoDeck.add(new UnoCard(i,4));
            unoDeck.add(new UnoCard(i,4));
        }
    }
    public int getSize(){
        return unoDeck.size();
    }
    public void setSize(int deckSize){
        this.deckSize = deckSize;
    }
}
