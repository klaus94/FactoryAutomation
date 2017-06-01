package productionManagement;

import crm.Order;
import stockManagement.Product;

public interface IProductionManagement {
	Product ProduceProduct(Order order);
}
