package targovci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import targovci.Supplier.Product;

public abstract class ShoppingCentre {

	private String address;
	private String workHours;
	private int area;
	private double tax;
	private ArrayList<Product> inventar;
	
	public ShoppingCentre(int area, double tax) {
		setArea(area);
		setTax(tax);
		inventar = new ArrayList<>();
	}
	
	public void setArea(int area) {
		if(area>0){
			this.area = area;
		}
		else{
			this.area = 2;
		}
	}
	
	public void setTax(double tax) {
		if(tax>0){
			this.tax = tax;
		}
		else{
			this.tax = 50;
		}
	}
	
	public void addProduct(Product p) {
		this.inventar.add(p);
	}
	
	public List<Product> getInventar() {
		//TODO sort them by price
		Collections.sort(inventar, new ProductComparator());
		return Collections.unmodifiableList(inventar);
	}
	
	@Override
	public String toString() {
		if(this instanceof Stand){
			return "Stand";
		}else if(this instanceof MallStand){
			return "MallStand";
		}else{
			return "Pavilion";
		}
	}
}
