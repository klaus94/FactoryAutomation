

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import crm.ICustomerManagement;
import crm.ICustomerOrders;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		CustomerRegistry cr = new CustomerRegistry();
		
		context.registerService(ICustomerOrders.class.getName(), cr, null);
		context.registerService(ICustomerManagement.class.getName(), cr, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}

}
