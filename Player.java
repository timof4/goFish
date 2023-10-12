class Player{
    
    Card[] hand = new Card[13];
    int points=0;
    int handLength=0; // sum of the quantities of all 13 card objects
    String strategy;
    int lastGuess=0;
    Player() {
        for (int i = 0; i < 13; i++) { //fills deck with card objects numbered 0 to 12
            hand[i] = new Card(i);
        }
    }
    
    int AddToHand(int newCardNumber, int quantity){ //seeing if it would work to make this an int that returns how many care in the card object bc this could be useful for automatically checking whether we've reached a set of 4
        //takes # of card/cards being added plus the quantity and iterates through the cards until it finds the corresponding # card and adds the quantity
        //then updates handLength
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].num == newCardNumber) {
                
                hand[i].cardQuantity += quantity;
                //do we want to limit the quantity of cards a player can have? I think not
                //assert hand[i].cardQuantity < 5; //good idea. if this happens there is something wrong with our code
                handLength += quantity;
                
                //System.out.println("adding card of number " + newCardNumber + " and adding " + quantity + " of them");
                
                //just checks that hand length is correct
                int cardSum = 0;
                for (int j = 0; j < hand.length; j++) {
                    cardSum += hand[j].cardQuantity;
                }
                //assert handLength == cardSum;
                return handLength;
            }
            
        }
        return -1; 
        
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
        removedCardNumber = removedCardNumber %13;
        handLength -= hand[removedCardNumber].cardQuantity;
        int amountRemoved = hand[removedCardNumber].cardQuantity;
        hand[removedCardNumber].cardQuantity = 0;
        int newAmount = hand[removedCardNumber].cardQuantity;
        //just checks that hand length is correct
        int cardSum = 0;
        for (int j = 0; j < hand.length; j++) {
            cardSum += hand[j].cardQuantity;
        }
        assert handLength == cardSum;
        
        
    }
    
    int DecideOnGuess() {
        //implement stragegy and return # of choice
        //Player will be initialized with a strategy, that doesnt happen here
        if(hand[lastGuess % 13].cardQuantity > 0) {
            return lastGuess++ % 13;
        } else {
            lastGuess++;
            for(int guess=0; guess<13; guess++) {
                if(hand[guess].cardQuantity > 0) {
                    return guess;
                }
            }
        }
        return 0;
    }
    
    int RequestCard(Player answeringPlayer, Card guess, int[] deck, int positionInDeck, int counter) {
        // chooses a card based on some algorithm we make up later 
        //calls checkforcard with other player
        if(counter>100) {
            PrintHand();
            answeringPlayer.PrintHand();
        }
        boolean stillGuessing = true;
        int totQuantOfAddedCard = 0;
        int originalLength = handLength;
        //System.out.println("Guessing Players Hand");
        //PrintHand();
        //System.out.println("Answering Players Hand");
        //answeringPlayer.PrintHand();
        //System.out.println("Checking for " + guess.num);
        if (positionInDeck < 52) {
            if (answeringPlayer.CheckForCard(guess) == -1) {
                //System.out.println("Not found. Drawing");
                int addedCard = deck[positionInDeck++];
                //System.out.println("Drew " + addedCard%13);
                totQuantOfAddedCard = originalLength - AddToHand(addedCard % 13,1);
                if(hand[addedCard % 13].cardQuantity == 4){
                    //System.out.println("Has 4 of "+ addedCard%13);
                    //System.out.println("Previous points: " + points);
                    RemoveFromHand(addedCard);
                    //System.out.println("Scored for " + guess.num);
                    points=points+1;
                    //System.out.println("New points: " + points);
                }
            } else {
                AddToHand(guess.num, answeringPlayer.CheckForCard(guess));
                //System.out.println("Found it!");
                answeringPlayer.RemoveFromHand(guess.num);
                if(hand[guess.num].cardQuantity == 4){
                    //System.out.println("Had 4 of " + guess.num);
                    //System.out.println("Previous points: " + points);
                    RemoveFromHand(guess.num);
                    //System.out.println("Scored for " + guess.num);
                    points=points+1;
                    //System.out.println("New points: " + points);
                }
                positionInDeck = RequestCard(answeringPlayer, hand[DecideOnGuess()], deck, positionInDeck, counter++);
            } 
        } else if (answeringPlayer.CheckForCard(guess) != -1) {
            //System.out.println("Found it! No cards left in deck");
            AddToHand(guess.num, answeringPlayer.CheckForCard(guess)); 
            answeringPlayer.RemoveFromHand(guess.num);
                if(hand[guess.num].cardQuantity == 4){
                    //System.out.println("Had 4 of " + guess.num);
                    //System.out.println("Previous points: " + points);
                    RemoveFromHand(guess.num);
                    //System.out.println("Scored for " + guess.num);
                    points=points+1;
                    //System.out.println("New points: " + points);
                }
                positionInDeck = RequestCard(answeringPlayer, hand[DecideOnGuess()], deck, positionInDeck, counter++);
                
        }
        //System.out.println("at");
        //System.out.println(positionInDeck);
        //PrintHand();
        //answeringPlayer.PrintHand();
        return positionInDeck;
    }
    
    int CheckForCard(Card card) {
        for(int handCard = 0; handCard < hand.length; handCard++){
            if(card.num==hand[handCard].num){
                if(hand[handCard].cardQuantity > 0){
                    int amount = hand[handCard].cardQuantity;
                    return amount; 
                }
            }
        }
        return -1;
    }
}