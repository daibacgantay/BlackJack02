package src.com.bj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import javax.swing.*;

	public class RuleText extends JFrame{



	    public RuleText(){



	    super("Rule");



	    JPanel p = new JPanel();
	    JTextPane tp = new JTextPane();



	    // call the Function TextFromFile
	    TextFromFile(tp);



	    Font font = new Font("",Font.BOLD,18);
	    tp.setFont(font);



	    tp.setForeground(Color.WHITE);
	    tp.setBackground(Color.decode("#18320e"));



	    JScrollPane jp = new JScrollPane(tp);



	    p.setLayout(new BorderLayout());
	    p.add(jp,BorderLayout.CENTER);



	    setContentPane(p);



	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setSize(800,600);
	    setVisible(true);
	    setLocationRelativeTo(null);
	    }
	   
	    /*
	    create a function to get the text from a text file 
	    and set it into a JTextPane
	    */ 
	    public static void TextFromFile(JTextPane tp)
	     {
	        try{
	            //the file path
	            String path = "C:\\Users\\DELL\\OneDrive - VietNam National University - HCM INTERNATIONAL UNIVERSITY\\Documents\\java_guiblackjack-main\\java_guiblackjack-main\\src\\com\\kevinsguides\\Rule.txt";
	            File file = new File(path);
	            FileReader fr = new FileReader(file);
	            while(fr.read() != -1){
	              tp.read(fr,null);
	            }
	            fr.close();
	        } catch(Exception ex){
	          ex.printStackTrace();
	        }
	     }
        }