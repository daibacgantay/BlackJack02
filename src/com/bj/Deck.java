package src.com.bj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//Bộ bài sẽ chứa những lá bài và có operation xào bài
public class Deck {

    //An arraylist to hold the deck of Cards
    private ArrayList<Card> deck;


   
    public Deck(){
        deck = new ArrayList<Card>();
    }

    // Copy Constructor
     
     
    public Deck(Deck c){
        Collections.copy(this.deck, c.getCards());
    }

    /**
     * 
     * @param makeDeck makes a standard deck of cards if true
     */
    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            //Go through all the suits
            for(Suit suit : Suit.values()){
                //Go through all the ranks
                for(Rank rank : Rank.values()){
                    //add a new card containing each iterations suit and rank
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

   // method bỏ card vào
    public void addCard(Card card){
        deck.add(card);
    }

    /**
     *
     * @param cards an arraylist of cards to be added to this deck
     */
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

   // trả lại tất cả Value của lá bài trong bộ bài
    public String toString(){
        
        String output = "";

        for(Card card: deck){
            output += card;
            output += "\n";
        }
        return output;
    }

    //xào bài
    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }

   //trả lại lá bài lấy ra trong bộ bài
    public Card takeCard(){

            //lấy lá bài copy đầu tiên
            Card cardToTake = new Card(deck.get(0));
            //bỏ ra khỏi bộ bài
            deck.remove(0);
            //trả lại lá bài đó
            return cardToTake;

    }

    /**
     *
     * @return true if the deck still has cards left
     */
    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     * @return The number of cards left in the deck
     */
    public int cardsLeft(){
        return deck.size();
    }

    //return cái arrylist
    public ArrayList<Card> getCards() {
        return deck;
    }

    //Xoa bai trong Deck
    public void emptyDeck(){
        deck.clear();
    }


    
      //Take all the cards from a discarded deck and place them in this deck, shuffled.
      //Clear the old deck
    // discard - the deck we're getting the cards from
     
    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }


}


