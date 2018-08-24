package monopoly_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PCard extends JPanel {
	private JPanel setPanel;
	private JButton pickCard;
	private JLabel bg;
	private JLabel pCard1,pCard2,pCard3;
	private int nRandom;
	private int Result;
	
	private GameListener gameL;
	
	public PCard(){
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
		
		ImageIcon p_icon = new ImageIcon("MT.gif");
		pCard1 = new JLabel(p_icon);
		pCard1.setBounds(0,0,440,440);
		pCard1.setHorizontalAlignment(SwingConstants.CENTER);
		pCard1.setVerticalAlignment(SwingConstants.CENTER);
		pCard1.setVisible(false);
		//adCard1.addActionListener(gameL);
		setPanel.add(pCard1);
		
		ImageIcon p_icon2 = new ImageIcon("FGrade.gif");
		pCard2 = new JLabel(p_icon2);
		pCard2.setBounds(0,0,440,440);
		pCard2.setHorizontalAlignment(SwingConstants.CENTER);
		pCard2.setVerticalAlignment(SwingConstants.CENTER);
		//adCard2.addActionListener(gameL);
		pCard2.setVisible(false);
		setPanel.add(pCard2);
		
		ImageIcon p_icon3 = new ImageIcon("extra.gif");
		pCard3 = new JLabel(p_icon3);
		pCard3.setBounds(0,0,440,440);
		pCard3.setHorizontalAlignment(SwingConstants.CENTER);
		pCard3.setVerticalAlignment(SwingConstants.CENTER);
		//adCard3.addActionListener(gameL);
		pCard3.setVisible(false);
		setPanel.add(pCard3);
		
		nRandom = 0;
	}
	
	public void Result1(){
		pCard1.setVisible(true);
		String result = "MT next!"; 
		JOptionPane.showMessageDialog(null,result);
		
	}
	public void Result2(){
		pCard2.setVisible(true);
		String result = "F Grade!"; 
		JOptionPane.showMessageDialog(null,result);
	}
	public void Result3(){
		pCard3.setVisible(true);
		String result = "Extra Lecture!"; 
		JOptionPane.showMessageDialog(null,result);
	}
	
	public void start(){
		setPanel.setVisible(true);
		pickCard.setVisible(true);
	}
	public void Reset(){
		pCard1.setVisible(false);
		pCard2.setVisible(false);
		pCard3.setVisible(false);
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
			//pCard1.setVisible(true);
			Result1();
			Reset();
			}
		else if(a%3==1) {
			//pCard2.setVisible(true);
			Result2();
			Reset();
			}
		else {
			//pCard3.setVisible(true);
			Result3();
			Reset();
			}
			
	
	}
	}	
	
	}
}