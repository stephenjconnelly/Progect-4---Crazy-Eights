/** Player.java
*   Author: your name here
*   
*   Player class as part of Crazy Eights
*   To be used with Game, Card, Deck classes
*
*/

import java.util.ArrayList;
import java.util.Scanner;

class Player{
    
    private ArrayList<Card> hand; // the player's hand
    private Scanner input;
    private Card c;

    public Player(){
        hand = new ArrayList<Card>();
        input = new Scanner(System.in);
    }

    // Adds a card to the player's hand
    public void addCard(Card c){
        this.c = c;
        hand.add(c);
    }
   
    // covers player 1's choice to draw or place & sees if deck is empty
    public Card playsTurn(Deck deck){
        Card faceup2=null;
        System.out.println("Would you like to draw or place a card? " + 
        " 1 = draw. 2 = place");
        int choice = input.nextInt();
        if (choice == 1){
            Card card = deck.deal();
            addCard(card);
                if (card == null){
                    return null;
                }
            System.out.println("\n This is your new hand: \n" 
            + handToString());
            return playsTurn(deck);
        }else{
            System.out.println("What card would you like to place? " + 
            " Input the position number of the card");
            int answer = input.nextInt();
            faceup2 = hand.get(answer);
            hand.remove(hand.get(answer));
            return faceup2;
        }
    }

    
    // Accessor for the players hand
    public ArrayList<Card> getHand(){
        return hand;
    }

    // Returns a printable string representing the player's hand
    public String handToString(){
        String showHand = ""; 

        for (int count2 = 0; count2<hand.size(); count2++){
            showHand = showHand + count2 + "\t" + hand.get(count2) + " \n ";
        }
        return showHand;
    }
} 
