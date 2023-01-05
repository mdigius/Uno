package com.example.uno;

import java.util.ArrayList;

public class GameManager {
    private Player player;
    private ArrayList<CPU> cpuArray = new ArrayList<>(1);
    private Deck deck;
    private DiscardPile dp;

    private int activeTurn= 0;

    private boolean drewCard = false;

    public boolean getDrewCard(){
        return drewCard;
    }
    public void setDrewCard(boolean bool){
        drewCard = bool;
    }
    public int getActiveTurn(){
        return activeTurn;
    }



    public GameManager(Player player, ArrayList<CPU> cpuArray, Deck deck, DiscardPile dp){
        this.player = player;
        this.cpuArray = cpuArray;
        this.deck = deck;
        this.dp = dp;
    }

    public void cpuControl(){
        // Goes through the entire arraylist of cpu type, and controls

    }

    public void endTurn(){
        activeTurn = 1;
        drewCard = false;

    }




}
