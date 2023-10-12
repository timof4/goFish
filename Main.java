import java.util.Arrays;
import java.util.Random;

class Main{

    static int DealHand(Player player, int[] deck, int positionInDeck) {
        //Deal deck to player1
        for (int i = 0; i < 7; i++) {
            player.AddToHand(deck[positionInDeck++] % 13, 1);
        }
        
        //System.out.println();
        //player.PrintHand();
        return positionInDeck;
    }
    
    public static boolean game(){
        
        boolean gameOver = false;
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
        
        
//        System.out.println(Arrays.toString(deck)); //for debugging
//        
//        for (int i = 0; i < deck.length; i++) { //for debugging, prints the deck converted into numbers 0 - 12
//            System.out.print(deck[i] % 13 + ", ");
//        }
//      
        Player guessingPlayer = player1;
        Player answeringPlayer = player2;
        int count = 0;
        while (!gameOver) {
            if(count++>1000) {
                player1.PrintHand();
                player2.PrintHand();
                System.out.println(positionInDeck);
            }
            //while stillGuessing (Instead of using this while loop I'm doing it recursively in requestCard
            int guess = guessingPlayer.DecideOnGuess();
            //need to open position in deck
            positionInDeck = guessingPlayer.RequestCard(answeringPlayer, guessingPlayer.hand[guess], deck, positionInDeck,0);
            if(guessingPlayer.handLength == 0){
                if(positionInDeck == 52){
                    gameOver = true;
                    //System.out.println(answeringPlayer.handLength/4);
                    //System.out.println(answeringPlayer.points);
                    answeringPlayer.points+=answeringPlayer.handLength/4;
                    if(answeringPlayer.handLength % 4 != 0) {
                        answeringPlayer.points+=1;
                    }
                    answeringPlayer.handLength=0;
                } else{
                    guessingPlayer.AddToHand(deck[positionInDeck],1);
                    positionInDeck+=1;
                }
            }
            if(answeringPlayer.handLength == 0){
                if(positionInDeck == 52){
                    gameOver = true;
                    //System.out.println(guessingPlayer.handLength/4);
                    //System.out.println(guessingPlayer.points);
                    guessingPlayer.points+=guessingPlayer.handLength/4;
                    if(guessingPlayer.handLength % 4 != 0) {
                        guessingPlayer.points+=1;
                    }
                    guessingPlayer.handLength=0;
                } else{
                    answeringPlayer.AddToHand(deck[positionInDeck],1);
                    positionInDeck+=1;
                }
            }
            Player temp = guessingPlayer;
            guessingPlayer = answeringPlayer;
            answeringPlayer = temp;
        }
        //System.out.println("Player 1 scored: " + player1.points);
        //System.out.println("Player 2 scored: " + player2.points);
        if(player1.points+player2.points==13) {return true;
        } else {return false;}
        
    }
    
    public static void main(String args[]){
        boolean succesful=false;
        for(int i=0; i<100; i++) {
            System.out.println(i);
            
            succesful=game();
            if(!succesful) {
                break;
            }
        }
        if(succesful) {System.out.println("Success!");}
        else {System.out.println("Failure :(");}
    }
}

