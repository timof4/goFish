class Card{
    
    int cardNumber;
    int cardQuantity = 0;
    
    int num;
    int suit;
    
    //Constructor
    Card(int bigNum){
        this.cardNumber=bigNum;
        this.num=bigNum%13;
        this.suit=bigNum/4;

    
    }
}