/** Card.java
*   Author: your name here
*   
*   
*   Models a typical playing card
*
*/

class Card{
    
    private char suit;
    private int rank;

    // Initializes a card instance
    public Card(char suit, int rank){
        this.suit=suit;
        this.rank=rank;
    }

    // Accessor for suit
    public char getSuit(){
        return suit;
    }
    
    // Accessor for rank
    public int getRank(){
        return rank;
    }

    // Returns a human readable form of the card (eg. King of Diamonds)

    public String getSuit2(){
        switch (suit){
        case 'c':   return "Clubs";
        case 'h':   return "Hearts";
        case 'd':   return "Diamonds";
        case 's':   return "Spades";
        }
        return null;
    }

    public String getRank2(){
        switch (rank){
            case 0:   return "Ace";
            case 1:   return "2";
            case 2:   return "3";
            case 3:   return "4";
            case 4:   return "5";
            case 5:   return "6";
            case 6:   return "7";
            case 7:   return "8";
            case 8:   return "9";
            case 9:   return "10";
            case 10:  return "Jack";
            case 11:   return "Queen";
            case 12:   return "King";
        }
        return null;
    }
    
    public String toString(){

        return getRank2() + " of " + getSuit2();
        // your code here
        //switch statement 
        //array of suits, string versions of suits
    }
}