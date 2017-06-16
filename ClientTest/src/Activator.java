
import org.omg.IOP.IOR;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

import ch.ethz.iks.r_osgi.RemoteOSGiService;
import ch.ethz.iks.r_osgi.RemoteServiceReference;
import ch.ethz.iks.r_osgi.URI;
import crm.Address;
import crm.Customer;
import crm.ICustomerManagement;
import crm.ICustomerOrders;
import crm.Order;
import orderManagement.IOrderManagement;
import productionManagement.IProductionManagement;
import productionManagement.Machine;
import productionManagement.Process;
import productionManagement.ProcessStep;
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
		//Test test = new Test();
		// get the RemoteOSGiService
		System.out.println("test " + RemoteOSGiService.class.getName());
		String test = RemoteOSGiService.class.getName();
		final ServiceReference sref = context.getServiceReference(RemoteOSGiService.class.getName());

		if (sref == null) {
			throw new BundleException("No R-OSGi found");
		}

		RemoteOSGiService remote = (RemoteOSGiService) context.getService(sref);

		// connect
		remote.connect(new URI("r-osgi://localhost:9279"));
		//remote.connect(new URI("r-osgi://fluidpaq1.inf.ethz.ch:9278"));

//		final RemoteServiceReference[] srefs = remote.getRemoteServiceReferences(new URI("r-osgi://fluidpaq1.inf.ethz.ch:9278"), IProductionManagement.class.getName(), null);
		final RemoteServiceReference[] srefs = remote.getRemoteServiceReferences(new URI("r-osgi://localhost:9279"), IProductionManagement.class.getName(), null);


		ipm = (IProductionManagement) remote.getRemoteService(srefs[0]);

		Order o1 = new Order(1, "green cube");
		Order o2 = new Order(2, "red ball");

		startOrder(o1);
		startOrder(o2);
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

	private void startOrder(Order order)
	{
		new Thread()
		{
		    public void run()
		    {
		    	System.out.println("CLIENT  sending order: " + order.toString() + "...");
				Product p = ipm.ProduceProduct(order);
				System.out.println("CLIENT: GOT Product back: " + p);
		    }
		}.start();
	}

}