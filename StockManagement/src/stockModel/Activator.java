package stockModel;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import stockManagement.IStockManagement;



public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		context.registerService(IStockManagement.class.getName(), new StockManagement(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}

}
