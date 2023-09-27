import java.util.Arrays;
import java.util.Random;

class Main{
    
    public static void main(String args[]){
        Player player = new Player();
        
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
    }
    
}