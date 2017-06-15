package productionmanagement;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import ch.ethz.iks.r_osgi.RemoteOSGiService;
import productionManagement.IProductionManagement;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
//		Dictionary<String, String> props = new Hashtable<String, String>();
//		// OSGi Standard Property - indicates which of the interfaces of the service will be exported.  '*' means 'all'.
//		props.put("service.exported.interfaces", "*");
//		// OSGi Standard Property (optional) - indicates which provider config(s) will be used to export the service
//		// (If not explicitly given here, the provider is free to choose a default configuration for the service)
//		props.put("service.exported.configs","ecf.generic.server");
//		// Register a new TimeServiceImpl with the above props
//		bundleContext.registerService(IProductionManagement.class, new ProductionManagement(), props);

		Hashtable properties = new Hashtable();

		properties.put(RemoteOSGiService.R_OSGi_REGISTRATION, Boolean.TRUE);
		bundleContext.registerService(IProductionManagement.class.getName(), new ProductionManagement(), properties);

		ServiceReference[] test = bundleContext.getAllServiceReferences(null, null);

//		for (ServiceReference sr: test)
//		{
//			for (String s: sr.getPropertyKeys())
//			{
//				//if (s.contains("RemoteOSGI"))
//				System.out.println(sr.getProperty(s));
//
//			}
//		}


		System.out.println("registered ProductionManagement");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {

	}

}
