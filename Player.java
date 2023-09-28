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
}