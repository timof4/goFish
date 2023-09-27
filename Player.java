class Player{
    
    Card[] hand; 
    int points=0;
    int handLength=0;
    Player() {
        this.hand = new Card[7]; //i think this initializes them all to 0, which is technically an ace, we might want to start with them as -1
        // this also unfortunately limits the number of cards you could have in the hand
        // you might have been in the midst of a player class with a lot more, but here are some suggestions
        /*
         * making a player hand that has 13 card-number-group objects that can fill up with cards 
         */
    }
    
    void AddToHand(Card[] newCards){
        //takes an array of  values to add to the hand, redefines hand with these values
        Card[] tempArray = new Card[hand.length+newCards.length];
        for(int i=0;i<hand.length;i++){
            tempArray[i]=hand[i];
        }
        
        for(int i=0;i<newCards.length;i++){
            tempArray[hand.length+i]=newCards[i];
        }
        
        tempArray=CondenseArray(tempArray);
        
        hand=tempArray;   
    }
    
    void RemoveFromHand(Card[] removeCards){
        //takes an array of  values to remove from the hand, redefines hand with these values
        Card[] tempArray = new Card[hand.length-removeCards.length];
        int lastAdded=0;
        for(int i=0;i<hand.length;i++){
            boolean inRemoved=false;
            
            for(int j=0;j<removeCards.length;j++){
                if(hand[i].num==removeCards[j].num){
                    inRemoved=true;
                }
            }
            if(!inRemoved){
                tempArray[lastAdded]=hand[i];
                lastAdded++;
            }
            
        }
        
        hand=tempArray;
    }
    
    Card[] CondenseArray(Card[] oldArray){
        //Redefines card objects in an array to have only one of each number, and increment counts respectively
        //Returns new array of cards
        Card[] hasRepeat = IdentifyRepeats(oldArray);
        int numRepeated = NumRepeats(oldArray);
        
        Card[] newArray = new Card[oldArray.length-numRepeated];
        int lastAdded=0;
        for(int i=0;i<oldArray.length;i++){
            boolean addCardToNew = true;
            int repeatIndex=-1;
            for(int j=0;j<hasRepeat.length;j++){
                if(oldArray[i].num==hasRepeat[j].num){
                    repeatIndex=j;
                }
            }
            if(repeatIndex!=-1){
                //Checks if card object is the exact same as the card given by remove object (the first occurence of the repeated value)
                if(hasRepeat[repeatIndex]!=oldArray[i]){
                    addCardToNew = false;
                    for(int c=0;c<oldArray.length;c++){
                        oldArray[c].count+=1;
                            break;
                    }
                }
            }
            if(addCardToNew){
                newArray[lastAdded]=oldArray[i];
                lastAdded++;
            }
        }
        return newArray;
    }
    
    Card[] IdentifyRepeats(Card[] oldArray){
        //Returns an array of cards with repeated values
        Card[] alreadyRead = new Card[0];
        Card[] repeated = new Card[0];
        for(int i=0;i<oldArray.length;i++){
            boolean repeat=false;
            for(int j=0;j<alreadyRead.length;j++){
                if(oldArray[i].num==alreadyRead[j].num){
                    Card[] tempArray = new Card[repeated.length+1];
                    for(int c=0;c<repeated.length;c++){
                    tempArray[c]=repeated[c];                    
                }
                    tempArray[repeated.length]=alreadyRead[j];
                    repeated=tempArray;
                    repeat=true;
                }}
            if(!repeat){
                Card[] tempArray = new Card[alreadyRead.length+1];
                for(int c=0;c<alreadyRead.length;c++){
                    tempArray[c]=alreadyRead[c];                    
                }
                tempArray[alreadyRead.length]=oldArray[i];
                alreadyRead=tempArray;
            }}
        return repeated;
        
    }
    
    int NumRepeats(Card[] oldArray) {
        Card[] repeated = IdentifyRepeats(oldArray);
        int numRepeats=0;
        for(int i=0;i<repeated.length;i++){
            for(int j=0;j<oldArray.length;j++){
                if(repeated[i].num==oldArray[j].num){
                    numRepeats++;
                }
            }
        }
        numRepeats=numRepeats-repeated.length;
        return numRepeats;
    }
    
}
