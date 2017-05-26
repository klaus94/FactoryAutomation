package orderModel;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import crm.Customer;
import crm.ICustomerOrders;
import crm.Order;
import orderManagement.IOrderManagement;

public class OrderManager implements IOrderManagement{

	private List<Order> orders;
	private ICustomerOrders ico;
	
	public OrderManager() {
		output("Order Manager created");
		orders = new ArrayList<>();
		BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceReference<?> serviceReference = context.getServiceReference(ICustomerOrders.class.getName());
		ico = (ICustomerOrders) context.getService(serviceReference);
		
		
	}
	
	public List<Order> getAllOrders() {
		output("get all orders");
		return orders;
	}
	
	public Order findById(int id) {
		for(Order o : orders) {
			if (o.getId() == id) {
				output("find Order by ID " + id + ": " + o.getTitle());
				return o;
			}
		}
		output("find Order by ID " + id + ": none");
		return null;
	}
	
	public void addOrder(Order o, Customer c) {
		output("add Order: " + o.getTitle());
		orders.add(o);
		c.addOrder(o);
	}
	
	private void output(String message) {
		System.out.println("OM: " + message);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
