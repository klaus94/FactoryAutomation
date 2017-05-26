
import org.omg.IOP.IOR;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import crm.Address;
import crm.Customer;
import crm.ICustomerManagement;
import crm.ICustomerOrders;
import crm.Order;
import orderManagement.IOrderManagement;
import stockManagement.IStockManagement;
import stockManagement.Product;


public class Activator implements BundleActivator {

	private ICustomerOrders ico;
	private IStockManagement ism;
	private ICustomerManagement icm;
	private IOrderManagement iom;
	
	@Override
	public void start(BundleContext context) throws Exception {
		//test things
		System.out.println("--- START TEST ---");
		
		ServiceReference<?> serviceReference = context.getServiceReference(ICustomerManagement.class.getName());
		icm = (ICustomerManagement) context.getService(serviceReference);
		
		serviceReference = context.getServiceReference(ICustomerOrders.class.getName());
		ico = (ICustomerOrders) context.getService(serviceReference);
		
		serviceReference = context.getServiceReference(IStockManagement.class.getName());
		ism = (IStockManagement) context.getService(serviceReference);
		
		serviceReference = context.getServiceReference(IOrderManagement.class.getName());
		iom = (IOrderManagement) context.getService(serviceReference);
		
		// create customers
		Customer customer1 = new Customer(1, "Horst", new Address("Astrasse", "Dresden", "01234"));
		Customer customer2 = new Customer(2, "Peter", new Address("Bstrasse", "leipzig", "11234"));
		
		// add Customer
		icm.addCustomer(customer1);
		icm.addCustomer(customer2);
		
		// Customer creates Orders
		Order order1 = new Order(1, "Zauberwürfel");
		Order order2 = new Order(2, "Springseil");
		Order order3 = new Order(3, "Luftballon");
		
		// Orders added to OrderManagement
		iom.addOrder(order1, customer1);
		iom.addOrder(order2, customer1);
		iom.addOrder(order3, customer2);
		
		// create and add Products to StockManager
		output("producing Product from order: " + order1.getTitle());
		Product product1 = new Product(1, order1.getTitle());
		ism.addProduct(product1);
		
		output("producing Product from order: " + order2.getTitle());
		Product product2 = new Product(2, order2.getTitle());
		ism.addProduct(product2);
		
		output("producing Product from order: " + order3.getTitle());
		Product product3 = new Product(3, order3.getTitle());
		ism.addProduct(product3);
		
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}

	private void output(String message) {
		System.out.println("Factory: " + message);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}