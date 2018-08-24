package monopoly_1;

import javax.swing.*;

public class MonopolyExam {

	public static void main(String[] args) {
		JFrame frame = new JFrame("User Defined Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//MonopolyPanel Mpanel = new MonopolyPanel();
		InitialPanel Mpanel = new InitialPanel();
		
		frame.getContentPane().add(Mpanel);
		frame.pack();
		frame.setVisible(true);
	}
}
