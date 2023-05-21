public class Player {
    private int wins, losses, pushes;
    private Deck deck, discarded;
    private Player player;
    private Dealer dealer;


    public Game(){
        wins=0; losses=0; pushes=0;

        deck = new Deck(true);

        discarded = new Deck();

        dealer = new Dealer();

        player = new Player();

        deck.shuffle();
        startRound();

    }
    private void startRound(){
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();
        player.printHand();
    
        if(dealer.hasBlackjack()){
            
            dealer.printHand();

            if(player.hasBlackjack()){
                
                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            }
            else{
                System.out.println("Dealer has BlackJack. You lose.");
                dealer.printHand();
                losses++;
                startRound();
            }
        }

        
        if(player.hasBlackjack()){
            System.out.println("You have Blackjack! You win!");
            wins++;
            startRound();
        }
        player.makeDecision(deck, discarded);


    }   

}
