class Card{
    
    int cardNumber;
    int cardQuantity = 0;
    
    int num;
    int suit;
    int count=1; // how many of the same type of card we have in a hand
    
    //Constructor
    Card(int bigNum){
        this.cardNumber=bigNum;
        this.num=bigNum%13;
        this.suit=bigNum/4;

    
    }
}