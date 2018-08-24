package monopoly_1;
public class Dice {
	
	private int Dice1,Dice2,bigDice;
	
	public Dice() {
		Dice1=Dice2=bigDice=0;
	}
	
	public int getDice1() { return Dice1; }
	public int getDice2() { return Dice2; }
	public int getBigDice() { return bigDice; }
	
	public int rollDice() {
		Dice1 = (int)(Math.random()*6)+1;
		Dice2 = (int)(Math.random()*6)+1;
		bigDice=Dice1+Dice2;
		return bigDice;
	}
	
	
}
