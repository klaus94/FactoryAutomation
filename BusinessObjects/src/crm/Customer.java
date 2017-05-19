package crm;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private final int id;
	private String name;
	private Address address;
	private boolean approved;
	private List<Order> orders;
	
	public Customer(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.approved = false;
		orders = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getId() {
		return id;
	}
	
	public void addOrder(Order o) {
		orders.add(o);
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	
	
	
}
