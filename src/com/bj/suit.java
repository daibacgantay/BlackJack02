public enum suit {
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades"),


    String suitName;
    suit(String suitName){
        this.suitName = suitName;
    }
    public String toString(){
        return suitName;
    }
}
