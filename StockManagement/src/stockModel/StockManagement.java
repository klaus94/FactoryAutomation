package stockModel;

import java.util.ArrayList;
import java.util.List;

import stockManagement.IStockManagement;
import stockManagement.Product;

public class StockManagement implements IStockManagement {

	private List<Product> products;
	
	public StockManagement() {
		output("Stock Manager created");
		products = new ArrayList<>();
	}

	public List<Product> getProducts() {
		output("getProducts");
		return products;
	}
	
	public boolean addProduct(Product p) {
		output("add Product");
		if(!p.isReady())
			return false;
		
		products.add(p);
		return true;
	}
	
	public void removeProduct(Product p) {
		output("remove Product");
		products.remove(p);
	}
	
	public Product findById(int id) {
		for(Product p : products) {
			if(p.getId() == id) {
				output("find Product by ID " + id + ": found");
				return p;
			}
		}
		output("find Product by ID " + id + ": none");
		return null;
	}
	
	private void output(String message) {
		System.out.println("SM: " + message);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
