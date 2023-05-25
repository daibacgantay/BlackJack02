package src.com.bj;
//chứa những operations của Dealer
public class Dealer extends Person{

    
    public Dealer(){

        //đặt tên dealer là Dealer
        super.setName("Dealer");

    }

   //in ra hand của Dealer (có một lá úp)
    public void printFirstHand(){
        System.out.println("The dealer's hand looks like this:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down.");
    }



}

