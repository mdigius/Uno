package com.example.uno;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Player {
    private Hand hand;
    private String name;
    private int selectedCard = -1;
    private HBox hBox = new HBox();
    private DiscardPile discardPile;
    private boolean firstAdded;
    private double xDraw = 422.77;
    private int prevHandSize = 7;
    private int yDraw = 575;

    public void removeCard(){
        hand.getUnoHand().remove(selectedCard);
    }

    public Player(DiscardPile dp){
        hand = new Hand();
        discardPile = dp;

    }

    public void setSelectedCard(int selectedCard){
        this.selectedCard = selectedCard;
    }

    public int getSelectedCard(){
        return selectedCard;
    }

    public Hand getHand(){
        return hand;
    }

    public void drawHand(Group root){
        if(firstAdded==true) {
            root.getChildren().remove(hBox);
        }
        // Function to draw hand every time new card is added / removed
        // Clears the previous hBox and sets its location to center
        // need to fix formula to center even with variable hand sizes
        if(hand.getHandSize()>prevHandSize){
            xDraw-=31.39;
        } else if(hand.getHandSize()<prevHandSize && hand.getHandSize() != 0){
            xDraw+=31.39;
        }
            hBox.getChildren().clear();
            hBox.setLayoutX(xDraw);
            hBox.setLayoutY(620);
            hBox.setSpacing(5);
        // Iterates through the entire hand
        for(int i=0; i< hand.getHandSize(); i++){
            int temp = i;
            // Adds each UnoCard object from the hand's cardImg into the HBox
            hBox.getChildren().add(hand.getUnoHand().get(i).getCardImg());
            // Creates an action event for each of the cards when mouse is clicked
            hBox.getChildren().get(i).setOnMouseClicked((MouseEvent e) -> {
                // Mouse events starts by iterating through the entire hand
                // and checking to see what card is currently selected
                // can be simplified now that there is cardSelected field
                for(int j=0; j<hand.getHandSize(); j++){
                    if(hand.getUnoHand().get(j).isSelected()==true){
                        hBox.getChildren().get(j).setTranslateY(0);
                        hand.getUnoHand().get(j).setSelected(false);
                    }
                }
                // Checks to see if the card would be a valid placement
                if(discardPile.validDiscard(hand.getUnoHand().get(temp))){
                    // If so sets it as selected and raises it 15 pixels to indicate so

                    hand.getUnoHand().get(temp).setSelected(true);
                    hBox.getChildren().get(temp).setTranslateY(-15);
                    selectedCard = temp;
                    System.out.println(selectedCard);
                }
            });
            prevHandSize = hand.getHandSize();


        }
        // Adds the HBox to the passed root
        root.getChildren().add(hBox);
        firstAdded = true;
    }




}
