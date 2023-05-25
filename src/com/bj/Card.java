package src.com.bj;

//  Tạo là bài có Rank và Suit chứa các method lấy giá trị và in ra lá bài
 // implement Comparable để dùng method compare to sắp xếp lá bài theo thứ tự
public class Card implements Comparable<Card> {

     private Suit suit;
     private Rank rank;

    
    
      //tao rank va suit
    
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    
      //Tạo copy construtors
     
     
    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    
     
     //getter and setter
     
     
    public int getValue(){
        return rank.rankValue;
    }

   
    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    
    
     
     //in ra lá bài
    public String toString(){
        return ("["+rank+" of "+ suit + "] ("+this.getValue()+")");

    }

    
     
 
     //sắp xếp theo dộ lớn của lá bài 
    @Override
    public int compareTo(Card c) {
        
        if(this.getValue() > c.getValue()){
            return 1;
        }
        else if(this.getValue() < c.getValue()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
