package mdigius.uno;

public class Player implements UnoPlayer{
    private String name;
    private int coins = 0;
    private int wins = 0;
    private int losses = 0;
    private UnoHand unoHand;

    public Player(String name) {
        this.name = name;
    }

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

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }



    public void setUnoHand(UnoHand unoHand) {
        this.unoHand = unoHand;
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
        this.unoHand = unoHand;

    }

    @Override
    public void playTurn() {

    }

    @Override
    public UnoHand getUnoHand() {
        return unoHand;
    }
}
