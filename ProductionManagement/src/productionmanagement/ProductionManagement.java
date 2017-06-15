package productionmanagement;

import crm.Order;
import productionManagement.IProductionManagement;
import stockManagement.Product;

public class ProductionManagement implements IProductionManagement{

	@Override
	public Product ProduceProduct(Order order) {
		// TODO Auto-generated method stub

		return new Product(order.getId(), "name=" + order.getTitle());
	}

	@Override
	public String getTest()
	{
		return "test";
	}

}
