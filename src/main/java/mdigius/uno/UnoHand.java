package mdigius.uno;

import java.util.ArrayList;

public class UnoHand {
    private ArrayList<UnoCard> hand;
    private int handSize;

    public UnoHand(ArrayList<UnoCard> hand) {
        this.hand = hand;
        handSize = hand.size();
    }

    public ArrayList<UnoCard> getHand() {
        return hand;
    }
    public void setHand(ArrayList<UnoCard> hand) {
        this.hand = hand;
    }
    public int getHandSize() {
        return handSize;
    }
    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }
}
