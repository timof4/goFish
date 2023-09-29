class Player{
    
    Card[] hand = new Card[13];
    int points=0;
    int handLength=0; // sum of the quantities of all 13 card objects
    
    Player() {
        for (int i = 0; i < 13; i++) { //fills deck with card objects numbered 0 to 12
            hand[i] = new Card(i);
        }
    }
    
    void AddToHand(int newCardNumber, int quantity){
        //takes # of card/cards being added plus the quantity and iterates through the cards until it finds the corresponding # card and adds the quantity
        //then updates handLength
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].cardNumber == newCardNumber) {
                
                hand[i].cardQuantity += quantity;
                //do we want to limit the quantity of cards a player can have? I think not
                //assert hand[i].cardQuantity < 5; //good idea. if this happens there is something wrong with our code
                handLength += quantity;
                
                System.out.println("adding card of number " + newCardNumber + " and adding " + quantity + " of them");
                
                //just checks that hand length is correct
                int cardSum = 0;
                for (int j = 0; j < hand.length; j++) {
                    cardSum += hand[j].cardQuantity;
                }
                assert handLength == cardSum;
                break;
            }
        }
        
        
    }
    
    
    //Prints the current hand in a nicer way
    void PrintHand(){
        String outString = new String("");
        boolean firstTime = true;
        for (int i=0; i < hand.length; i++) {
            if(hand[i].cardQuantity > 0) {               
                int countQuantity = 0;
                while (countQuantity++ < hand[i].cardQuantity) {
                    if(!firstTime){
                        outString = outString + ", ";
                    } else {
                        firstTime = false;
                    }
                    outString = outString + hand[i].cardNumber;
                }
            }
        }
        System.out.println(outString);
    }
    
    void RemoveFromHand(int removedCardNumber){
        // sets the quantity of the card being removed to 0
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].cardNumber == removedCardNumber) {
                handLength -= hand[i].cardQuantity;
                hand[i].cardQuantity = 0;
                
                //just checks that hand length is correct
                int cardSum = 0;
                for (int j = 0; j < hand.length; j++) {
                    cardSum += hand[j].cardQuantity;
                }
                assert handLength == cardSum;
                
                break;
            }
        }
    }
    
    int DecideOnGuess(strategy) {
        implement stragegy and return # of choice
    }
    
    boolean RequestCard(Player answeringPlayer, int guess) {
    // chooses a card based on some algorithm we make up later 
        //calls checkforcard with other player
        if (checkForCard = -1) {
            thisplayer.AddCard
        } else {
            thisplayer.AddCard(guess, otherplayer[checkForCard]) 
            otherplayer.removecard(checkforcard)
            }
        for all the cards
            check if there are four cards in it //maybe a shorter way to do this, just check ones added?
               then player.points ++
               remove those cards from their hand
        if player's hand equal to zero
            
        return if it was successful;
    }
    
    int CheckForCard(card) {
        for card object in hand
            if card.quantity > 0
                 Remove
            return intex of card 
    }
}