import java.util.Arrays;
import java.util.Random;

class Main{
    
    public static void main(String args[]){
        Player player1 = new Player();
        Player player2 = new Player();
        
        //Initialize deck
        int[] deckNums = new int[52];
        for (int i = 0; i<deckNums.length; i++) {
            
            deckNums[i]=i;
            
        }
        
        Card[] deck = new Card[52];
        for (int i = 0; i < deck.length; i++) {
            
            deck[i]=new Card(deckNums[i]);
            
        }
        
        //Shuffle deck
        Random rand = new Random();
        
        for (int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(deck.length);
            Card temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
       
        
        //tells us how far we are along in the deck array
        int positionInDeck = 0;
        
        //Deal deck to players
        for (int i = 0; i<7; i++) {
            player1.hand[i] = deck[positionInDeck++].num;
        }
        System.out.println("player1's starting hand is " + Arrays.toString(player1.hand));
        
        for (int i = 0; i<7; i++) {
            player2.hand[i] = deck[positionInDeck++].num;
        }
        System.out.println("player2's starting hand is " + Arrays.toString(player2.hand));
        
        //Attempt to set up the game play
        while (positionInDeck < 52 || 
    }
    
}