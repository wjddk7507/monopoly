package monopoly_1;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class LandPanel extends JPanel{

	private int mX, mY, width, height;
	private ImageIcon landImg;
	public JLabel[][] lblOwn;
	public JLabel[] lblLand;
	private String owner;
	//private int buildingLvl[]={0,0,0,0}; //땅 집1 집2 집3
	private int buildingLvl; //0 없음, 1 토지만구입 , 2 건물+1, 3 건물렙+2, 4건물랩+3  
	
	public LandPanel(int n, int x, int y, int w, int h) {
		mX = x; mY = y; width = w; height = h;
		setPreferredSize(new Dimension(width, height));
		setBounds(mX, mY, width, height);
		setBackground(Color.white);
		setLayout(null);
		
		lblLand = new JLabel[32];
		lblOwn = new JLabel[2][8];
		owner="";
		buildingLvl=0;
	

		// 경계선 그리기
		if(n>0 && n<9) setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
		if(n>=9 && n<17) setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
		if(n>=17 && n<25) setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		if(n>=25 && n<32) setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
		if(n==0) setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
		
		
		landImg = new ImageIcon("D:\\workspace\\monopoly_1124 revi7\\"+LandConstants.NAME[n]+".png");
		//landImg = new ImageIcon("C:\\workspace\\monopoly_1124\\"+LandConstants.NAME[n]+".png");
		//landImg = new ImageIcon("C:\\workspace\\monopoly_1124 revi7\\"+LandConstants.NAME[n]+".png");
		lblLand[n] = new JLabel(landImg);
		
		// 위치
		if(n==0) { lblLand[n].setBounds(1, 1, 129, 129); }
		if(n>0 && n<8 && n!=4) { lblLand[n].setBounds(0, 1, 129, 99); }
		if(n==4) { lblLand[n].setBounds(0, 1, 129, 99); }		
		if(n==8) { lblLand[n].setBounds(0, 1, 129, 129); }
		if(n>8 && n<16 && n!=12) { lblLand[n].setBounds(0, 0, 99, 129); }
		if(n==12) { lblLand[n].setBounds(0, 0, 99, 129); }
		if(n==16) { lblLand[n].setBounds(0, 0, 129, 129); }
		if(n>16 && n<24 && n!=20) { lblLand[n].setBounds(1, 0, 129, 99); }
		if(n==24) { lblLand[n].setBounds(1, 0, 128, 129); }
		if(n==20) { lblLand[n].setBounds(1, 0, 129, 99); }
		if(n>24 && n<32 && n!=28) { lblLand[n].setBounds(1, 1, 99, 129); }
		if(n==28) { lblLand[n].setBounds(1, 1, 99, 129); }
		
		add(lblLand[n]);
		
		init_lblOwn();
		
	}	
	
	public int getBuildingLvl() { return buildingLvl; }
	public String getOwner() { return owner; }
	public void setOwner(String name) { owner=name; } 
	public void setBuildingLvl(int value) { buildingLvl = value; }
	
	
	public void init_lblOwn() {
		// 땅을 소유했을 시에 lblOwn으로 땅 소유자를 표시함
			for(int i=0; i<8; i++) {
				String str="";
				int lx,ly,lw,lh;
				lx=ly=lw=lh=0;
				// 0~7 = 각구역
				if(i==0) { str = "green"; lx=50; ly=1; lw=79; lh=99; }
				else if(i==1) { str = "blue"; lx=50; ly=1; lw=79; lh=99; }
				else if(i==2) { str = "brown"; lx=0; ly=50; lw=99; lh=79; }
				else if(i==3) { str = "sky"; lx=0; ly=50; lw=99; lh=79; }
				else if(i==4) { str = "pink"; lx=1; ly=0; lw=79; lh=99; }
				else if(i==5) { str = "orange"; lx=1; ly=0; lw=79; lh=99; }
				else if(i==6) { str = "red"; lx=1; ly=1; lw=99; lh=79; }
				else if(i==7) { str = "yellow"; lx=1; ly=1; lw=99; lh=79; }
				
				
				
				lblOwn[0][i] = new JLabel(new ImageIcon(str+"1.png")); //green1.png
				lblOwn[0][i].setBounds(lx, ly, lw, lh);
				add(lblOwn[0][i]);
				lblOwn[0][i].setVisible(false);
				
				lblOwn[1][i] = new JLabel(new ImageIcon(str+"2.png"));
				lblOwn[1][i].setBounds(lx, ly, lw, lh);
				add(lblOwn[1][i]);
				lblOwn[1][i].setVisible(false);
			}
	} // init_lblOwn()
	
	
	
	
	
}
