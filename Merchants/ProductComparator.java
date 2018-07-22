package targovci;

import java.util.Comparator;

import targovci.Supplier.Product;

public class ProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p1.getPrice() - p2.getPrice();
	}
	
}
