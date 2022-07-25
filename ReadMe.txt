******************
Stephen Connelly
Sjc2235 
Programming Project 4
******************

****Worked with: Bobby Baxter and Jennifer Widjaja****

Sources used: 

1. https://css-tricks.com/snippets/javascript/select-random-item-array/ 
2. https://stackoverflow.com/questions/2411270/when-should-i-use-this-in-a-class#:~:text=The%20this%20keyword%20is%20primarily,a%20method%20of%20another%20object.
3. https://stackoverflow.com/questions/13766209/efficient-swapping-of-elements-of-an-array-in-java 
4. https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
5. https://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string 
6. https://beginnersbook.com/2013/12/java-arraylist-set-method-example/ 

*************

Card.java 

For this class, I had two accessor methods for suitand rank and two switch 
statement methods to switch the char (suit) and int(rank) into strings. 
My String to String method just called upon the switch statments 
and added them together to make one big string. 

*************

Deck.java 

This class was a bit more complicated. I created an int array and a char array 
and used a double nested for loop to create my deck. Deal() was just what 
professor told us to do for this. Since you must itterate, you do top-1 
to get the right card. For canDeal() I sturggled. A Lot. I return a random 
card if deck[top] doesnt equal null. I later used this method to determine 
whether the deck had run out of card when I was dealing cards to computer or
player 1. For shuffle I took two random values, switched them, and did this 
over and over. String to string() just took a empty string and added each Card
to it to make one big deck string. 

***The way I made the deck was I had 53 objects, but only shuffle and instatiate  
52 of them. That way, null always stays at the back. I use this then to keep 
track of when the deck is empty!

*************

Player.java 

For addCard I used this.c=c and added c to the array list hand. 
I then initiated a variable 'faceup2' which is what i return later 
in the method to the game class. I asked the player how they would like to 
play and adjusted the method accordingly. if (card == null) checks to see 
if the deck had run out of cards. I then return the new hand after they add 
a card, or ask them for what card they would like to place and get rid of. 
handToString just makes the hand look pretty in the terminal.

*************

Game.java

In the constructor, I used two for loops to make hand and compHand. I also 
set faceup to a random card and currentsuit to the suit of that random card. 
I used a supporting welcome() method to introduce the game. In my while loop, 
I have two conditions that make sure that when a player's hand runs out, the 
game ends. I set faceup equal to the value of the faceup from PlayerTurn first
and then make sure that that faceup is not null, meaning the deck is done. If 
thats the case, I call the gameOver() method that announces a winner and the 
playAgain() method that returns a playAgain boolean value. I do the same for 
comphand. For computer turn i iterate through compHand to see if there is a 
card avalable that matches either the suit or rank of the current face up card. 
If there isnt, I add a card, and check that card, and so on. I have an 
updateHand and updateCompHand method to deal with the possiblity of either 
player playing an 8. 

************

