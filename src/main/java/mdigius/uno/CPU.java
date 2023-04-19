package mdigius.uno;

public class CPU implements UnoPlayer{
    private UnoHand unoHand;
    private String name;

    @Override
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHandSize() {
        return unoHand.getHandSize();
    }

    @Override
    public void placeCard() {

    }

    @Override
    public void drawCard() {

    }

    @Override
    public void setUnoHad(UnoHand unoHand) {

    }

    @Override
    public void playTurn() {

    }

    @Override
    public UnoHand getUnoHand() {
        return null;
    }
}
