package monopoly_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InitialPanel extends JPanel {
	private JPanel setPanel;
	private JLabel lblTitle, lblMark,MainImage;
	private JButton btnRandom, btnOdd, btnEven;
	private int nRandom;
	private MonopolyPanel Game;
	private int Order;
	
	
	private GameListener gameL;
	private InitialListener initialL;
	
	public InitialPanel() {
		setPreferredSize(new Dimension(800,800));
		setBackground(Color.yellow);
		setLayout(null);
		
		gameL = new GameListener();
		initialL = new InitialListener();
		
		setPanel = new JPanel();
		setPanel.setBounds(0,0,800,800);//location
		setPanel.setBackground(new Color(255,224,49));
		setPanel.setLayout(null);
		setPanel.setVisible(true);
		add(setPanel);
		
		ImageIcon Title = new ImageIcon("Maintitle.png");
		lblTitle=new JLabel("",Title,SwingConstants.CENTER);
		lblTitle.setBounds(105,10,615,100);
		lblTitle.setLayout(null);
		lblTitle.setVisible(true);
		setPanel.add(lblTitle);
		
		ImageIcon SubTitle = new ImageIcon("Diechoicetxt.png");
		lblMark = new JLabel("",SubTitle,SwingConstants.CENTER);
		lblMark.setBounds(150,90,500,200);
		lblMark.setFont(new Font("Verdana",Font.BOLD,30));
		lblMark.setVisible(true);
		setPanel.add(lblMark);
		
		Font fntButton = new Font("Verdana",Font.PLAIN,15);
		
		ImageIcon Diechoice1=new ImageIcon("Diechoice1_1.png");
		btnOdd = new JButton(Diechoice1);
		btnOdd.setBounds(30,265,320,350);
		btnOdd.addActionListener(gameL);
		btnOdd.setBorderPainted(false); // 버튼 경계선 제거
	    btnOdd.setFocusPainted(false); //포커스(선택했던 버튼 표시) 제거
		btnOdd.setContentAreaFilled(false);//버튼영역 배경 제거
		btnOdd.setVisible(true);
		setPanel.add(btnOdd);
		
		ImageIcon Diechoice2=new ImageIcon("Diechoice2_1.png");
		btnEven = new JButton(Diechoice2);
		btnEven.setBounds(430,265,320,350);
		btnEven.setBorderPainted(false); // 버튼 경계선 제거
	    btnEven.setFocusPainted(false); //포커스(선택했던 버튼 표시) 제거
		btnEven.setContentAreaFilled(false);//버튼영역 배경 제거
		btnEven.addActionListener(gameL);
		btnEven.setVisible(true);
		setPanel.add(btnEven);	
		
		ImageIcon TitleImage= new ImageIcon("MainCharacter.png");
		MainImage=new JLabel("",TitleImage,SwingConstants.CENTER);
		MainImage.setBounds(240,620,300,180);
		MainImage.setHorizontalAlignment(SwingConstants.CENTER);
		MainImage.setVerticalAlignment(SwingConstants.CENTER);
		MainImage.setVisible(true);
		setPanel.add(MainImage);
	
		
		nRandom = 0;
	}//constructor
	
	public int getOrder(){return Order;}
	
	public void FirstResult(){
		String result = "Player 1 is First!"; 
		JOptionPane.showMessageDialog(null,result);
		lblTitle.setVisible(false);
		lblMark.setVisible(false);
		MainImage.setVisible(false);
		btnOdd.setVisible(false);
		btnEven.setVisible(false);
		setPanel.setVisible(false);
		Order = 0;
		//Game = new MonopolyPanel();
		Game = new MonopolyPanel(Order);
		Game.setBounds(0,0,1400,1400);
		add(Game);
	}
	public void SecondResult(){
		//int result = JOptionPane.showMessageDialog(null,"You are Unlucky Guy!");
		String result = "Player 2 is First!";
		JOptionPane.showMessageDialog(null,result);
		lblTitle.setVisible(false);
		lblMark.setVisible(false);
		MainImage.setVisible(false);
		btnOdd.setVisible(false);
		btnEven.setVisible(false);
		setPanel.setVisible(false);
		Order = 1;
		Game = new MonopolyPanel(Order);
		//Game = new MonopolyPanel();
		Game.setBounds(0,0,1400,1400);
		
		add(Game);
	}
	
	private class InitialListener implements MouseListener
	{
		public void mouseClicked(MouseEvent event) {}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
	}/// ButtonMenuListener class
	
	private class GameListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
		
		Object obj = event.getSource();
		
		if (obj == btnOdd || obj == btnEven ){
			nRandom=(int)(Math.random()*50)+1;
			if(nRandom%2==0){
				FirstResult();
			}else{
				SecondResult();
			}		
		} //second elseif
		
	}//
		
	}
}//GameListener Class




