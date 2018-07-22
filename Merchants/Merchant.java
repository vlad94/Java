package targovci;

public abstract class Merchant {

	private String name;
	private String regAddress;
	private double capital;
	
	public Merchant(String name, double capital) {
		setName(name);
		setCapital(capital);
	}
	
	public abstract void payTaxes();
		
	public void setName(String name) {
		if(!name.isEmpty() && name != null)
			this.name = name;
		else
			this.name = "Unknown";
	}
	
	public void setCapital(double capital) {
		if(capital>0){
			this.capital = capital;
		}
		else{
			capital = 100;
		}
	}

	public double getCapital() {
		return capital;
	}
	
	public String getName() {
		return name;
	}
}
