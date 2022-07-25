/** Deck.java
*   Author: your name here
*   
*   Models a typical deck of playing cards
*   To be used with Card class
*
*/

class Deck{

    private Card[] deck = new Card[53]; // contains the cards to play with
    private int top; // controls the "top" of the deck to deal from, 
    public static final char[] suit = {'c', 'h' , 'd', 's'};
    public static final int[] rank = {0,1,2,3,4,5,6,7,8,9,10,11,12};
    
    // constructs a default Deck
    public Deck(){
        //make ur deck, write 52 cards using nester for loops, rank and suit 
        int top=0;
        int count=0;
        for (int suitCount =0; suitCount<4;suitCount++){
            for(int rankCount = 0; rankCount<13; rankCount++){
                deck[count] = new Card(suit[suitCount],rank[rankCount]);
                count++;
            }
        }
    }

    // Deals the top card off the deck
    public Card deal(){
        top++;
        return deck[top-1];
    }

    // returns null if 
    public Card canDeal(){
        if(deck[top] == null){
            return null;
        }else{
            return deck[top];
        }
    }

    // Shuffles the deck
    public void shuffle(){
        for(int count =0; count <1000; count++){

            int a = (int)(Math.random()*deck.length-1);
            int b = (int)(Math.random()*deck.length-1);

            Card temp = deck[a];

            deck[a] = deck[b];
            deck[b]=temp;
        }
    }

    // Returns a string representation of the whole deck
    public String toString(){ 
        String showDisplay = ""; 

        for (int count2 = 0; count2<deck.length; count2++){
            showDisplay = showDisplay + deck[count2] + " \n ";
        }
        return showDisplay;    
    }
}