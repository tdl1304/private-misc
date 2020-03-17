
//regner ut brøker
class Brok {
	private int teller;
	private int nevner;
	
	public Brok(int teller, int nevner) { //
		if (nevner == 0) {
			throw new IllegalArgumentException("Nevner er 0");
		}
		this.teller = teller;
		this.nevner = nevner;
	}
	
	public Brok(int teller) {
		this.teller = teller;
		this.nevner = 1;
	}
	
	public int getTeller() {
		return teller;
	}
	
	public int getNevner() {
		return nevner;
	}

	public void getMulti(Brok b1) {
		int produktTeller = this.teller*b1.getTeller();
		int fellesnevner = this.nevner*b1.getNevner();
		this.teller = produktTeller;
		this.nevner = fellesnevner;
	}
	
	public void getDiv(Brok b1) {
		int divTeller = this.teller*b1.getNevner();
		int divNevner = this.nevner*b1.getTeller();
		this.teller = divTeller;
		this.nevner = divNevner;
	}
	
	public void getSum(Brok b1) {
		int sumTeller = this.teller*b1.getNevner()+b1.getTeller()*this.nevner;
		int fellesnevner = this.nevner*b1.getNevner();
		this.teller = sumTeller;
		this.nevner = fellesnevner;
	}
	
	public void getSub(Brok b1) {
		int sumTeller = this.teller*b1.getNevner()-b1.getTeller()*this.nevner;
		int fellesnevner = this.nevner*b1.getNevner();
		this.teller = sumTeller;
		this.nevner = fellesnevner;
	}
	
	public String toString() {
		return this.teller+"/"+this.nevner;
	}
	
} //class