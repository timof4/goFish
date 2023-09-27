class Card{
    
    int num;
    int suit;
    int count=1;
    
    //Constructor
    Card(int bigNum){
        this.num=bigNum%13;
        this.suit=bigNum/4;
    }
    
}