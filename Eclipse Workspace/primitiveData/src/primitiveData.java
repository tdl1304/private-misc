import java.util.Random;
public class primitiveData{
	public static void main(String[]args){
		numGen dice1 = new numGen();
    	int poengScore[] = new int[10];
    	int runder = 5000;
    	
    	for(int i = 0; i<=runder; i++) {
    		poengScore[dice1.tilfeldigTall()]++;
    	}
    		
    	for(int j = 0; j < poengScore.length; j++) {
    		System.out.println(j+": "+poengScore[j]+" ");
    		
    		for(int i = 0; i<poengScore[j]/10; i++) {
    			System.out.print("*");
    		}
    		
    		System.out.printf("%n");
    	}
    	
      }//main

}//class



class numGen {
	private Random numGen;
	
	public numGen() {
		this.numGen = new Random();
	}
	
	public int tilfeldigTall() {
		return numGen.nextInt(10);
	}
}

