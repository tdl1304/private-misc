public class RandomNumGen {
	public static void main(String[] args) {
		MinRandom nummerGenerator = new MinRandom();
		int i = 0;
		int j = 0;
		
		do {
			int tilfeldigHeltall = nummerGenerator.nesteHeltall(10, 15);
			System.out.println(tilfeldigHeltall);
			i++;
		} while (i<=1);
		
		
		do {
			double tilfeldigDesimal = nummerGenerator.nesteDesimaltall(0.3,0.5);
			System.out.println(tilfeldigDesimal);	
			j++;
		} while (j<=1);
		
	}//main
}//class
