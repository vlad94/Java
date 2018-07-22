package targovci;

import java.util.ArrayList;
import java.util.Random;

import targovci.Supplier.Product;

public class Ambulant extends Merchant{
	
	private SmallSupplier smallsup;
	private ArrayList<Product> products;

	public Ambulant(String name, double capital) {
		super(name, capital);
		products = new ArrayList<>();	
	}
	
	public void setSmallsup(SmallSupplier smallsup) {
		this.smallsup = smallsup;
	}
	
	public void makeOrder(double order) {
		if(0.5*getCapital() < order){
			System.out.println("You don't have enough capital for this order");
		}else{
			setCapital(getCapital() - order);
			while(order>0){	
				//I add random products from the Enum until the money are gone
				int rand = new Random().nextInt(Product.values().length);
				products.add(Product.values()[rand]);
				int price = Product.values()[rand].getPrice();
				order -= price;
			}
		}
	}
	
	public void showProducts() {
		System.out.print(this.getName() + " ima ");
		for(Product p : products){
			System.out.print(p + ", ");
		}
		System.out.println();
	}

	@Override
	public void payTaxes() {
		System.out.println("I don't pay taxes");
	}

}
