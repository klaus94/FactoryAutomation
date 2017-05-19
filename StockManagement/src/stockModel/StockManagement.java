package stockModel;

import java.util.ArrayList;
import java.util.List;

import stockManagement.IStockManagement;
import stockManagement.Product;

public class StockManagement implements IStockManagement {

	private List<Product> products;
	
	public StockManagement() {
		products = new ArrayList<>();
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public boolean addProduct(Product p) {
		if(!p.isReady())
			return false;
		
		products.add(p);
		return true;
	}
	
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
	public Product findById(int id) {
		for(Product p : products) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}
	
}
