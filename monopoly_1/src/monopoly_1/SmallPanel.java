package monopoly_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SmallPanel extends JPanel {

	private JLabel lblSign,lblPrice;
	//private JRadioButton rbtn1,rbtn2,rbtn3,rbtn4,rbtn5;
	private JRadioButton[] rbtn;
	private String[] radioText = {"�Ȼ��","��������","��üũ���ܼ�ġ x2","�ֽ���ǻ�ͼ�ġ x3","�Ű����� x4"};
	private JButton btnSelect;
	private SmallPanelListener smallL;

	private MonopolyPanel copied;
	private LandPanel[] landPanel;
	private Player[] player;
	private int[][] landBuyArr;
	private int playTurn;

	private JFrame frame;

	public SmallPanel(MonopolyPanel parent)//(int escape) 
	{
		copied = parent;
		landPanel=copied.getLandPanel();
		player=copied.getPlayer();
		landBuyArr=copied.getLandBuyArr();
		playTurn=copied.getPlayTurn();

		setPreferredSize(new Dimension(200,300));
		setBackground(Color.pink);
		//setLayout(null);
		setLayout(new GridLayout(8,1));
		Font lblFont; //��
		//lblSign = new JLabel("�췡����");
		lblSign = new JLabel( LandConstants.NAME[ player[copied.getPlayTurn()].getPlayerPosition() ]+" �췡����");
		lblSign.setBounds(30, 20, 100, 20);
		//lblSign.setHorizontalAlignment(SwingConstants.CENTER);

		lblPrice = new JLabel(""+LandConstants.LAND_PRICE[ player[copied.getPlayTurn()].getPlayerPosition() ]);


		smallL = new SmallPanelListener();
		ButtonGroup group = new ButtonGroup();
		rbtn = new JRadioButton[5];
		for(int i=0;i<5;i++) {
			rbtn[i]=new JRadioButton(radioText[i]);
			group.add(rbtn[i]);
		}
		add(lblSign);
		add(lblPrice);
		for(int i=0;i<5;i++) {
			add(rbtn[i]);
		}

		btnSelect = new JButton("OK");
		btnSelect.addActionListener(smallL);
		add(btnSelect);
	} // SmallPanel


	public SmallPanel(MonopolyPanel parent,int playTurn, int nowPos)//(int escape) 
	{
		copied = parent;
		landPanel=copied.getLandPanel();
		player=copied.getPlayer();
		landBuyArr=copied.getLandBuyArr();
		playTurn=copied.getPlayTurn();

		setPreferredSize(new Dimension(200,300));
		setBackground(Color.pink);
		//setLayout(null);
		setLayout(new GridLayout(8,1));
		lblSign = new JLabel("�췡����");
		//lblSign = new JLabel( LandConstants.NAME[ player[copied.getPlayTurn()].getPlayerPosition() ]+" �췡����");
		lblSign.setBounds(30, 20, 100, 20);
		//lblSign.setHorizontalAlignment(SwingConstants.CENTER);

		lblPrice = new JLabel(""+LandConstants.LAND_PRICE[ player[copied.getPlayTurn()].getPlayerPosition() ]);


		smallL = new SmallPanelListener();
		ButtonGroup group = new ButtonGroup();
		rbtn = new JRadioButton[5];
		for(int i=0;i<5;i++) {
			rbtn[i]=new JRadioButton(radioText[i]);
			group.add(rbtn[i]);
		}
		add(lblSign);
		add(lblPrice);
		for(int i=0;i<5;i++) {
			add(rbtn[i]);
		}

		btnSelect = new JButton("OK");
		btnSelect.addActionListener(smallL);
		add(btnSelect);
	} // SmallPanel



	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public String calcColor(int i) {
		String strColor="";

		// 0~7 = ������ 
		if(i==1 ||i==2 ||i==3  ) { strColor = "green"; }
		else if(i==5||i==6 ||i==7) { strColor = "blue"; }
		else if(i==9||i==10 ||i==11) { strColor = "brown"; }
		else if(i==13 ||i==14 ||i==15 ) { strColor = "sky"; }
		else if(i==17||i==18 ||i==19 ) { strColor = "pink"; }
		else if(i==21||i==22 ||i==23 ) { strColor = "orange"; }
		else if(i==25||i==26 ||i==27 ) { strColor = "red"; }
		else if(i==29||i==30 ||i==31) { strColor = "yellow"; }			

		return strColor;
	}

	public int calcPrice(int newLvl ) { // ���׸�ŭ ����

		int nowPos = player[MonopolyPanel.playTurn].getPlayerPosition();
		int cost;
		//player[MonopolyPanel.playTurn].setPlayerMoney( player[MonopolyPanel.playTurn].getPlayerMoney() - LandConstants.LAND_PRICE[n] );
		//landPanel[player[MonopolyPanel.playTurn].getPlayerPosition()].setOwner( player[MonopolyPanel.playTurn].getPlayerNum() );


		cost = ( newLvl-landPanel[nowPos].getBuildingLvl() +1 ) * LandConstants.LAND_PRICE[nowPos] ; 
		// *( ���ο�ǹ���-����ǹ��� +1 ) *������ 


		return cost;
	}

	public void updateSign() { //�췡����
		lblSign.setText( " < "+LandConstants.NAME[ player[MonopolyPanel.playTurn].getPlayerPosition() ]+" > "+ "�췡����" );
		lblPrice.setText("$"+LandConstants.LAND_PRICE[ player[copied.getPlayTurn()].getPlayerPosition() ]);
	}


	private class SmallPanelListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent event) {

			Object obj=event.getSource();
			if(obj==btnSelect) {

				if(rbtn[0].isSelected()) {
					System.out.println("�Ȼ��");
					//setVisible(false);
					//System.exit(0);
					//escape=1;
					//copied.setEscapeFrame(true);
					frame.dispose();

				}
				if(rbtn[1].isSelected()) {
					System.out.println("��������");
					int nowPos=player[copied.getPlayTurn()].getPlayerPosition();
		
					if( player[playTurn].getPlayerMoney() < LandConstants.LAND_PRICE[nowPos] ) {
						JOptionPane.showMessageDialog(null, "���̾���");
					} else {
						/*
						//?????????????????????????????? static
						//landBuyArr[playTurn][n]=1; // �÷��̾�, ��ȣ ������
						//player[playTurn].setPlayerMoney( player[playTurn].getPlayerMoney() - LandConstants.LAND_PRICE[n] );
						//landPanel[player[playTurn].getPlayerPosition()].setOwner( player[playTurn].getPlayerNum() );
						 */

						//calcColor(player[MonopolyPanel.playTurn].getPlayerPosition()); //���ִ� ��ġ�� �ش��ϴ� ����ȯ

						//ImageIcon icon = new ImageIcon("blue2.png");
						/* ���� 1,2�����
						ImageIcon icon = new ImageIcon(
								calcColor( player[MonopolyPanel.playTurn].getPlayerPosition() )
								+ (MonopolyPanel.playTurn+1) + ".png"
								);
						 */
						/*
						ImageIcon icon = new ImageIcon(
								LandConstants.NAME[player[MonopolyPanel.playTurn].getPlayerPosition()]
										+ "("
										+ ( MonopolyPanel.playTurn + 1)
										+ ")"
										+ ".png" );*/

						ImageIcon icon = new ImageIcon(
								LandConstants.NAME[player[MonopolyPanel.playTurn].getPlayerPosition()]
										+ "("
										+ ( MonopolyPanel.playTurn + 1)+"_"+0 
										+ ")"
										+ ".png" );
						landPanel[player[MonopolyPanel.playTurn].getPlayerPosition()].lblLand[player[MonopolyPanel.playTurn].getPlayerPosition()].setIcon(icon);
						//landBuyArr[MonopolyPanel.playTurn][n]=1; // �÷��̾�, ��ȣ ������
						player[MonopolyPanel.playTurn].setPlayerMoney( player[MonopolyPanel.playTurn].getPlayerMoney() - LandConstants.LAND_PRICE[nowPos] );
						landPanel[player[MonopolyPanel.playTurn].getPlayerPosition()].setOwner( player[MonopolyPanel.playTurn].getPlayerNum() );
						landPanel[player[playTurn].getPlayerPosition()].setBuildingLvl(1);

						
					}

					copied.updateInfo();

					repaint();
					frame.dispose();
				}


				if(rbtn[2].isSelected()) {
					System.out.println("�ǹ�+1");
					int nowPos=player[copied.getPlayTurn()].getPlayerPosition();
					
					if( player[playTurn].getPlayerMoney() < LandConstants.LAND_PRICE[nowPos] ) {
						JOptionPane.showMessageDialog(null, "���̾���");
					} else {
						
						ImageIcon icon = new ImageIcon(
								LandConstants.NAME[player[MonopolyPanel.playTurn].getPlayerPosition()]
										+ "("
										+ ( MonopolyPanel.playTurn + 1)+"_"+ 1
										+ ")"
										+ ".png" );
						landPanel[player[MonopolyPanel.playTurn].getPlayerPosition()].lblLand[player[MonopolyPanel.playTurn].getPlayerPosition()].setIcon(icon);
						//landBuyArr[MonopolyPanel.playTurn][n]=1; // �÷��̾�, ��ȣ ������
						player[MonopolyPanel.playTurn].setPlayerMoney( player[MonopolyPanel.playTurn].getPlayerMoney() - calcPrice(2) );
						landPanel[player[MonopolyPanel.playTurn].getPlayerPosition()].setOwner( player[MonopolyPanel.playTurn].getPlayerNum() );
						landPanel[player[playTurn].getPlayerPosition()].setBuildingLvl(2);
						
					
						
					}

					copied.updateInfo();

					repaint();
					frame.dispose();
				}

				if(rbtn[3].isSelected()) {
					System.out.println("�ǹ�+2");
					int nowPos=player[copied.getPlayTurn()].getPlayerPosition();
					
					if( player[playTurn].getPlayerMoney() < LandConstants.LAND_PRICE[nowPos] ) {
						JOptionPane.showMessageDialog(null, "���̾���");
					} else {
						


						ImageIcon icon = new ImageIcon(
								LandConstants.NAME[player[MonopolyPanel.playTurn].getPlayerPosition()]
										+ "("
										+ ( MonopolyPanel.playTurn + 1)+"_"+ 2
										+ ")"
										+ ".png" );
						landPanel[player[MonopolyPanel.playTurn].getPlayerPosition()].lblLand[player[MonopolyPanel.playTurn].getPlayerPosition()].setIcon(icon);
						//landBuyArr[MonopolyPanel.playTurn][n]=1; // �÷��̾�, ��ȣ ������
						player[MonopolyPanel.playTurn].setPlayerMoney( player[MonopolyPanel.playTurn].getPlayerMoney() - calcPrice(2) );
						landPanel[player[MonopolyPanel.playTurn].getPlayerPosition()].setOwner( player[MonopolyPanel.playTurn].getPlayerNum() );
						landPanel[player[playTurn].getPlayerPosition()].setBuildingLvl(3);
						
						
					}

					copied.updateInfo();

					repaint();
					frame.dispose();
				}

				if(rbtn[4].isSelected()) {
					System.out.println("�ǹ�+3");
					int nowPos=player[copied.getPlayTurn()].getPlayerPosition();
					if( player[playTurn].getPlayerMoney() < LandConstants.LAND_PRICE[nowPos] ) {
						JOptionPane.showMessageDialog(null, "���̾���");
					} else {



						ImageIcon icon = new ImageIcon(
								LandConstants.NAME[player[MonopolyPanel.playTurn].getPlayerPosition()]
										+ "("
										+ ( MonopolyPanel.playTurn + 1)+"_"+ 3
										+ ")"
										+ ".png" );
						landPanel[player[MonopolyPanel.playTurn].getPlayerPosition()].lblLand[player[MonopolyPanel.playTurn].getPlayerPosition()].setIcon(icon);
						//landBuyArr[MonopolyPanel.playTurn][n]=1; // �÷��̾�, ��ȣ ������
						player[MonopolyPanel.playTurn].setPlayerMoney( player[MonopolyPanel.playTurn].getPlayerMoney() - calcPrice(2) );
						landPanel[player[MonopolyPanel.playTurn].getPlayerPosition()].setOwner( player[MonopolyPanel.playTurn].getPlayerNum() );
						landPanel[player[playTurn].getPlayerPosition()].setBuildingLvl(4);

					}

					copied.updateInfo();

					repaint();
					frame.dispose();
				}



			}


		} //actionPerformed


	} //SmallPanelListeneesfsaf





} //smallPanel class
