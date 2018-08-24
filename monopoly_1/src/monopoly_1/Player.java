package monopoly_1;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Player extends JPanel implements Runnable {
	private JLabel playerPiece; //말
	
	private Point playerPos; //패널상위치
	private int playerMoney;
	private int playerPrevPosition, playerPosition; //배열인덱스
	private String playerNum; //P1,P2,P
	private int frozenTurn;
	private Thread pieceThread;
	private MonopolyPanel copied;
	
	public Player(int i) {
		
		playerPiece = new JLabel();
		playerPiece.setPreferredSize(new Dimension(53,72));  //30,30
		playerNum="P"+(i+1);
		
		playerMoney=2000000;//1250;
		playerPos = new Point();
		playerPos.x=65;
		playerPos.y=65;
		playerPrevPosition=playerPosition=0;
		frozenTurn = 0;
		
		pieceThread = null;
		
		setLayout(null);
	}
	
	
	// get set
	public Point getPoint() { return playerPos; }
	public int getPointX() { return playerPos.x; }
	public int getPointY() { return playerPos.y; }
	public int getPlayerMoney() { return playerMoney; }
	public int getPlayerPrevPosition() { return playerPrevPosition; }
	public int getPlayerPosition() { return playerPosition; }
	public JLabel getPlayerPiece() { return playerPiece; }
	public String getPlayerNum() { return playerNum; }
	public int getFrozenTurn() { return frozenTurn; }
	
	public void setPoint(Point ptr) { playerPos=ptr; }
	public void setPointX(int x) { playerPos.x=x; }
	public void setPointY(int y) { playerPos.y=y; }
	public void setPlayerMoney(int value) { playerMoney=value; }
	public void setPlayerPrevPosition(int value) { playerPrevPosition = value; }
	public void setPlayerPosition(int value) { playerPosition = value; }
	public void setPlayerNum(String str) { playerNum=str; }
	public void setFrozenTurn(int value) { frozenTurn = value; }
	public void setMonopolyPanel(MonopolyPanel panel) { copied=panel; }
	
	
	
	
	
	////other
	public void updatePlayerPosition(int value) {
		int newPosition=playerPosition+value;
		if(newPosition>31) {
			newPosition-=32;
			playerMoney+=320000; //출발지통과
		}
		playerPosition=newPosition;
		
	}//updatePlayerPosition
	
	public void updatePlayerPosition2(int value) {
		playerPrevPosition=playerPosition; //위치갱신
		int newPosition=playerPosition+value;
		if(newPosition>31) {
			newPosition-=32;
			playerMoney+=320000; //출발지통과
		}
		playerPosition=newPosition;
		
	}//updatePlayerPosition2

	public void setPlayerImage(String str) {
		ImageIcon pieceIcon=new ImageIcon(str);
		playerPiece = new JLabel("",pieceIcon,SwingConstants.CENTER);
		playerPiece.setPreferredSize(new Dimension(53,72));  //30,30
		
	}
	
	public void start() { //numberThread가 null일때 새로 객체를 생성하고 작동을 시켜주는 메소드
		if (pieceThread==null) {
			pieceThread= new Thread(this);
		}
		pieceThread.start();

	} // start


	public void stop() { //스레드의 실행을중단할때
		if(pieceThread != null) pieceThread.stop();

	} // stop()
	
	
	
	public void run() {
		try {
			pieceThread.sleep(500);
			//for(int i=0 ; playerPositon== ; i++) {
				
			//	playerPosition++;
			//	copied.updateInfo();
			//}
		} catch(Exception e) {}
		
		
		/*
		try {
			for(int i= startNumber ; i<=finishNumber; i++) {
				setText(""+i);//설정된 delayTime만큼의 간격으로 숫자를 순차적으로 startNumber부터 finishNumber까지 출력한다
				numberThread.sleep(delayTime); //딜레이만큼 스레드쉼
			}// for

			setForeground(Color.red); //정답을맞춘 난수의 숫자를 50ms간격으로 붉게 꺼졌다 켜졌다 10번반복하는 효과를준다
			for(int i=0;i<10;i++) {
				setVisible(false);
				numberThread.sleep(50);
				setVisible(true);
				numberThread.sleep(50);	
				
			}// for
			primary.continueGame();
			this.itIsTimeToPopUpContinue=true; //모든 깜빡임이 끝난후 메뉴를 출력,미사용
		} catch(Exception e) {}  //try&catch = exception handling 
		
		
	*/	
		
	} // run
	
	
	
}




