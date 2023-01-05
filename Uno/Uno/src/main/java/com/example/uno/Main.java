package com.example.uno;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Deck deck = new Deck();
        Hand hand = new Hand();
        hand.dealHand(deck);
        System.out.println(hand.getUnoHand());
        System.out.println(hand.getHandSize());
        System.out.println(deck.getUnoDeck());
        System.out.println(deck.getSize());
    }
}
