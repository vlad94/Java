package targovci;

import java.util.ArrayList;
import java.util.Random;

import targovci.Supplier.Product;

public class SoleTrader extends Merchant{

	private ArrayList<SmallSupplier> smallsups;
	private ShoppingCentre shop;
	
	public SoleTrader(String name, double capital) {
		super(name,capital);
		smallsups = new ArrayList<>();
	}
	
	public void addSupplier(SmallSupplier sup) {
		if(smallsups.size() < 5){
			smallsups.add(sup);
		}
		else{
			System.out.println("Maximum suppliers");
		}
	}
	
	public void setShop(ShoppingCentre shop) {
		if(shop instanceof Stand || shop instanceof Pavilion){
			this.shop = shop;
		}
	}
	
	public void makeOrder(Supplier sup, double order) {
		if(0.5*getCapital() < order){
			System.out.println("You don't have enough capital for this order");
		}else{
			setCapital(getCapital() - order);
			while(order>0){	
				//I add random products from the Enum in my ONLY shop until the money are gone
				int rand = new Random().nextInt(Product.values().length);
				this.shop.addProduct(Product.values()[rand]);
				int price = Product.values()[rand].getPrice();
				order -= price;
			}
		}
	}
	
	public ShoppingCentre getShop() {
		return shop;
	}
	
	public ArrayList<SmallSupplier> getSmallsups() {
		return smallsups;
	}

	@Override
	public void payTaxes() {
		setCapital(this.getCapital() - 50);	
	}
}
