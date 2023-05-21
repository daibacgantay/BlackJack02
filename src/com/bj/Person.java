import java.swing;

import javax.swing.JLabel;

import java.awt;

public abstract class Person {
    private Hand hand;
    private String name;
    public Person(){
        this.hand = new Hand();
        this.name = "";
    }
    public Hand getHand(){
        return this.hand;

    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public void getName(){
        return this.name;

    }
    public void setName(){
        this.name=name;
    }
    public void printHand(JLabel cardPics){
        System.out.println(this.name + " 's looks like this:");
        System.out.println(this.hand + "Valued at:" + this.hand.calculatedValue());
        for (int i=0, i<11, i++){
            cardPics[i].setvisible(false)
        }
    }
} 
