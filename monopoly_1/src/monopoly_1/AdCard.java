package monopoly_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AdCard extends JPanel {
	private JPanel setPanel;
	private JButton pickCard;
	private JLabel bg;
	private JLabel adCard1,adCard2,adCard3;
	private int nRandom;
	private int Result;
	
	private GameListener gameL;
	
	public AdCard(){
		setPreferredSize(new Dimension(480,480));
		setBackground(Color.white);
		setLayout(null);
		
		gameL = new GameListener();
		
		setPanel = new JPanel();
		setPanel.setBounds(10,10,460,460);//location
		setPanel.setBackground(Color.white);
		//setPanel.setVisible(true);
		//pickCard.addActionListener(gameL);
		setPanel.setLayout(null);
		add(setPanel);
		
		bg = new JLabel();
		bg.setBounds(0,0,460,460);
		bg.setBackground(Color.white);
		bg.setVisible(true);
		setPanel.add(bg);
		
		Font fntButton = new Font("Verdana",Font.PLAIN,12);
		
		pickCard = new JButton("Pick Card");
		pickCard.setBounds(100,100,200,200);
		pickCard.setVisible(true);
		pickCard.setFont(fntButton);
		pickCard.addActionListener(gameL);
		bg.add(pickCard);
		
		ImageIcon a_icon = new ImageIcon("Break.gif");
		adCard1 = new JLabel(a_icon);
		adCard1.setBounds(0,0,440,440);
		adCard1.setHorizontalAlignment(SwingConstants.CENTER);
		adCard1.setVerticalAlignment(SwingConstants.CENTER);
		adCard1.setVisible(false);
		//adCard1.addActionListener(gameL);
		setPanel.add(adCard1);
		
		ImageIcon a_icon2 = new ImageIcon("Grade.gif");
		adCard2 = new JLabel(a_icon2);
		adCard2.setBounds(0,0,440,440);
		adCard2.setHorizontalAlignment(SwingConstants.CENTER);
		adCard2.setVerticalAlignment(SwingConstants.CENTER);
		//adCard2.addActionListener(gameL);
		adCard2.setVisible(false);
		setPanel.add(adCard2);
		
		ImageIcon a_icon3 = new ImageIcon("Scholarship.gif");
		adCard3 = new JLabel(a_icon3);
		adCard3.setBounds(0,0,440,440);
		adCard3.setHorizontalAlignment(SwingConstants.CENTER);
		adCard3.setVerticalAlignment(SwingConstants.CENTER);
		//adCard3.addActionListener(gameL);
		adCard3.setVisible(false);
		setPanel.add(adCard3);
		
		nRandom = 0;
	}
	
	public void start(){
		setPanel.setVisible(true);
		pickCard.setVisible(true);
	}
	public void Reset(){
		adCard1.setVisible(false);
		adCard2.setVisible(false);
		adCard3.setVisible(false);
	}
	
	public void Result1(){
		adCard1.setVisible(true);
		String result = "Break!"; 
		JOptionPane.showMessageDialog(null,result);
	}
	public void Result2(){
		adCard2.setVisible(true);
		String result = "A+ Grade!"; 
		JOptionPane.showMessageDialog(null,result);
	}
	public void Result3(){
		adCard3.setVisible(true);
		String result = "Scholarship!"; 
		JOptionPane.showMessageDialog(null,result);
	}
	
	private class GameListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
		
		Object obj = event.getSource();
		
		int a = 0;
		nRandom = (int)(Math.random()*3)+1;
		a = nRandom; 
		
		if(obj == pickCard){
			pickCard.setVisible(false);
		
		if(a%3==2) {
			//
			Result1();
			Reset();
			}
		else if(a%3==1) {
			//adCard2.setVisible(true);
			Result2();
			Reset();
			}
		else {
			//adCard3.setVisible(true);
			Result3();
			Reset();
		}
			
	}
	}	
	
	}
}