package mdigius.uno;

import java.util.ArrayList;

public interface UnoPlayer {

    int getHandSize();
    void placeCard();
    void drawCard();
    void setUnoHad(UnoHand unoHand);
    void playTurn();
    UnoHand getUnoHand();
}
