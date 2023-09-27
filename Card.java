class Card{
    
    int num;
    int suit;
    int count=1; // what does count do?
    
    //Constructor
    Card(int bigNum){
        this.num=bigNum%13;
        this.suit=bigNum/4;
    }
    
}