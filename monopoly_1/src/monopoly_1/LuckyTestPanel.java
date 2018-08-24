package monopoly_1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LuckyTestPanel extends JPanel {
	private JPanel setPanel;
	private JLabel lblTitle;
	private JButton btnMiddle, btnLeft, btnRight;
	private JButton btnMiddle2,btnLeft2, btnRight2;
	private int nRandom;
	protected int num1;
	public int resultNumber =1;
	
	private GameListener gameL;
	
	public LuckyTestPanel() {
		setPreferredSize(new Dimension(430,430));
		setBackground(Color.white);
		setLayout(null);
		
		gameL = new GameListener();
		
		
		setPanel = new JPanel();
		setPanel.setBounds(10,10,400,400);//location
		setPanel.setBackground(Color.white);
		setPanel.setLayout(null);
		add(setPanel);
		
		ImageIcon mb_icon = new ImageIcon("Minigame.png");
		lblTitle = new JLabel(mb_icon);
		//lblTitle = new JLabel("Lucky Test");
		lblTitle.setBounds(0,0,400,400);
		lblTitle.setFont(new Font("Verdana",Font.BOLD,30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblTitle.setVisible(true);
		setPanel.add(lblTitle);
		
	
		Font fntButton = new Font("Verdana",Font.PLAIN,12);
		ImageIcon m_Card1 = new ImageIcon("Card1.jpg");	
		ImageIcon m_Card2 = new ImageIcon("Card2.jpg");	
		
		btnLeft = new JButton(m_Card1); 
		btnLeft.setBounds(40,200,100,150);
		btnLeft.setFont(fntButton);
		btnLeft.setVisible(true);
		btnLeft.addActionListener(gameL);
		btnLeft.setBorderPainted(false);
		lblTitle.add(btnLeft);
		
		btnLeft2 = new JButton(m_Card2); 
		btnLeft2.setBounds(40,200,100,150);
		btnLeft2.setFont(fntButton);
		btnLeft2.setVisible(false);
		btnLeft2.addActionListener(gameL);
		btnLeft2.setBorderPainted(false);
		lblTitle.add(btnLeft2);
		
		
		btnMiddle = new JButton(m_Card1);
		btnMiddle.setBounds(160,200,100,150);
		btnMiddle.setFont(fntButton);
		btnMiddle.setVisible(true);
		btnMiddle.addActionListener(gameL);
		btnMiddle.setBorderPainted(false);
		lblTitle.add(btnMiddle);
		
		btnMiddle2 = new JButton(m_Card2);
		btnMiddle2.setBounds(160,200,100,150);
		btnMiddle2.setFont(fntButton);
		btnMiddle2.setVisible(false);
		btnMiddle2.addActionListener(gameL);
		btnMiddle2.setBorderPainted(false);
		lblTitle.add(btnMiddle2);
		
		btnRight = new JButton(m_Card1);
		btnRight.setBounds(280,200,100,150);
		btnRight.setFont(fntButton);
		btnRight.setVisible(true);
		btnRight.addActionListener(gameL);
		btnRight.setBorderPainted(false);
		lblTitle.add(btnRight);	
		
		btnRight2 = new JButton(m_Card2);
		btnRight2.setBounds(280,200,100,150);
		btnRight2.setFont(fntButton);
		btnRight2.setVisible(false);
		btnRight2.addActionListener(gameL);
		btnRight2.setBorderPainted(false);
		lblTitle.add(btnRight2);	
		
		nRandom = 0;
		
	}//constructor
	
	public int getResult() {return resultNumber;}
	public void setReusult(int value) { resultNumber=value; }

	
	public void rightResult(){
		String result = "You are Lucky Guy!"; 
		JOptionPane.showMessageDialog(null,result);
		resultNumber = 1;
	}
	public void wrongResult(){
		//int result = JOptionPane.showMessageDialog(null,"You are Unlucky Guy!");
		String result = "You are Unlucky Guy!";
		JOptionPane.showMessageDialog(null,result);
		resultNumber = 0;
	}
	public void start(){
		lblTitle.setVisible(true);
		btnMiddle.setVisible(true);
		btnLeft.setVisible(true);
		btnRight.setVisible(true);
	}
	public void Reset(){
		lblTitle.setVisible(false);
		btnMiddle.setVisible(false);
		btnLeft.setVisible(false);
		btnRight.setVisible(false);
		btnMiddle2.setVisible(false);
		btnLeft2.setVisible(false);
		btnRight2.setVisible(false);
		
	}
	
	private class GameListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
		
		Object obj = event.getSource();
		nRandom = (int)(Math.random()*50)+1;
		
		if(obj == btnLeft||obj == btnMiddle||obj == btnRight){
			
			
			if(obj == btnLeft){
				btnLeft.setVisible(false);
				btnLeft2.setVisible(true);}
			if(obj == btnRight){
				btnRight.setVisible(false);
				btnRight2.setVisible(true);}
			if(obj == btnMiddle){
				btnMiddle.setVisible(false);
				btnMiddle2.setVisible(true);}
			if(nRandom%2==1){
				rightResult();
				//resultNumber = 1;
				Reset();
			}else{
				wrongResult();
				//resultNumber = 0;
				Reset();
			}	
		} //second elseif
		
	}//GameListener Class
		
	}//LuckyTestPanel()
	
}//class LuckyTestPanel