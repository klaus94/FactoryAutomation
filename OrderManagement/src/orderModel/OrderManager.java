package orderModel;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import crm.ICustomerOrders;
import crm.Order;
import orderManagement.IOrderManagement;

public class OrderManager implements IOrderManagement{

	private List<Order> orders;
	private ICustomerOrders ico;
	
	public OrderManager() {
		orders = new ArrayList<>();
		BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceReference<?> serviceReference = context.getServiceReference(ICustomerOrders.class.getName());
		ico = (ICustomerOrders) context.getService(serviceReference);
		
		
	}
	
	public List<Order> getAllOrders() {
		return orders;
	}
	
	public Order findById(int id) {
		for(Order o : orders) {
			if (o.getId() == id) 
				return o;
		}
		
		return null;
	}
	
	public void addOrder(Order o) {
		orders.add(o);
	}
	
	public void action()
	{	
		orders = ico.getOrdersFromAllCustomer();
		
		System.out.println("allOrders:");
		for(Order o : orders) {
			System.out.println(o);
		}
	}
}
