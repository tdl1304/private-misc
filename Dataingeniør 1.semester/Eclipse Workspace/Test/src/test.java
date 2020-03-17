import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
class test{
	public static void main(String[]args){
		JFrame frame = new JFrame();
		final int exit = frame.EXIT_ON_CLOSE;
		
		//--------------Objekter til GUI-------------
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		//legger til panelet i rammen
		frame.getContentPane().add(panel);
		
		JButton button = new JButton("Hei Verden");
		panel.add(button);
		
		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension(200, 20));
		panel.add(field); 
		//-------------------------------------------
		//Kan se rammen
		frame.setVisible(true);
		//Størrelse
		frame.setSize(new Dimension(640, 400));
		//Muligheter for å lukke
		frame.setDefaultCloseOperation(exit);
		//plassering i midten
		frame.setLocationRelativeTo(null);
		frame.setTitle("Sushi ris kalkulator");
		frame.setResizable(false);
		
		
	
		
	}

}//class


