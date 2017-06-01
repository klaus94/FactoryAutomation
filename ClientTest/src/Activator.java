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
import productionManagement.IProductionManagement;
import stockManagement.IStockManagement;
import stockManagement.Product;


public class Activator implements BundleActivator {

	private IProductionManagement ipm = null;


	void bind(IProductionManagement ipm) {
		this.ipm = ipm;

		System.out.println("Discovered productionmanagement DS");
		System.out.println(this.ipm);
	}

	@Override
	public void start(BundleContext context) throws Exception
	{
		System.out.println(ipm);
		System.out.println("Test Activator started");
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