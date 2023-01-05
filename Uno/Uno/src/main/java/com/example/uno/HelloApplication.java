package com.example.uno;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 1280,720);
        scene.setFill(Color.MAROON);
        stage.setTitle("Uno!");
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.getIcons().add(new Image("file:src/imgs/appIcon.png"));
        stage.show();

        Deck deck = new Deck();
        DiscardPile dp = new DiscardPile();
        deck.sendCardToDiscardPile(dp);

        Player player = new Player(dp);
        player.getHand().dealHand(deck);
        System.out.println(player.getHand().getUnoHand());
        System.out.println(deck.getUnoDeck());

        GameManager gm = new GameManager(player, null, deck, dp);

        root.getChildren().add(UnoCard.backImg);
        root.getChildren().get(0).setLayoutX(567.22);
        root.getChildren().get(0).setLayoutY(319.557);
        root.getChildren().get(0).setOnMouseClicked((MouseEvent e) -> {
            if(gm.getActiveTurn()==0) {
                if (gm.getDrewCard() == false) {
                    player.getHand().draw(deck);
                    player.drawHand(root);
                    gm.setDrewCard(true);
                    System.out.println(player.getHand().getUnoHand());
                }
                boolean bool = false;
                for(int i=0; i<player.getHand().getHandSize(); i++){
                    if(dp.validDiscard(player.getHand().getUnoHand().get(i))==true){
                        bool = true;
                    }
                }
                if(bool==false){
                    gm.endTurn();
                }
            }

        });

        ImageView topCard = dp.getTopCard().getCardImg();


        root.getChildren().add(topCard);
        root.getChildren().get(1).setLayoutX(630);
        root.getChildren().get(1).setLayoutY(319.557);
        // Mouse event for clicking on the top card of the discard pile
        root.getChildren().get(1).setOnMouseClicked((MouseEvent e) -> {
            System.out.println(dp.getTopCard());
            if(gm.getActiveTurn()==0){
                // If statement to verify that a card is actually selected (-1 is null indicator)
                if (player.getSelectedCard() != -1) {
                    // No need to verify if it is a valid placement because this is done in player class
                    if (player.getHand().getUnoHand().get(player.getSelectedCard()).getColour() == 4) {
                        // If statement that occurs if a black card is placed to handle logic for
                        // letting user select the colour
                        System.out.println("Black card placed");
                        HBox colourPicker = new HBox();
                        Button red = new Button("Red");
                        Button yellow = new Button("Yellow");
                        Button blue = new Button("Blue");
                        Button green = new Button("Green");
                        red.setOnMouseClicked((MouseEvent b) -> {
                            root.getChildren().remove(colourPicker);
                            dp.getTopCard().setColourNum(0);
                        });
                        yellow.setOnMouseClicked((MouseEvent b) -> {
                            root.getChildren().remove(colourPicker);
                            dp.getTopCard().setColourNum(1);
                        });
                        blue.setOnMouseClicked((MouseEvent b) -> {
                            root.getChildren().remove(colourPicker);
                            dp.getTopCard().setColourNum(2);
                        });
                        green.setOnMouseClicked((MouseEvent b) -> {
                            root.getChildren().remove(colourPicker);
                            dp.getTopCard().setColourNum(3);
                        });
                        colourPicker.getChildren().addAll(red, yellow, blue, green);
                        colourPicker.setLayoutX(500);
                        colourPicker.setLayoutY(500);
                        root.getChildren().add(colourPicker);

                    }
                    dp.addCard(player.getHand().getUnoHand().get(player.getSelectedCard()));
                    player.removeCard();
                    player.setSelectedCard(-1);
                    player.getHand().decrementHandSize();
                    player.drawHand(root);
                    topCard.setImage(dp.getTopCard().getCardImgFile());

                }
                gm.endTurn();
            }
        });
        System.out.println(dp.getDiscard());
        System.out.println(deck.getUnoDeck());

        player.drawHand(root);




    }


    public static void main(String[] args) {
        launch();
    }
}