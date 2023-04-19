package mdigius.uno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UnoDeck {
    private ArrayList<UnoCard> unoDeck = new ArrayList<>(1);
    String[] cardNames = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "picker",
            "reverse", "skip"};
    String[] colours = {"blue", "green", "red", "yellow"};

    public UnoDeck(){
        createDeck();
        for(int i = 0; i< unoDeck.size(); i++){
            System.out.println(unoDeck.get(i));
        }
    }

    public void createDeck(){
        // Adds the cards to the uno deck based on the official uno rules
        for(int i = 0; i<colours.length; i++){
            for(int j = 0; j<cardNames.length; j++){
                UnoCard card = new UnoCard(cardNames[j], colours[i]);
                unoDeck.add(card);
            }
        }
        for(int i = 0; i<colours.length; i++){
            for(int j = 1; j<cardNames.length; j++){
                UnoCard card = new UnoCard(cardNames[j], colours[i]);
                unoDeck.add(card);
            }
        }
        for(int i = 0; i<4; i++){
            UnoCard card = new UnoCard("pick_four", "wild");
            UnoCard card2 = new UnoCard("color_changer", "wild");
            unoDeck.add(card);
            unoDeck.add(card2);
        }

    }

    public int getDeckSize(){
        return unoDeck.size();
    }

    public UnoCard pickupCard(){
        UnoCard topCard = unoDeck.get(0);
        unoDeck.remove(0);
        return topCard;
    }

    public void shuffleDeck(){
        Collections.shuffle(unoDeck);
    }






}
