/** Game.java
*   Author: Stephen Connelly
*   
*   
*   Game class for playing crazy eights in commandline
*   To be used with Player, Card, Deck classes
*
*/


import java.util.Scanner;
import java.util.ArrayList;

class Game{

    private char currentSuit; 
    private Card faceup; 
    private Scanner input;
    private Player p1;
    private ArrayList<Card> compHand;
    private Deck cards;
    private int handCounter;
    
    //constructor. notably creates hand for player 1 and computer 
    public Game(){
        input = new Scanner(System.in);
        cards = new Deck();
        p1 = new Player(); 
        cards.shuffle();
        handCounter = 0;
        compHand = new ArrayList<Card>();
        for(handCounter = 0; handCounter<7; handCounter++){
            p1.addCard(cards.deal());
        }
        for(handCounter = 0; handCounter<7; handCounter++){
            compHand.add(cards.deal());
        }
        faceup = cards.deal();
        currentSuit = faceup.getSuit();
    }

    // Plays crazy 8. Returns a value for keepPlaying through calling playAgain
    public boolean play(){
        welcome();
        while ((p1.getHand().size() > 0 && compHand.size() > 0)){
        System.out.println(" \n Player 1, this is your hand! \n " +
        p1.handToString() + "\n");
        faceup = p1.playsTurn(cards);
            if(faceup == null){
                gameOver();
                return playAgain();
            }
        updateHand();
        faceup = computerTurn();
            if(faceup == null){
                gameOver();
                return playAgain();
            }
        updateCompHand(); 
        }

        gameOver();
        return playAgain();
    }

    //returns a card for the computer
    public Card computerTurn(){
        int i = 7;
        for(handCounter = 0; handCounter<i; handCounter++){
            if(compHand.get(handCounter).getSuit2() == faceup.getSuit2() ||
            compHand.get(handCounter).getRank2() == faceup.getRank2() ||
            currentSuit == faceup.getRank()){
                return compHand.get(handCounter);
            }else{
                Card card = cards.deal();
                compHand.add(card);
                if (card == null){
                    return null;
                }
                i++;
            }
        }
        return null;
    }

    //takes care of the end game message and decides who wins
    public void gameOver(){
        System.out.println("\n The game is over!" + " \n " + 
        "------------------------------------");
        if (p1.getHand().size() > compHand.size()){
            System.out.println("Player 1 Loses! \n ");
        }else{
            System.out.println("Player 1 Wins! \n");
        }
        System.out.println("Computer Hand: " + compHand + " \n ");
        System.out.println("Player 1 Hand: " + p1.getHand() + " \n ");
    }

    //creates a welcome statement for the game
    public void welcome(){
        System.out.println(" \n Welcome to Crazy Eights! You'll start \n " + 
        "with 7 cards.Your job is to match a card in your hand \n " + 
        "with the up card. You can match it by suit or rank. \n"  +
        " If you play an 8, you can switch the active suit. \n"  +
        " If you run out of cards, you win! \n"  +
        " If you make it through the whole deck then whoever has \n"  +
        " the fewest cards left wins! Good luck! ");
        System.out.println("*-----------------------------------------*");
        faceup = cards.deal();
        System.out.println("This is first the face up card: \n " + 
        faceup + "\n");
    }

    //takes care of asking player 1 if they want to play again
    public boolean playAgain(){
        boolean playAgain = true;
        System.out.println("Would you like to play again? " + 
        " 1 = YES. 2 = NO.");
        int playAgainInt = input.nextInt();
            if(playAgainInt == 1){
                playAgain = true;
            }else{
                playAgain = false;
            }
        return playAgain;
    }
    //deals with possiblity of 8
    public void updateCompHand(){
        if(faceup.getRank2() == "8"){
                currentSuit = faceup.getSuit();
                System.out.println("The new suit is " + currentSuit);
            }else{
                System.out.println("This is now the face up card: " + faceup);
            }    
    } 
    //deals with possibility of 8
    public void updateHand(){
        if(faceup.getRank2() == "8"){
                System.out.println("What suit would you like? Ex. 'h'");
                char suitType = input.next().charAt(0);
                currentSuit = suitType;
                System.out.println("\n The new suit is " + currentSuit);
            }else{
                System.out.println("\n You played: \n " + 
                faceup + "\n");
            }
    }
}