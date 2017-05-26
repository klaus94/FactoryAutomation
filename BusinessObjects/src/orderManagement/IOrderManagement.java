package orderManagement;

import java.util.List;

import crm.Customer;
import crm.Order;

public interface IOrderManagement {
	List<Order> getAllOrders();
	
	Order findById(int id);
	
	void addOrder(Order o, Customer c);
	
}
