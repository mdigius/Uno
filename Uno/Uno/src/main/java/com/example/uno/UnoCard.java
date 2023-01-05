package com.example.uno;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class UnoCard {
    private int id;
    private String cardVal;
    private String colour;
    private int colourNum;
    private int value;
    public static ImageView backImg = new ImageView(new Image("file:src/imgs/card_back_alt.png"));

    private ImageView imgView;
    private Image cardImg;
    private boolean selected;

    public Image getCardImgFile(){
        return cardImg;
    }


    public UnoCard(int id, int colourNum) throws IOException {
        backImg.setFitHeight(80.8867);
        backImg.setFitWidth(57.78);
        this.value = value;
        this.id = id;
        this.colourNum = colourNum;
        setCard();
        setCardImg();
    }
    public void setSelected(Boolean bool){
        selected = bool;
    }

    public void setColourNum(int colourNum){
        this.colourNum = colourNum;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getColour(){
        return colourNum;
    }
    public int getId(){
        return id;
    }
    public ImageView getCardImg(){
        imgView = new ImageView(this.cardImg);
        imgView.setFitHeight(80.8867);
        imgView.setFitWidth(57.78);
        return imgView;
    }

    public void setCard(){
        switch(colourNum){
            case 0:
                colour = "Red";
                break;
            case 1:
                colour = "Yellow";
                break;
            case 2:
                colour = "Blue";
                break;
            case 3:
                colour = "Green";
                break;
            case 4:
                colour = "Black";
                break;
        }
        switch(id){
            case 0:
                cardVal = "0";
                break;
            case 1:
                cardVal = "1";
                break;
            case 2:
                cardVal = "2";
                break;
            case 3:
                cardVal = "3";
                break;
            case 4:
                cardVal = "4";
                break;
            case 5:
                cardVal = "5";
                break;
            case 6:
                cardVal = "6";
                break;
            case 7:
                cardVal = "7";
                break;
            case 8:
                cardVal = "8";
                break;
            case 9:
                cardVal = "9";
                break;
            case 10:
                cardVal = "Skip";
                break;
            case 11:
                cardVal = "Reverse";
                break;
            case 12:
                cardVal = "Draw";
                break;
            case 13:
                cardVal = "Wild";
                break;
            case 14:
                cardVal = "Wild4";
                break;

        }

    }


    @Override
    public String toString(){
        return colour + " " + cardVal;
    }
    public void setCardImg() throws IOException {
        if (this.colourNum == 0) {
            switch (id) {
                case 0 -> this.cardImg = new Image("file:src/imgs/red_0.png");
                case 1 -> this.cardImg = new Image("file:src/imgs/red_1.png");
                case 2 -> this.cardImg = new Image("file:src/imgs/red_2.png");
                case 3 -> this.cardImg = new Image("file:src/imgs/red_3.png");
                case 4 -> this.cardImg = new Image("file:src/imgs/red_4.png");
                case 5 -> this.cardImg = new Image("file:src/imgs/red_5.png");
                case 6 -> this.cardImg = new Image("file:src/imgs/red_6.png");
                case 7 -> this.cardImg = new Image("file:src/imgs/red_7.png");
                case 8 -> this.cardImg = new Image("file:src/imgs/red_8.png");
                case 9 -> this.cardImg = new Image("file:src/imgs/red_9.png");
                case 10 -> this.cardImg = new Image("file:src/imgs/red_skip.png");
                case 11 -> this.cardImg = new Image("file:src/imgs/red_reverse.png");
                case 12 -> this.cardImg = new Image("file:src/imgs/red_picker.png");
            }
        } else if (this.colourNum==1){
            switch (id) {
                case 0 -> this.cardImg = new Image("file:src/imgs/yellow_0.png");
                case 1 -> this.cardImg = new Image("file:src/imgs/yellow_1.png");
                case 2 -> this.cardImg = new Image("file:src/imgs/yellow_2.png");
                case 3 -> this.cardImg = new Image("file:src/imgs/yellow_3.png");
                case 4 -> this.cardImg = new Image("file:src/imgs/yellow_4.png");
                case 5 -> this.cardImg = new Image("file:src/imgs/yellow_5.png");
                case 6 -> this.cardImg = new Image("file:src/imgs/yellow_6.png");
                case 7 -> this.cardImg = new Image("file:src/imgs/yellow_7.png");
                case 8 -> this.cardImg = new Image("file:src/imgs/yellow_8.png");
                case 9 -> this.cardImg = new Image("file:src/imgs/yellow_9.png");
                case 10 -> this.cardImg = new Image("file:src/imgs/yellow_skip.png");
                case 11 -> this.cardImg = new Image("file:src/imgs/yellow_reverse.png");
                case 12 -> this.cardImg = new Image("file:src/imgs/yellow_picker.png");
            }
        } else if (this.colourNum==2){
            switch (id) {
                case 0 -> this.cardImg = new Image("file:src/imgs/blue_0.png");
                case 1 -> this.cardImg = new Image("file:src/imgs/blue_1.png");
                case 2 -> this.cardImg = new Image("file:src/imgs/blue_2.png");
                case 3 -> this.cardImg = new Image("file:src/imgs/blue_3.png");
                case 4 -> this.cardImg = new Image("file:src/imgs/blue_4.png");
                case 5 -> this.cardImg = new Image("file:src/imgs/blue_5.png");
                case 6 -> this.cardImg = new Image("file:src/imgs/blue_6.png");
                case 7 -> this.cardImg = new Image("file:src/imgs/blue_7.png");
                case 8 -> this.cardImg = new Image("file:src/imgs/blue_8.png");
                case 9 -> this.cardImg = new Image("file:src/imgs/blue_9.png");
                case 10 -> this.cardImg = new Image("file:src/imgs/blue_skip.png");
                case 11 -> this.cardImg = new Image("file:src/imgs/blue_reverse.png");
                case 12 -> this.cardImg = new Image("file:src/imgs/blue_picker.png");
            }
        } else if (this.colourNum==3){
            switch (id) {
                case 0 -> this.cardImg = new Image("file:src/imgs/green_0.png");
                case 1 -> this.cardImg = new Image("file:src/imgs/green_1.png");
                case 2 -> this.cardImg = new Image("file:src/imgs/green_2.png");
                case 3 -> this.cardImg = new Image("file:src/imgs/green_3.png");
                case 4 -> this.cardImg = new Image("file:src/imgs/green_4.png");
                case 5 -> this.cardImg = new Image("file:src/imgs/green_5.png");
                case 6 -> this.cardImg = new Image("file:src/imgs/green_6.png");
                case 7 -> this.cardImg = new Image("file:src/imgs/green_7.png");
                case 8 -> this.cardImg = new Image("file:src/imgs/green_8.png");
                case 9 -> this.cardImg = new Image("file:src/imgs/green_9.png");
                case 10 -> this.cardImg = new Image("file:src/imgs/green_skip.png");
                case 11 -> this.cardImg = new Image("file:src/imgs/green_reverse.png");
                case 12 -> this.cardImg = new Image("file:src/imgs/green_picker.png");
            }
        } else if (this.colourNum==4){
            switch (id) {
                case 13 -> this.cardImg = new Image("file:src/imgs/wild_color_changer.png");
                case 14 -> this.cardImg = new Image("file:src/imgs/wild_pick_four.png");
            }
        }
    }

}
