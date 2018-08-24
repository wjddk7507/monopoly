package monopoly_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MonopolyPanel extends JPanel{ // �����ǰ� �������̼� â�� �ö�
	private boolean escapeFrame=false; ///////////////
	int pro1, pro2;
	int landWidth, landHeight; // ������ ũ��
	int infoWidth, infoHeight; // �������̼� â ũ��
	int eventLen, landLen; // �̺�Ʈ ĭ�� �׳� ĭ ũ��
	private LandPanel[] landPanel; // �� ��ü �迭//private LandPanel[] landPanel; // �� ��ü �迭
	private int[][] landBuyArr; // ���� ���� ����� ���� ǥ��

	private JPanel infoPanel;
	private JLabel lbloptionImage1, lbloptionImage2;
	private JLabel lblPlayer1Image, lblPlayer2Image;
	private int image;
	private JLabel lblName;//, lblPlayerMoney;

	//private JLabel lblPlayerMoney1,lblPlayerMoney2;

	private JLabel[] lblPlayerMoney;
	private JLabel lblNowPlayer1, lblNowPlayer2;
	private GameListener gameL;
	private MenuMouseListener		menuMouseL;
	private JButton btnRoll,btnTest,btnNext;
	private JButton btnReset;

	private Dice dice;
	private int playMax; //�÷��̾��


	//private int playTurn;
	public static int playTurn;


	private Player[] player;

	private String[] playerIconName;


	private JLabel lblTestPlayerPos,lblTestPlayerNum;
	private JLabel lblDie1,lblDie2,lblDie3;

	private SmallPanel smallP;
	
	private LuckyTestPanel LuckyGamePanel; //���Һ����� 
	private OddEvenPanel OddEvenGamePanel; //Ȧ¦����
	private EventPanel Event; //�̺�Ʈ��
	private InitialPanel Ini; //���� (�ʿ������ ���ٰ���)
	private AdCard ad; //����ī��
	private PCard p; //�г�Ƽī��
	private int num;

	public MonopolyPanel(int order) {
		playMax=2;//2�ο�
		landWidth = landHeight = infoHeight = 960; // ������ ũ��
		eventLen = 130; landLen = 100;			   // event�� ũ�� // �� ũ��
		infoWidth = 400;	// info â ���� ũ��
		landBuyArr = new int[2][32];	// �� ������ �÷��̾� ǥ���ϱ� ���� �迭
		for(int i=0; i<32; i++) { landBuyArr[0][i]=0; landBuyArr[1][i]=0;} // �ʱ�ȭ
		landPanel = new LandPanel[32]; 

		LuckyGamePanel = new LuckyTestPanel();
		LuckyGamePanel.setBounds(250, 250, 430, 430);
		LuckyGamePanel.setVisible(false);
		add(LuckyGamePanel); // �̴ϰ���1 �г�
		
		OddEvenGamePanel = new OddEvenPanel();
		OddEvenGamePanel.setBounds(250, 250, 430, 430);
		OddEvenGamePanel.setVisible(false);
		add(OddEvenGamePanel); // �̴ϰ���2 �г�
		
		Event = new EventPanel();
		Event.setBounds(250,250,480,480);
		Event.setVisible(false);
		add(Event);//�̺�Ʈ �г�
		
		ad = new AdCard();
		ad.setBounds(250,250,480,480);
		ad.setVisible(false);
		add(ad);//���� ī�� �г�
		
		p = new PCard();
		p.setBounds(250,250,480,480);
		p.setVisible(false);
		add(p);//���� ī�� �г�

		infoPanel = new JPanel(); //�����
		infoPanel.setPreferredSize(new Dimension(infoWidth, infoHeight));
		infoPanel.setBounds(landWidth, 0, infoWidth, infoHeight);//960,0,400,960
		infoPanel.setBackground(new Color(255,224,49));
		infoPanel.setLayout(null);

		gameL = new GameListener();
		menuMouseL = new MenuMouseListener();
		playerIconName = new String[8];
		CharInit();
		PlayerCharInit();

		//////��ưPlayer1 roll button
		ImageIcon RollIcon = new ImageIcon("diebtn_1.png");	 
		btnRoll = new JButton(RollIcon);	  
		btnRoll.setBounds(landWidth+130, 85, 130, 130);//(landWidth+40, 85, 120, 120);
		//btnRoll.addActionListener(MoL);
		btnRoll.setEnabled(true);
		btnRoll.addActionListener(gameL);
		btnRoll.addMouseListener(menuMouseL);
		add(btnRoll);

		/*btnTest = new JButton("NEWFRAME");
		btnTest.setBounds(400, 500, 70, 30);
		btnTest.addActionListener(gameL);
		btnTest.setVisible(false);
		add(btnTest);*/
		//btnTest.setBounds(landWidth+40, 200, width, height);

		//��ư ������ ����
		btnRoll.setBorderPainted(false); // ��ư ��輱 ����
		//btnRoll.setFocusPainted(false); //��Ŀ��(�����ߴ� ��ư ǥ��) ����
		btnRoll.setContentAreaFilled(false);//��ư���� ��� ����
		/*
		//ImageIcon nextIcon = new ImageIcon("resetbtn.png");
		btnNext = new JButton("abc");
		btnNext.setBounds(landWidth*2+40, 200, 120, 120);
		btnNext.addActionListener(gameL);
		add(btnNext);
		 */

		/*
		//Player2 �ֻ��� ��ư 
		ImageIcon NextIcon = new ImageIcon("diebtn_1.png");
		//btnNext = new JButton("����");
		JButton btnNext = new JButton(NextIcon);	  
		btnNext.setBounds(landWidth+240,85,130,130);
		//btnNext.addActionListener(MoL);
		btnNext.setEnabled(true);
		add(btnNext);
		btnNext.setBorderPainted(false); // ��ư ��輱 ����
		//btnNext.setFocusPainted(false); //��Ŀ��(�����ߴ� ��ư ǥ��) ����
		btnNext.setContentAreaFilled(false);//��ư���� ��� ����
	*/

		////////////// reset ��ư 
		//btnTEST_RESET = new JButton("ó������")
		// �ϳѱ���
		ImageIcon ResetIcon2 = new ImageIcon("resetbtn.png");   //?????????????????????????????????????????
		btnReset = new JButton(ResetIcon2); 
		btnReset.setBounds(landWidth+130, 225, 130, 130);//(landWidth+40, 225, 130, 130);
		btnReset.addActionListener(gameL);
		btnReset.addMouseListener(menuMouseL);
		add(btnReset);
		btnReset.setBorderPainted(false); // ��ư ��輱 ����
		//btnReset.setFocusPainted(false); //��Ŀ��(�����ߴ� ��ư ǥ��) ����
		btnReset.setContentAreaFilled(false);//��ư���� ��� ����
		btnReset.setEnabled(false);

		/*
		//////////////reset ��ư2 ////
		ImageIcon ResetIcon = new ImageIcon("resetbtn.png");
		JButton btnReset2 = new JButton(ResetIcon); 
		btnReset2.setBounds(landWidth+240, 225, 130, 130);
		//btnReset2.addActionListener(MoL);
		add(btnReset2);
		btnReset2.setBorderPainted(false); // ��ư ��輱 ����
		//btnReset2.setFocusPainted(false); //��Ŀ��(�����ߴ� ��ư ǥ��) ����
		btnReset2.setContentAreaFilled(false);//��ư���� ��� ����
*/
		//optionPanel�̹��� ���� 
		ImageIcon icon1= new ImageIcon("kakao.png");

		lbloptionImage1=new JLabel("",icon1,SwingConstants.CENTER);
		lbloptionImage1.setBounds(landWidth+100,800,210,76);
		lbloptionImage1.setHorizontalAlignment(SwingConstants.CENTER);
		lbloptionImage1.setVerticalAlignment(SwingConstants.CENTER);
		add(lbloptionImage1);

		ImageIcon GameName = new ImageIcon("monopoly.png");	//�����̸� ��� 
		lblName=new JLabel("",GameName,SwingConstants.CENTER);
		lblName.setBounds(landWidth+107,860,190,76);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setVerticalAlignment(SwingConstants.CENTER);
		add(lblName);


		lblPlayerMoney = new JLabel[2];

		for(int i=0, j=0 ; i< playMax ; i++,j+=200) {
			lblPlayerMoney[i] = new JLabel("Money : 2000000");
			lblPlayerMoney[i].setForeground(Color.black);
			lblPlayerMoney[i].setFont(new Font("Cooper Std Black",Font.PLAIN,23));
			lblPlayerMoney[i].setBounds(landWidth+30+j, 640, 250, 100);
			add(lblPlayerMoney[i]);
		}


		add(infoPanel);


		pro1 = pro2 = 2000000;


		setPreferredSize(new Dimension(landWidth+infoWidth, landHeight));
		setBackground(Color.white);
		setLayout(null);


		// landPanel ��ü �迭 ����
		landPanel[0] = new LandPanel(0,0,landHeight-eventLen,eventLen,eventLen);

		for(int y=landHeight-eventLen-landLen, i=1; y>0 && i<8; y-=landLen, i++) {
			landPanel[i] = new LandPanel(i,0,y,eventLen,landLen);
		}

		landPanel[8] = new LandPanel(8,0,0,eventLen,eventLen);

		for(int x=eventLen, i=9; x<landWidth-eventLen && i<16; x+=landLen, i++) {
			landPanel[i] = new LandPanel(i,x,0,landLen,eventLen);
		}

		landPanel[16] = new LandPanel(16,landWidth-eventLen,0,eventLen,eventLen);

		for(int y=eventLen, i=17; y<landHeight-landLen && i<24; y+=landLen, i++) {
			landPanel[i] = new LandPanel(i,landWidth-eventLen,y,eventLen,landLen);
		}

		landPanel[24] = new LandPanel(24,landWidth-eventLen,landHeight-eventLen,eventLen,eventLen);

		for(int x=landWidth-eventLen-landLen, i=25; x>0 && i<32; x-=landLen, i++) {
			landPanel[i] = new LandPanel(i,x,landHeight-eventLen,landLen,eventLen);
		}

		for(int i=0; i<32; i++) {
			JLabel lbl = new JLabel(LandConstants.NAME[i]);
			landPanel[i].add(lbl);
		}


		for(int i=0; i<32; i++) add(landPanel[i]);
		// landPanel, infoPanel add
		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////




		/*
		landBuyArr[0][1]=1; //0 == ����x 1 == ����o, landBuyArr[�÷��̾�][����ȣ] 
		landBuyArr[0][9]=1;
		landBuyArr[1][21]=1;
		landBuyArr[1][27]=1;
		 */

		// player���� ���� �� ��� ���̺�� ǥ��
		for(int i=0; i<32; i++) {
			if(landBuyArr[0][i]==1) {
				landPanel[i].lblLand[i].setVisible(false);
				landPanel[i].lblOwn[0][getOwnNum(i)].setVisible(true);
			}
			if(landBuyArr[1][i]==1) {
				landPanel[i].lblLand[i].setVisible(false);
				landPanel[i].lblOwn[1][getOwnNum(i)].setVisible(true);
			}
		}

		dice = new Dice();
		//�÷��̾�κ�
		//playMax=2;
		
		//playTurn=0;
		playTurn = order;
		
		player = new Player[playMax]; //player 0, player 1
		for(int i=0 ; i<playMax ; i++ ) {
			player[i] = new Player(i);
			player[i].setPlayerImage( playerIconName[i] ); //���Ӹ�
			//player[i].setMonopolyPanel(this);
		}




		//player[playTurn].getPlayerPiece().setBounds(10,10,53,72);
		//landPanel[11].add( player[playTurn].getPlayerPiece() );
		this.lblDie1=new JLabel("die1");
		lblDie1.setBounds(400, 400, 30, 30);
		add(lblDie1);
		lblDie2=new JLabel("die2");
		lblDie2.setBounds(400, 420, 30, 30);
		add(lblDie2);

		this.lblTestPlayerPos = new JLabel("�޷�");
		lblTestPlayerPos.setBounds(400, 440, 30, 30);
		add(lblTestPlayerPos);

		int play = playTurn+1;
		lblTestPlayerNum = new JLabel("Player : "+play);
		lblTestPlayerNum.setBounds(400, 460, 70, 30);
		add(lblTestPlayerNum);


		smallP = new SmallPanel(this);

	} // MonopolyPanel
	///////////////////////////////////////////////////////////////////////////////////////////////////////







	public LandPanel[] getLandPanel() { return landPanel; }
	public Player[] getPlayer() { return player; }
	public int getPlayTurn() { return playTurn; }
	public int[][] getLandBuyArr() { return landBuyArr; }
	public boolean getEscapeFrame() { return escapeFrame; }


	public void setEscapeFrame(boolean value) { escapeFrame = value; } 



	private int getOwnNum(int i) { 
		int n=0;
		if(i>0 && i<4) n=0; //1~3
		if(i>4 && i<8) n=1; 
		if(i>8 && i<12) n=2;
		if(i>12 && i<16) n=3;
		if(i>16 && i<20) n=4;
		if(i>20 && i<24) n=5;
		if(i>25 && i<28) n=6;
		if(i>28 && i<32) n=7;
		return n;
	} // getOwnNum()



	public void buyDialog(int n)
	{
		if(n!=0 && n!=4 && n!=8 && n!=12 && n!=16 && n!=20 && n!=24 && n!=28 ) { // ����ȣ, �̺�Ʈ�гξƴҶ� ���
			int result = JOptionPane.showConfirmDialog(null, LandConstants.NAME[n]+"��ðڽ��ϱ�?"
					+"\n"+LandConstants.LAND_PRICE[n]+"��");

			switch(result) 
			{
			case JOptionPane.YES_OPTION :
				// ����..
				landBuyArr[playTurn][n]=1; // �÷��̾�, ��ȣ ������
				player[playTurn].setPlayerMoney( player[playTurn].getPlayerMoney() - LandConstants.LAND_PRICE[n] );
				landPanel[player[playTurn].getPlayerPosition()].setOwner( player[playTurn].getPlayerNum() );
				break;
			case JOptionPane.NO_OPTION :
				// ���ž���..

				break;

			} 
		} // �׳� ��
		
	} // buyDialog()


	public void buildDialog(int location) {
		int result = JOptionPane.showConfirmDialog(null, LandConstants.NAME[location]+"�� �ǹ��� �ø���?" );

		switch(result) 
		{
		case JOptionPane.YES_OPTION :
			//�ǹ��ø�

			break;
		case JOptionPane.NO_OPTION :

			break;
		}

	}

	public void chkBalance() {
		for( int i=0 ; i<playMax ; i++ )
			if( player[i].getPlayerMoney() < 0 ) { // ������
				btnRoll.setEnabled(false);
				btnReset.setEnabled(false);
				JOptionPane.showMessageDialog(null, "player : "+(i+1)+ " �� �Ļ��߽��ϴ�");
				System.exit(0);
			}
		
	}

	public void toggleButton() {

		if(btnReset.isEnabled()==false) {
			btnRoll.setEnabled(false);
			btnReset.setEnabled(true);
		}else {
			btnReset.setEnabled(false);
			btnRoll.setEnabled(true);
		}

	}




	///////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////
	private class GameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			boolean bFlag = false;
			Object obj = event.getSource();

			if(obj == btnRoll)
			{
				//������
				bFlag = true;

				if(player[playTurn].getFrozenTurn()!=0) {//frozencheck
					dice.rollDice();
					if( dice.getDice1() == dice.getDice2() ) { //Ż����
						JOptionPane.showMessageDialog(null,"!!!!!");
						player[playTurn].setFrozenTurn(0);
						gamePlayAction();
					} else {
						player[playTurn].setFrozenTurn( player[playTurn].getFrozenTurn()-1  );
						JOptionPane.showMessageDialog(null,(player[playTurn].getFrozenTurn()+1)+"�����Ҵ٤Ф�");
					}
				} else { //��������
					dice.rollDice();
					gamePlayAction();
				}

				//playTurn++; //������������
				toggleButton();
			} 
			else if(obj==btnReset) {
				//else if( obj == btnNext ) {
				playTurn++;
				if(playTurn==playMax) playTurn=0;
				toggleButton();
				updateInfo();
				repaint();



			}

			if(obj == btnTest) { //�׽�Ʈ��ư

				chkBalance();

				/*//â����׽�Ʈ
				JFrame frame = new JFrame("��ȣȫ ���Ϳ�");
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				//frame.setPreferredSize(new Dimension(400,300));
				int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
				int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
				frame.setLocation(x,y);

				//SmallPanel smallP = new SmallPanel(this); //�����ʸ� �޴¹���
				frame.getContentPane().add(smallP);
				frame.pack();
				frame.setVisible(true);
				 */

				/*
				JFrame frm = new JFrame(title);
				frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				int x = (int) ((dimension.getWidth() - frm.getWidth()) / 2);
				int y = (int) ((dimension.getHeight() - frm.getHeight()) / 2);
				frm.setLocation(x,y);
				 */

			} //if obj == btnTest


			/*
			if(bFlag)
			{
				//buyDialog(20);
				if(playTurn == playMax) playTurn=0;
			}
			 */

		}// actionPerformed

	} // gameListener

	private class MenuMouseListener implements MouseListener
	{
		public void mouseClicked(MouseEvent event) {}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}

		public void mouseEntered(MouseEvent event) {

			//JButton obj = (JButton)event.getSource();
			//obj.setBackground(Color.yellow);
			//obj.setForeground(Color.red);



			if(btnRoll.isEnabled() == true ) {
				ImageIcon RollIcon = new ImageIcon("diebtn_2.png");
				btnRoll.setIcon(RollIcon);
			} else {
				ImageIcon ResetIcon2 = new ImageIcon("resetbtn2.png");
				btnReset.setIcon(ResetIcon2);
			}


		} // mouseEntered()
		public void mouseExited(MouseEvent event) {
			//JButton obj = (JButton)event.getSource();
			//obj.setBackground(Color.white);
			//obj.setForeground(Color.blue);

			ImageIcon RollIcon = new ImageIcon("diebtn_1.png");
			btnRoll.setIcon(RollIcon);
			ImageIcon ResetIcon2 = new ImageIcon("resetbtn.png");
			btnReset.setIcon(ResetIcon2);


		} // mouseExited()
	} // MenuMouseListener class



	private void CharInit() 
	{
		//player1�̸� 
		lblNowPlayer1 = new JLabel("Player1:");
		lblNowPlayer1.setFont(new Font("Cooper Std Black",Font.PLAIN,20));
		lblNowPlayer1.setBounds(landWidth+15,5,200,100);
		add(lblNowPlayer1);

		///Player2 �̸� 
		lblNowPlayer2 = new JLabel("Player2: ");
		lblNowPlayer2.setFont(new Font("Cooper Std Black",Font.PLAIN,20));
		lblNowPlayer2.setBounds(landWidth+215,5,200,100);
		add(lblNowPlayer2);
	}
	private void PlayerCharInit()
	{
		//player1 �̹��� ����
		image=(int)(Math.random()*6)+1;
		if(image==1){
			ImageIcon playerImage=new ImageIcon("muji.png");
			lblPlayer1Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer1Image.setBounds(landWidth+15,410,180,240);
			lblPlayer1Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer1Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer1.setText("Player1: MUJI");
			add(lblPlayer1Image);
			playerIconName[0]="muji2.png";
			//player[0].setPlayerImage(icon);

		}
		else if(image==2){
			ImageIcon playerImage=new ImageIcon("jaz.png");
			lblPlayer1Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer1Image.setBounds(landWidth+15,410,180,240);
			lblPlayer1Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer1Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer1.setText("Player1: JAZ");
			add(lblPlayer1Image);
			playerIconName[0]="jaz2.png";
		}
		else if(image==3){
			ImageIcon playerImage=new ImageIcon("neo.png");
			lblPlayer1Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer1Image.setBounds(landWidth+15,410,180,240);
			lblPlayer1Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer1Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer1.setText("Player1: NEO");
			add(lblPlayer1Image);
			playerIconName[0]="neo2.png";
		}
		else if(image==4){
			ImageIcon playerImage=new ImageIcon("apeach.png");
			lblPlayer1Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer1Image.setBounds(landWidth+15,410,180,240);
			lblPlayer1Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer1Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer1.setText("Player1: APEACH");
			add(lblPlayer1Image);
			playerIconName[0]="apeach2.png";
		}
		else if(image==5){
			ImageIcon playerImage=new ImageIcon("prodo.png");
			lblPlayer1Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer1Image.setBounds(landWidth+15,410,170,240);
			lblPlayer1Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer1Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer1.setText("Player1: PRODO");
			add(lblPlayer1Image);
			playerIconName[0]="prodo2.png";
		}
		else{
			ImageIcon playerImage=new ImageIcon("tube.png");
			lblPlayer1Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer1Image.setBounds(landWidth+15,410,180,240);
			lblPlayer1Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer1Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer1.setText("Player1: TUBE");
			add(lblPlayer1Image);
			playerIconName[0]="tube2.png";
		}

		//player2 �̹����� ���� 
		image=(int)(Math.random()*6)+1;
		if(image==1){
			ImageIcon playerImage=new ImageIcon("muji.png");
			lblPlayer2Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer2Image.setBounds(landWidth+215,400,180,240);
			lblPlayer2Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer2Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer2.setText("Player2: MUJI");
			add(lblPlayer2Image);
			playerIconName[1]="muji2.png";
		}
		else if(image==2){
			ImageIcon playerImage=new ImageIcon("jaz.png");
			lblPlayer2Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer2Image.setBounds(landWidth+215,410,170,240);
			lblPlayer2Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer2Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer2.setText("Player2: JAZ");
			add(lblPlayer2Image);
			playerIconName[1]="jaz2.png";
		}
		else if(image==3){
			ImageIcon playerImage=new ImageIcon("neo.png");
			lblPlayer2Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer2Image.setBounds(landWidth+215,410,180,240);
			lblPlayer2Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer2Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer2.setText("Player2: NEO");
			add(lblPlayer2Image);
			playerIconName[1]="neo2.png";
		}
		else if(image==4){
			ImageIcon playerImage=new ImageIcon("apeach.png");
			lblPlayer2Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer2Image.setBounds(landWidth+215,410,180,240);
			lblPlayer2Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer2Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer2.setText("Player2: APEACH");
			add(lblPlayer2Image);
			playerIconName[1]="apeach2.png";
		}
		else if(image==5){
			ImageIcon playerImage=new ImageIcon("prodo.png");
			lblPlayer2Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer2Image.setBounds(landWidth+215,410,180,240);
			lblPlayer2Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer2Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer2.setText("Player2: PRODO");
			add(lblPlayer2Image);
			playerIconName[1]="prodo2.png";
		}
		else{
			ImageIcon playerImage=new ImageIcon("tube.png");
			lblPlayer2Image=new JLabel("",playerImage,SwingConstants.CENTER);
			lblPlayer2Image.setBounds(landWidth+215,410,180,240);
			lblPlayer2Image.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayer2Image.setVerticalAlignment(SwingConstants.CENTER);
			lblNowPlayer2.setText("Player2: TUBE");
			add(lblPlayer2Image);
			playerIconName[1]="tube2.png";
		}
	} // PlayerCharInit()


	public void updateInfo() {

		lblTestPlayerNum.setText("Player : "+(playTurn+1) );
		for(int i=0 ; i<playMax ;i++) {
			this.lblPlayerMoney[i].setText("Money : "+ player[i].getPlayerMoney()  );
		}
		////////���Զ� ���

		for(int i=0; i<32; i++) {
			if(landBuyArr[0][i]==1) {
				landPanel[i].lblLand[i].setVisible(false);
				landPanel[i].lblOwn[0][getOwnNum(i)].setVisible(true);
			}
			if(landBuyArr[1][i]==1) {
				landPanel[i].lblLand[i].setVisible(false);
				landPanel[i].lblOwn[1][getOwnNum(i)].setVisible(true);
			}
		}
		player[playTurn].getPlayerPiece().setVisible(false);
		player[playTurn].getPlayerPiece().setVisible(true);
		
		chkBalance(); // ����üũ
	}
	
	public void aEventMoney(int num){
		player[playTurn].setPlayerMoney(player[playTurn].getPlayerMoney()+200);
	} //�̺�Ʈ ȿ��
	public void mEventMoney(int num){
		player[playTurn].setPlayerMoney(player[playTurn].getPlayerMoney()-200);
	} //�̺�Ʈ ȿ��


	public void collectToll(int n) {
		String landOwner = landPanel[ n ].getOwner();

		player[playTurn].setPlayerMoney( // ����� =  (����*�ǹ�����)�� 20%
				(int)(player[playTurn].getPlayerMoney() 
						-  
						(LandConstants.LAND_PRICE[ n  ] 
								* landPanel[player[playTurn].getPlayerPosition()].getBuildingLvl())
						*0.2  )	);

		for(int i=0 ; i<playMax ; i++) { //����ã��
			if(player[i].getPlayerNum() == landOwner) {
				player[i].setPlayerMoney(
						(int)( player[i].getPlayerMoney()
								+
								(LandConstants.LAND_PRICE[ n ] 
										* landPanel[player[playTurn].getPlayerPosition()].getBuildingLvl() )
								*0.2  )  );

			} //if
		} //for


	} //collectToll


	public void showSmallFrame(int n) {

		if(n!=0 && n!=4 && n!=8 && n!=12 && n!=16 && n!=20 && n!=24 && n!=28 )
		{
			JFrame frame = new JFrame("��ȣȫ ���Ϳ�");
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			//frame.setPreferredSize(new Dimension(400,300));
			int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
			int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
			frame.setLocation(x,y);
			frame.setResizable(false);

			//SmallPanel smallP = new SmallPanel(this); //�����ʸ� �޴¹���
			smallP.updateSign();
			frame.getContentPane().add(smallP);
			frame.pack();
			frame.setVisible(true);
			//frame.setVisible(false);
			smallP.setFrame(frame);
			if(escapeFrame==true) {
				frame.dispose();
				escapeFrame=false;
			}
		}
		else if(n==4) {
			JOptionPane.showMessageDialog(null, LandConstants.NAME[n]+"�� �����մϴ�.");
			LuckyGamePanel.setVisible(true);
			LuckyGamePanel.start();
			//player[playTurn].setPlayerMoney(player[playTurn].getPlayerMoney()+200);
			//miniGameMoney(num1);
			//num = LuckyGamePanel.rightResult();
			//int a = 0;
			//LuckyGamePanel.getResult();
			if(LuckyGamePanel.resultNumber==1){
				player[playTurn].setPlayerMoney(player[playTurn].getPlayerMoney()+200);
			}
			
		} // �̴ϰ���1
		else if(n==20){
			JOptionPane.showMessageDialog(null, LandConstants.NAME[n]+"�� �����մϴ�.");
			OddEvenGamePanel.setVisible(true);
			//OddEvenGamePanel.start();
			aEventMoney(num);
			//OddEvenGamePanel.getResult();
			if(OddEvenGamePanel.getResult() ==1){
				aEventMoney(num);
			}
		} //�̴ϰ���2
		else if(n==8){  //8,16,24 �̺�Ʈ��
			Event.setVisible(true);
			Event.hwResult();
			mEventMoney(num);
			} 
		else if(n==16) {
				Event.setVisible(true);
				Event.festResult();
				aEventMoney(num);
			} 	
		else if(n==24){
				Event.setVisible(true);
				Event.freeResult();
				aEventMoney(num);
			}
			// �̺�Ʈ �г�
		else if(n==12 ) { //ī���̺�Ʈ
			ad.setVisible(true);
			ad.start();
			String result = "����ī��!";
			JOptionPane.showMessageDialog(null,result);
			
			/*int result = JOptionPane.showConfirmDialog(null, LandConstants.NAME[n]);
			
			switch(result) 
			{
			case JOptionPane.YES_OPTION :
				break;
			case JOptionPane.NO_OPTION :
				break;

			}*/}
		else if(n==28 ) {// ī���̺�Ʈ
			p.setVisible(true);
			p.start();
			String result = "�г�Ƽī��!";
			JOptionPane.showMessageDialog(null,result);
			/*int result = JOptionPane.showConfirmDialog(null, LandConstants.NAME[n]);
				switch(result) 
				{
				case JOptionPane.YES_OPTION :
					break;
				case JOptionPane.NO_OPTION :
					break;

				}*/
		} // ����ī��, ����ī��




	}




	public void gamePlayAction() {

		player[playTurn].updatePlayerPosition( dice.getBigDice() ); // ������ġ+�ֻ��������� ��ġ����

		//player[playTurn].getPlayerPiece().setBounds(10,10,53,72); //��ǥ��
		if(playTurn == 0) {
			player[playTurn].getPlayerPiece().setBounds(10,15,53,72); //��ǥ��
		} else {
			player[playTurn].getPlayerPiece().setBounds(50,15,53,72); //��ǥ��
		}

		//��ǥ��
		int testNum = player[playTurn].getPlayerPosition(); //����ġ���庯��
		landPanel[testNum].lblLand[testNum].add(player[playTurn].getPlayerPiece() );


		lblDie1.setText(""+dice.getDice1() );
		lblDie2.setText(""+dice.getDice2() );
		lblTestPlayerPos.setText(""+player[playTurn].getPlayerPosition());
		repaint();

		////����
		if( landPanel[player[playTurn].getPlayerPosition()].getOwner()=="" ) { //����x
			//if(   landBuyArr[ playTurn ][ player[playTurn].getPlayerPosition() ] == 0  ) {
			//buyDialog( player[playTurn].getPlayerPosition() );
			showSmallFrame(player[playTurn].getPlayerPosition());

		} else if(landPanel[player[playTurn].getPlayerPosition()].getOwner() == player[playTurn].getPlayerNum() ) {
			//�߰��Ұ� �ڱⶥ�� ������ �ǹ��ø���
			//buildDialog( player[playTurn].getPlayerPosition() );
			//repaint();
		} else { //���Ƕ�
			collectToll(player[playTurn].getPlayerPosition());
			JOptionPane.showMessageDialog(null, LandConstants.NAME[player[playTurn].getPlayerPosition()]+"���� ����Ḧ �´�.\n"+
					(int)( LandConstants.LAND_PRICE[ player[playTurn].getPlayerPosition()  ] 
							* landPanel[player[playTurn].getPlayerPosition()].getBuildingLvl() 
							*0.2 ) +"�� ");
			repaint();
		}

	
		if(player[playTurn].getPlayerPosition() == 8) {
			JOptionPane.showMessageDialog(null,"������ ����ּ���̤�");
			player[playTurn].setFrozenTurn(2); 
			Event.setVisible(false);
			Event.Reset();
		} //�̺�Ʈ�� ȿ��
		
		if(player[playTurn].getPlayerPosition() == 16) {
			JOptionPane.showMessageDialog(null,"������!");
			Event.setVisible(false);
			Event.Reset();
		} //�̺�Ʈ�� ȿ��
		if(player[playTurn].getPlayerPosition() == 24) {
			JOptionPane.showMessageDialog(null,"�����ð�!");
			Event.setVisible(false);
			Event.Reset();
		} //�̺�Ʈ�� ȿ��
		updateInfo();
		repaint();

	} //gamePlayAction




}
