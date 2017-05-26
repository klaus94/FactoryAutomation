package stockManagement;

import java.util.List;

public interface IStockManagement {

	List<Product> getProducts();
	
	boolean addProduct(Product p);
	
	void removeProduct(Product p);
	
	Product findById(int id);
}
