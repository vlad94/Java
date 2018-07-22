package targovci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import targovci.Supplier.Product;

public class Chain extends Merchant{

	private ArrayList<Supplier> suppliers;
	private ArrayList<ShoppingCentre> shops;
	
	public Chain(String name, double capital) {
		super(name, capital);
		suppliers = new ArrayList<>();
		shops = new ArrayList<>();
	}
	
	public void addSupplier(Supplier s) {
		if(suppliers.size() < 15){
			suppliers.add(s);
		}
		else{
			System.out.println("Sorry, Maximum suppliers!");
		}
	}
	
	public void addShop(ShoppingCentre sc) {
		if((shops.size() < 10) && (sc instanceof Pavilion || sc instanceof MallStand)){
			shops.add(sc);
		}

	}
	
	
	public void makeOrder(Supplier sup, double order, ShoppingCentre sc) {
		if(0.5*getCapital() < order){
			System.out.println("You don't have enough capital for this order");
		}else{
			if(sup instanceof BigSupplier){
				double discount = 0.15*order;
				setCapital(getCapital() + discount);
			}
			setCapital(getCapital() - order);
			while(order>0){	
				//I add random products from the Enum in the current ShoppingCentre until the money are gone
				int rand = new Random().nextInt(Product.values().length);
				sc.addProduct(Product.values()[rand]);
				int price = Product.values()[rand].getPrice();
				order -= price;
			}
		}
	}
	
	public List<ShoppingCentre> getShops() {
		return Collections.unmodifiableList(shops);
	}
	
	public List<Supplier> getSuppliers() {
		return Collections.unmodifiableList(suppliers);
	}

	@Override
	public void payTaxes() {
		for(ShoppingCentre sc : shops){
			if(sc instanceof MallStand){
				setCapital(getCapital() - 150);
			}else{
				setCapital(getCapital() - 50);
			}
		}
		
	}
}
