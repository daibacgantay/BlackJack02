public class card implements Comparable<card> {
    private suit suit;
    private rank rank;


    public card(suit suit, rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public card(card card){
        this.suit = card.getsuit();
        this.rank = card.getrank();
    }

    public int getValue(){
        return rank.rankValue;
    }
    public suit getsuit(){
        return suit;
    }
    public rank getrank(){
        return rank;
    }

    public String toString(){
        return("["+rank+" of "+ suit + "] ("+this.getValue()+")");
    }


    public int compareTo(card c){
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
    
    

