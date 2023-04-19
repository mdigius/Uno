package mdigius.uno;


import javafx.scene.image.Image;

public class UnoCard {
    private String cardName;
    private String cardColour;
    private String imgPath;
    private Image cardImg;
    boolean hasAction;

    private int id;
    public UnoCard(String cardName, String cardColour) {
        this.cardName = cardName;
        this.cardColour = cardColour;
        setCardImg();
        setAction();
    }
    public void setAction(){
        if(id == 0){
            hasAction = true;
        } else hasAction = false;
    }
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Image getCardImg() {
        return cardImg;
    }

    public void setCardImg() {
        String path = "file:src/main/resources/mdigius/uno/imgs/cards/" + cardColour + "_" + cardName + ".png";
        System.out.println(path);
        cardImg = new Image(path);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardColour() {
        return cardColour;
    }

    public void setCardColour(String cardColour) {
        this.cardColour = cardColour;
    }

    @Override
    public String toString(){
        String s = cardName + " " + cardColour;
        return s;
    }

}
