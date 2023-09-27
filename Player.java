class Player{
    
    int[] hand; 
    int points=0;
    int handLength=0;
    Player() {
        this.hand = new int[7]; //i think this initializes them all to 0, which is technically an ace, we might want to start with them as -1
        // this also unfortunately limits the number of cards you could have in the hand
        // you might have been in the midst of a player class with a lot more, but here are some suggestions
        /*
         * making a player hand that has 13 card-number-group objects that can fill up with cards 
         */
    }
    
}