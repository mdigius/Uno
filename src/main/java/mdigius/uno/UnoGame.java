package mdigius.uno;

import java.util.ArrayList;
import java.util.Random;

public class UnoGame {
    private ArrayList<UnoPlayer> players;
    private int playersNum;
    private int activeNum;
    private UnoPlayer activePlayer;
    private UnoPlayer winner;
    private UnoDeck deck;


    public UnoGame(ArrayList<UnoPlayer> players, UnoDeck deck){
        this.players = players;
        this.deck = deck;
        playersNum = players.size();
        setFirstPlayer();
    }

    private void setFirstPlayer(){
        Random rand = new Random();
        activeNum = rand.nextInt(0, playersNum-1);
        activePlayer = players.get(activeNum);
    }

    public void playTurn(){
        activePlayer.playTurn();
    }



}
