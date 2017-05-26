
import java.util.ArrayList;
import java.util.List;

import crm.Customer;
import crm.ICustomerManagement;
import crm.ICustomerOrders;
import crm.Order;

public class CustomerRegistry implements ICustomerManagement, ICustomerOrders {
	private List<Customer> customers;
	
	public CustomerRegistry() {
		output("Customer Registry created");
		customers = new ArrayList<>();
	}
	
	@Override
	public void addCustomer(Customer c) {
		output("add Customer: " + c.getName());
		customers.add(c);
	}
	
	@Override
	public void removeCustomer(Customer c) {
		output("remove Customer: " + c.getName());
		customers.remove(c);
	}
	
	@Override
	public Customer findById(int id) {
		for(Customer c : customers) {
			if (c.getId() == id){ 
				output("find Customer by ID " + id + ": " + c.getName());
				return c;
			}
		}
		output("find Customer by ID " + id + ": none");
		return null;
	}

	@Override
	public List<Order> getOrdersFromAllCustomer() {
		output("get Orders from all Customer");
		List<Order> orders = new ArrayList<>();
		
		for(Customer c : customers ) {
			orders.addAll(c.getOrders());
		}
		
		return orders;
	}
	
	private void output(String message) {
		System.out.println("CR: " + message);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
