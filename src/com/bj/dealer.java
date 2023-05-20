package src.com.bj;
public class dealer extends man {
    public dealer(){
        super.setName("Dealer");
    }
    public void printFirstHand(){
        System.out.println("The dealer's hands look like this:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down");

    }
}
