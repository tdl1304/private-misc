public class Objectsnclasses {
	public static void main(String[] args) {
		Robot r1 = 
			new Robot("PJ", 30);
		Robot r2 = 
			new Robot("AJ", 40);
		Robot r3 = 
			new Robot("JJ", 50);

		r1.linkedto = r2;
		r2.linkedto = r3;
		r3.linkedto = r1;

		r1.introduction(); r1.linkedto.linked();
		r2.introduction(); r2.linkedto.linked();
		r3.introduction(); r3.linkedto.linked();
		
		for(int i=13; i <14; i++ ) {
			for(int j=4; j <= 10; j++) {
				System.out.printf(
					i+" * "+j+" = "+j*i+"%n");
			}
		
		}
		
		for(int i = 13+1; i <= 15-1; i++) {
			for(int j=1; j <= 10; j++) {
				System.out.printf(
					i+" * "+j+" = "+j*i+"%n");
			}
		}
		
		for(int i = 15; i <= 15; i++) {
			for(int j=1; j <= 8; j++) {
				System.out.printf(
					i+" * "+j+" = "+j*i+"%n");
			}
		}
		
		
	}
}

class Robot {
	String name;
	int weight;
	Robot linkedto;
	
	Robot(String n1, int n2) {
		this.name = n1;
		this.weight = n2;
	}
	
	void introduction() {
		System.out.println(
			"My name is "+this.name+" and my weight is "+this.weight);
	}
	void linked() {
		System.out.println(
			"I am linked to "+this.name);
		
	}
	
}
	



	
