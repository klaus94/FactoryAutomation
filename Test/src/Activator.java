
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


public class Activator implements BundleActivator {

	private ICustomerOrders ico;
	private IStockManagement ism;
	private ICustomerManagement icm;
	private IOrderManagement iom;
	
	@Override
	public void start(BundleContext context) throws Exception {
		//test things
		System.out.println("starte test");
		
		ServiceReference<?> serviceReference = context.getServiceReference(ICustomerManagement.class.getName());
		
		icm = (ICustomerManagement) context.getService(serviceReference);
		
		// create customers
		Customer customer1 = new Customer(1, "Horst", new Address("Astrasse", "Dresden", "01234"));
		Customer customer2 = new Customer(2, "Peter", new Address("Bstrasse", "leipzig", "11234"));
		customer1.addOrder(new Order(1, "zauberwürfel"));
		
		icm.addCustomer(customer1);
		icm.addCustomer(customer2);
		
		serviceReference = context.getServiceReference(ICustomerOrders.class.getName());
		ico = (ICustomerOrders) context.getService(serviceReference);
		
		serviceReference = context.getServiceReference(IStockManagement.class.getName());
		ism = (IStockManagement) context.getService(serviceReference);
		
		
		serviceReference = context.getServiceReference(IOrderManagement.class.getName());
		iom = (IOrderManagement) context.getService(serviceReference);
		
		iom.action();
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}

}