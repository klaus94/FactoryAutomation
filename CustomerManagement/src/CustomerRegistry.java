
import java.util.ArrayList;
import java.util.List;

import crm.Customer;
import crm.ICustomerManagement;
import crm.ICustomerOrders;
import crm.Order;

public class CustomerRegistry implements ICustomerManagement, ICustomerOrders {
	private List<Customer> customers;
	
	public CustomerRegistry() {
		customers = new ArrayList<>();
	}
	
	@Override
	public void addCustomer(Customer c) {
		customers.add(c);
	}
	
	@Override
	public void removeCustomer(Customer c) {
		customers.remove(c);
	}
	
	@Override
	public Customer findById(int id) {
		for(Customer c : customers) {
			if (c.getId() == id) 
				return c;
		}
		
		return null;
	}

	@Override
	public List<Order> getOrdersFromAllCustomer() {
		List<Order> orders = new ArrayList<>();
		
		for(Customer c : customers ) {
			orders.addAll(c.getOrders());
		}
		
		return orders;
	}

}
