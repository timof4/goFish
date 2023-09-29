import java.util.Arrays;
import java.util.Random;

class Main{

    static int DealHand(Player player, int[] deck, int positionInDeck) {
        //Deal deck to player1
        for (int i = 0; i < 7; i++) {
            player.AddToHand(deck[positionInDeck++] % 13, 1);
        }
        
        System.out.println();
        player.PrintHand();
        return positionInDeck;
    }
    

    
    public static void main(String args[]){
        
        Player player1 = new Player();
        Player player2 = new Player();
        int positionInDeck = 0;
        
        //Initialize deck
        int [] deck = new int[52];
        for (int i = 0; i<deck.length; i++) {
            deck[i]=i;
        }
        
        
        //Shuffle deck
        Random rand = new Random();
        
        for (int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(deck.length);
            int temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
        
        //Deal hands
        positionInDeck = DealHand(player1, deck, positionInDeck); 
        positionInDeck = DealHand(player2, deck, positionInDeck);
        
        positionInDeck = DealHand(player1, deck, positionInDeck);
        
//        System.out.println(Arrays.toString(deck)); //for debugging
//        
//        for (int i = 0; i < deck.length; i++) { //for debugging, prints the deck converted into numbers 0 - 12
//            System.out.print(deck[i] % 13 + ", ");
//        }
//      
        Player guessingPlayer = player1;
        Player answeringPlayer = player2;
        
        while (positionInDeck < deck.length || player1.hand.length > 0 || player1.hand.length > 0) {
            while stillGuessing {
            
            stilGuessing = guessingPlayer.requestCard(answeringPlayer, positionInDeck);
            }
        }
        
    }
}

