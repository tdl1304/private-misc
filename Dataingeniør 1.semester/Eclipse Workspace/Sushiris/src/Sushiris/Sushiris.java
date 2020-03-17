
package Sushiris;
import javax.swing.JOptionPane;
public class Sushiris {
	public static void main(String[] args) {
		String risMengde = JOptionPane.showInputDialog(null, "Rismengde(Liter): ", "Sushiris", JOptionPane.QUESTION_MESSAGE);
		double ris = Double.parseDouble(risMengde.replace(",", "."));
		
		JOptionPane.showMessageDialog(null, "Salt: "+getSalt(ris)+" ss"+
		"\nSukker: "+getSukker(ris)+" dl"+
		"\nEdikk: "+getEdikk(ris)+" dl"+
		"\nSyltet ingefærveske: "+getIngeferVann(ris)+" ss","Sushiris",
		JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0);
		
		
	}//main
	
	public static double getSalt(double d) {
		double mengde = d;
		return mengde;
	}
	public static double getSukker(double d) {
		double mengde = d;
		return mengde;
	}
	
	public static double getEdikk(double d) {
		double mengde = d;
		return mengde;
	}
	
	public static double getIngeferVann(double d) {
		return d*2;
	}

}//class
