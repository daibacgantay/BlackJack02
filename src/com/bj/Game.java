package src.com.bj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


  //Contains all Game logic
 
public class Game extends JPanel {

    // Constants
    public static final int CARD_WIDTH = 100;
    public static final int CARD_HEIGHT = 145;
    public static final String IMAGE_DIR = "img/cards/";

    // Declare instance vars needed for Game class
    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes; //money;
    public static int x =0;
    public static int y =0;

    // three buttons for "Hit" "Stand" and "Next Round" actions
    private JButton btnHit, btnStand, btnNext, btnPlay, btnExit, btnRule; //btnBet;

    // labels to show images of cards
    private JLabel[] lblDealerCards, lblPlayerCards;
    // few more labels for showing important stats
    private JLabel lblScore, lblPlayerHandVal, lblDealerHandVal, lblGameMessage, lblWallpaper;
    private Image background;
    
	SE se = new SE();
	

    
      //Constructor for Game, creates our variables and starts the Game
     
    public Game() {
    	background = new ImageIcon(IMAGE_DIR + "backgroundd.png").getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);

        // Create a new deck with 52 cards
        deck = new Deck(true);
        // Create a new empty deck
        discarded = new Deck();

        // Create the People
        dealer = new Dealer();
        player = new Player();

        // Shuffle the deck and start the first round
        deck.shuffle();
        
        //setupGUI();
        setupMenu();
        //startRound();
    }

    
   
    
   
   //setupMenu for the game
    private void setupMenu() {
    	this.setSize(800, 500);
    	btnPlay = new JButton("Play");
    	btnPlay.setBounds(330,330, 80, 30);
    	btnPlay.setFocusable(false);
    	btnPlay.setFont(new Font("Arial", Font.BOLD, 15));
    	btnPlay.setBackground(Color.WHITE);
    	btnPlay.setBorder(BorderFactory.createLoweredBevelBorder());
    	btnPlay.setForeground(Color.RED);
    	
    	
    	btnExit = new JButton("Exit");
    	btnExit.setBounds(330,470, 80, 30);
    	btnExit.setFocusable(false);
    	btnExit.setFont(new Font("Arial", Font.BOLD, 15));
    	btnExit.setBackground(Color.WHITE);
    	btnExit.setBorder(BorderFactory.createLoweredBevelBorder());
    	btnExit.setForeground(Color.RED);
    	
    	btnRule = new JButton("Rule");
    	btnRule.setBounds(330,400, 80, 30);
    	btnRule.setFocusable(false);
    	btnRule.setFont(new Font("Arial", Font.BOLD, 15));
    	btnRule.setBackground(Color.WHITE);
    	btnRule.setBorder(BorderFactory.createLoweredBevelBorder());
    	btnRule.setForeground(Color.RED);
    	
    	
    	lblWallpaper = new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "Wallpaper3.png").getImage()
                .getScaledInstance(585, 226, Image.SCALE_SMOOTH)));
    	//lblWallpaper = new JLabel();
    	
    	//lblWallpaper.setText("Black Jack");
    	//lblWallpaper.setForeground(Color.WHITE);
    	lblWallpaper.setBounds(85, -15, 600,400);
    	//lblWallpaper.setFont(new Font("MV Boli", Font.HANGING_BASELINE, 70));
    	//lblWallpaper.setBackground(Color.cyan);
    	
    	
   	
    	
    	this.add(btnRule);
    	this.add(btnPlay);
    	this.add(btnExit);
    	this.add(lblWallpaper);
    	this.setLayout(null);
    	this.setVisible(true);

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
            
            	btnRule.setVisible(false);
            	btnPlay.setVisible(false);
            	btnExit.setVisible(false);
            	lblWallpaper.setVisible(false);
            	playSE(".//res//click.wav");
            	
        	
               setupGUI();
               startRound();
               

            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        btnRule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playSE(".//res//click.wav");
            	
            	
            	new RuleText();
            	
            }
        });
    }
    

    

	private void setupGUI() {
        // Size of JPanel
        this.setSize(800, 500);
        //background = new ImageIcon(".//res//logo.jpg");
        //this.add(background);

        // Make Buttons for "Hit" "Stand" and "Next Round" actions.
        // setBounds is used to define their locations and sizes
        btnHit = new JButton("Hit");
        btnHit.setBounds(10, 10, 50, 20);
        btnHit.setFocusable(false);
    	btnHit.setFont(new Font("Arial", Font.BOLD, 15));
    	btnHit.setBackground(Color.LIGHT_GRAY);
    	btnHit.setBorder(BorderFactory.createLoweredBevelBorder());
    	btnHit.setForeground(Color.RED);
        btnStand = new JButton("Stand");
        btnStand.setFocusable(false);
    	btnStand.setFont(new Font("Arial", Font.BOLD, 15));
    	btnStand.setBackground(Color.LIGHT_GRAY);
    	btnStand.setBorder(BorderFactory.createLoweredBevelBorder());
    	btnStand.setForeground(Color.RED);
        btnStand.setBounds(70, 10, 100, 20);
        btnNext = new JButton("Next Round");
        btnNext.setBounds(180, 10, 140, 20);
        btnNext.setVisible(false);
        btnNext.setFocusable(false);
    	btnNext.setFont(new Font("Arial", Font.BOLD, 15));
    	btnNext.setBackground(Color.LIGHT_GRAY);
    	btnNext.setBorder(BorderFactory.createLoweredBevelBorder());
    	btnNext.setForeground(Color.RED);
//    	btnBet = new JButton("Bet");
//      btnBet.setBounds(180, 10, 60, 20);
//      btnBet.setVisible(false);
//      btnBet.setFocusable(false);
//    	btnBet.setFont(new Font("Arial", Font.BOLD, 15));
//    	btnBet.setBackground(Color.YELLOW);
//    	btnBet.setBorder(BorderFactory.createLoweredBevelBorder());
//    	btnBet.setForeground(Color.RED);
        
        this.setLayout(null);
        this.setVisible(true);
       

        // Add the buttons to the JPanel
        this.add(btnHit);
        this.add(btnStand);
        this.add(btnNext);
        //this.add(btnBet);
       

        // Arrays to hold the dealer and player card images
        lblDealerCards = new JLabel[11];
        lblPlayerCards = new JLabel[11];

        // The position of the first displayed card, which will be offset for each subsequent card
        int initialCardX = 10, initialCardY = 150;

        // For all the cards we're going to show (up to 11)
        for (int i = 0; i < lblDealerCards.length; i++) {

            // set them to new cards face down
            // done with JLabels and ImageIcons
            lblDealerCards[i] = new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardDown.png").getImage()
                    .getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH)));
            lblPlayerCards[i] = new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardDown.png").getImage()
                    .getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH)));

           
            lblDealerCards[i].setBounds(initialCardX, initialCardY, CARD_WIDTH, CARD_HEIGHT);
            lblPlayerCards[i].setBounds(initialCardX, initialCardY + 250, CARD_WIDTH, CARD_HEIGHT);

            
            this.add(lblDealerCards[i]);
            this.add(lblPlayerCards[i]);

            // increment the x/y values of each card by some amount, this will make them
            // appear "stacked" so users can see each one
            initialCardX += 50;
            initialCardY -= 18;

        }

        // setup all the labels and such
        // make scoreboard
        lblScore = new JLabel("[Wins: 0]   [Losses: 0]   [Pushes: 0]   [Money: 0]");
        lblScore.setBounds(450, 10, 300, 50);
        this.add(lblScore);
        
//        lblBetScroll = new JLabel();
//        JSlider slider = new JSlider(0, 100, 10);
//        slider.setPreferredSize(new Dimension(400,200));
//        //lblBetScroll.setBounds(450,200, 300, 40);
//        lblBetScroll.add(slider);
//        this.add(lblBetScroll);
//       
        

        // message board
        lblGameMessage = new JLabel("Starting round! Hit or Stand?");
        lblGameMessage.setBounds(450, 200, 300, 40);
        lblGameMessage.setFont(new Font("Arial", 1, 20));
        this.add(lblGameMessage);

        // hand values on díplay
        lblDealerHandVal = new JLabel("Dealer's Hand Value:");
        lblPlayerHandVal = new JLabel("Player's Hand Value:");
        lblDealerHandVal.setBounds(20, 280, 300, 50);
        lblPlayerHandVal.setBounds(20, 530, 300, 50);
        this.add(lblDealerHandVal);
        this.add(lblPlayerHandVal);

        // make all labels white
        lblGameMessage.setForeground(Color.WHITE);
        lblDealerHandVal.setForeground(Color.WHITE);
        lblPlayerHandVal.setForeground(Color.WHITE);
        lblScore.setForeground(Color.WHITE);

      
        btnHit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(x<=3) {
            		x++;
            	
                // make the player hit the deck
                player.hit(deck, discarded);
                playSE(".//res//hitcard.wav");
            	}
                // update screen with their new card, and their score
                updateScreen();
                checkBusts();
                checkPlayer21();

            }
        });

    
        btnStand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // that means it's the dealers turn now
                dealersTurn();
                // see who won after dealer drew card
                checkWins();
                // update screen with player's cards
                updateScreen();
                // also reveal all the dealer's cards, so we can see what they drew
                dealer.printHand(lblDealerCards);

                
                btnHit.setVisible(false);
                btnStand.setVisible(false);
                btnNext.setVisible(true);
            }
        });

    
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	stopSE();
            	x=0;
            	y=0;
            	
                
                btnNext.setVisible(false);
                btnHit.setVisible(true);
                btnStand.setVisible(true);
                startRound();
            }
        });

    }

    
		
		
	

	
     //This is called when player hits "Hit" button to see if they busted
     
    private void checkBusts() {
        // Check if they busted
        if (player.getHand().calculatedValue() > 21) {
        	playSE(".//res//vine-boom.wav");
            // show message
            lblGameMessage.setText("You BUST - Over 21");
            // update score
            losses++;
            // make next round button only visible button
            btnHit.setVisible(false);
            btnStand.setVisible(false);
            btnNext.setVisible(true);
        }
    }

    
     //At the end of each round, this method is called to see who won
     
    private void checkWins() {

        // Show value of dealers hand
        lblDealerHandVal.setText("Dealer's hand value: " + dealer.getHand().calculatedValue());

        // Check who wins and count wins or losses
        if (dealer.getHand().calculatedValue() > 21) {
        	playSE(".//res//win.wav");
            lblGameMessage.setText("Dealer Busts! You win!");
            wins++;
        } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
        	playSE(".//res//loses.wav");
            lblGameMessage.setText("Dealer wins - Higher hand");
            losses++;
        } else if (player.getHand().calculatedValue() > dealer.getHand().calculatedValue()) {
        	playSE(".//res//win.wav");
            lblGameMessage.setText("You win - Higher hand");
            wins++;
        } else {
        	playSE(".//res//raw.wav");
            lblGameMessage.setText("Equal Value Hands - Push");
            pushes++;
        }
    }

    
      //This is called when player hits "Hit" button to see if they have 21
      //Prevents them from hitting again
     
    private void checkPlayer21(){
        if(player.getHand().calculatedValue() <=21 && x==3){
        	playSE(".//res//21.wav");
            lblGameMessage.setText("MAGIC FIVE!");
            //update score
            wins++;
            //make next round button only visible button
            btnHit.setVisible(false);
            btnStand.setVisible(false);
            btnNext.setVisible(true);
        }

        else if(player.getHand().calculatedValue() ==21 ){
            playSE(".//res//21.wav");
            lblGameMessage.setText("  You have 21!");
            wins++;
            btnHit.setVisible(false);
            btnStand.setVisible(false);
            btnNext.setVisible(true);
            
        }
        }
    
    // Dealer draws cards until they have a hand value of 17 or higher
     
    private void dealersTurn() {

        // Now it's the dealer's turn
        // Dealer will continue drawing until hand is valued at 17 or higher
        while (dealer.getHand().calculatedValue() < 17) {
            // dealer hits deck
            if(y<=3){
            dealer.hit(deck, discarded);
            updateScreen();
            y++;
            }
        }
    }

    
     // Make the screen background a green color like a card table
     
    public void paintComponent(Graphics g) {
    	//
        super.paintComponent(g);
    	g.drawImage(background,0,0,this);
        
        //g.setColor(Color.decode("#234F1E"));
        //g.fillRect(0, 0, 1000, 1000);
    }

    
     //Updates everything on the screen. Cards, Values, Scores, etc. except dealer
     cards/value
     
    private void updateScreen() {

        lblPlayerHandVal.setText("Player's Hand Value: " + player.getHand().calculatedValue());
        player.printHand(lblPlayerCards);
        // score
        lblScore.setText("[Wins: " + wins + "]   [Losses: " + losses + "]   [Pushes: " + pushes + "]   " );

    }

    
     //Start a new round, display score, give out cards, check for BlackJack, ask
     player what they want to do
     
    private void startRound() {
        /
          //wins = 0; losses = 0; pushes = 1;
         // Card testCard = new Card(Suit.CLUB,Rank.NINE);
          //Card testCard2 = new Card(Suit.CLUB, Rank.TEN);
         /
        // If this isn't the first time, display the users score and put their cards
        // back in the deck
        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting Next Round... Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        // Check to make sure the deck has at least 4 cards left
        if (deck.cardsLeft() < 4) {
            deck.reloadDeckFromDiscard(discarded);
        }

        // Give the dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        // Give the player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        // in startRound after you give the player and dealer their two cards
        updateScreen();
        lblDealerHandVal.setText("Dealer's hand value: " + dealer.getHand().getCard(0).getValue() + " + ?");
        lblGameMessage.setText("Starting round! Hit or Stand?");

        // Show the dealers hand with one card face down
        dealer.printHand(lblDealerCards);
        lblDealerCards[1].setIcon(new ImageIcon(new ImageIcon(IMAGE_DIR + "CardDown.png").getImage()
                .getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_DEFAULT)));

        // Show the player's hand
        player.printHand(lblPlayerCards);

        // Check if dealer has BlackJack to start
        if (dealer.hasBlackjack()) {
            // Show the dealer has BlackJack
            dealer.printHand(lblDealerCards);

            // Check if the player also has BlackJack
            if (player.hasBlackjack()) {
            	playSE(".//res//raw.wav");
                // End the round with a push
                lblGameMessage.setText("Both 21 - Push");
                pushes++;
                // New round buttons
                btnHit.setVisible(false);
                btnStand.setVisible(false);
                btnNext.setVisible(true);
            } else {
            	playSE(".//res//oi.wav");
                lblGameMessage.setText("Dealer has Blackjack!");
                dealer.printHand(lblDealerCards);
                losses++;
                // player lost, start a new round
                btnHit.setVisible(false);
                btnStand.setVisible(false);
                btnNext.setVisible(true);
            }
        }

        // Check if player has blackjack to start
        // If we got to this point, we already know the dealer didn't have blackjack
        if (player.hasBlackjack()) {
        	playSE(".//res//bj.wav");
            // say player has blackjack
            lblGameMessage.setText("You have Blackjack!");
            // update score
            wins++;
            // make next round button only visible button
            btnHit.setVisible(false);
            btnStand.setVisible(false);
            btnNext.setVisible(true);

        }
     // Check if dealer has Double Aces to start
        if (dealer.hasDoubleaces()) {
            // Show the dealer has Double Aces
            dealer.printHand(lblDealerCards);

            // Check if the player also has Double Aces
            if (player.hasDoubleaces()) {
            	playSE(".//res//raw.wav");
                // End the round with a push
                lblGameMessage.setText("Both DOUBLE ACES - Push");
                pushes++;
                // New round buttons
                btnHit.setVisible(false);
                btnStand.setVisible(false);
                btnNext.setVisible(true);
            } else {
            	playSE(".//res//oi.wav");
                lblGameMessage.setText("Dealer has DOUBLE ACES!");
                dealer.printHand(lblDealerCards);
                losses++;
                // player lost, start a new round
                btnHit.setVisible(false);
                btnStand.setVisible(false);
                btnNext.setVisible(true);
            }
        }

        // Check if player has Double Aces to start
        // If we got to this point, we already know the dealer didn't have blackjack
        if (player.hasDoubleaces()) {
        	playSE(".//res//bj.wav");
            // say player has blackjack
            lblGameMessage.setText("You have DOUBLE ACES!");
            // update score
            wins++;
            // make next round button only visible button
            btnHit.setVisible(false);
            btnStand.setVisible(false);
            btnNext.setVisible(true);

        }
        if( y == 3 && dealer.getHand().calculatedValue() <= 21 ){
            lblGameMessage.setText("Dealer have MAGIC FIVE!");
             losses++;
         }
    }
  //Play the sound effect  
private void playSE(String Sound) {
	
	se.setFile(Sound);
	se.play();	
}
//Stop the múic
public void stopSE() {
	
	se.stop();
}
}
