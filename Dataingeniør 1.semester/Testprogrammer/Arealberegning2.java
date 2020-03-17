/**
* Arealberegning2.java Programmet beregner arealet av et rektangel. */
import java.util.*;

class Arealberegning2 {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Lengde (meter): ");
	double lengde = in.nextDouble();
	
	System.out.println("Bredde (meter): ");
	double bredde = in.nextDouble();
	
	double arealet = lengde * bredde;
	
	System.out.println("Arealet av rektangelet er " + arealet + " km2.");
	System.out.printf( "Arealet av rektangelet er %8.2f km2.", arealet);
	}
}