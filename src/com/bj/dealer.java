
public class Dealer extends man {
    public Dealer(){
        super.setName("Dealer");
    }
    public void printFirstHand(){
        System.out.println("The dealer's hands look like this:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down");

    }
}
