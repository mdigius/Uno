package com.example.uno;

import javafx.scene.layout.HBox;

public class CPU{
    private Hand hand;
    private String name;
    private int selectedCard = -1;
    private HBox hBox = new HBox();
    private DiscardPile discardPile;
    private boolean firstAdded;
    private double xDraw = 422.77;
    private int prevHandSize = 7;
    private int yDraw = 575;
    private Deck deck;

    public CPU(DiscardPile dp){
        discardPile = dp;
        hand = new Hand();
    }

    public UnoCard getCPUDiscard(){
        for(int i=0; i<hand.getHandSize(); i++){
            if(discardPile.validDiscard(hand.getUnoHand().get(i))==true){
                return hand.getUnoHand().get(i);
            }
        }
        hand.draw(deck);
        if(discardPile.validDiscard(hand.getUnoHand().get(hand.getHandSize()-1))==true){
            return hand.getUnoHand().get(hand.getHandSize());
        }
        return null;
    }
}
