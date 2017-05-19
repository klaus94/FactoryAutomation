package crm;

public interface ICustomerManagement {
	
	void addCustomer(Customer c);
	
	void removeCustomer(Customer c);
	
	Customer findById(int id);
	
}
