import java.util.Random;
public class MinRandom {
	
	private Random numGen;
	
	public MinRandom() {
		this.numGen = new Random();
	}
	
	public int nesteHeltall(int nedre, int ovre) {
		int tilfeldigHeltall;
		tilfeldigHeltall = numGen.nextInt(ovre-nedre+1) + nedre;
		return tilfeldigHeltall;
		
	}
	
	public double nesteDesimaltall(double nedre, double ovre) {
		double tilfeldigDesimaltall;
		tilfeldigDesimaltall = nedre + numGen.nextDouble() * (ovre - nedre);
		return tilfeldigDesimaltall;
	}
	
} //class
