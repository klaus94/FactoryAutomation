package orderModel;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import orderManagement.IOrderManagement;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		context.registerService(IOrderManagement.class.getName(), new OrderManager(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}

}