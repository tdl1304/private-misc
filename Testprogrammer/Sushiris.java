import java.util.Scanner;
public class Sushiris {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Hvor mye ris(Liter og ukokt)?");
		double ris = in.nextDouble();
		
		System.out.printf("%.2f dl edikk %n",getEdikk(ris));
		System.out.printf("%.2f dl sukker %n", getSukker(ris));
		System.out.printf("%.2f SS salt %n", getSalt(ris));
		System.out.printf("%.2f SS ingefærvann %n", getIngeferVann(ris));
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