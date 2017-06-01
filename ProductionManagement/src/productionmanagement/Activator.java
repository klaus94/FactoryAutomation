package productionmanagement;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

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

		bundleContext.registerService(IProductionManagement.class, new ProductionManagement(),  createRemoteServiceProperties());

		System.out.println("registered ProductionManagement");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {

	}


	private static final String SERVICE_EXPORTED_CONFIGS = "service.exported.configs";
	private static final String DEFAULT_CONFIG = "ecf.generic.server";

	private Dictionary<String, Object> createRemoteServiceProperties() {
		Hashtable<String, Object> result = new Hashtable<String, Object>();
		// This property is required by the Remote Services specification
		// (chapter 100 in enterprise specification), and when set results
		// in RSA impl exporting as a remote service
		result.put("service.exported.interfaces", "*");
		// async interfaces is an ECF Remote Services service property
		// that allows any declared asynchronous interfaces
		// to be used by consumers.
		// See https://wiki.eclipse.org/ECF/Asynchronous_Remote_Services
		result.put("ecf.exported.async.interfaces", "*");
		// get system properties
		Properties props = System.getProperties();
		// Get OSGi service.exported.configs property
		String config = props.getProperty(SERVICE_EXPORTED_CONFIGS);
		if (config == null) {
			config = DEFAULT_CONFIG;
			result.put(DEFAULT_CONFIG + ".port", "3288");
			result.put(DEFAULT_CONFIG + ".hostname", "localhost");
		}

		result.put(SERVICE_EXPORTED_CONFIGS, config);
		// add any config properties. config properties start with
		// the config name '.' property
		for (Object k : props.keySet()) {
			if (k instanceof String) {
				String key = (String) k;
				if (key.startsWith(config))
					result.put(key, props.get(key));
			}
		}

		for (String key: result.keySet())
		{
			System.out.println(key + " : " + result.get(key));
		}

		return result;
	}

}
