package targovci;

public abstract class Supplier {

	public enum Product {
		Banana (5), Gun(15), Rice(7), Shirt(11), Cream(9), Brush(10), Glass(8), Table(11), Cigarette(12);
		
		private final int price;
		Product(int price){
			this.price = price;
		}
		
		public int getPrice() {
			return price;
		}
	}
	
	private String name;
	private String address;
	private String workHours;
	
	public Supplier(String name) {
		setName(name);
	}

	public void setName(String name) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		else{
			this.name = "Default";
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}

