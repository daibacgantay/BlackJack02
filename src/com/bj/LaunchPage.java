package src.com.bj;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class LaunchPage {
	JFrame frame = new JFrame();
	
	ImageIcon logo = new ImageIcon(".//res//logo.jpg");
	LaunchPage(){
		//Create game window
        JFrame frame = new JFrame("BlackJack mien TAY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        

        //Set its size
        Game blackjack = new Game();
        frame.setSize(800, 600);

        //Make a new blackjack Game object/JPanel
        

        //Add it to the frame and make it visible
        frame.add(blackjack);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(logo.getImage());
        
	}
}
