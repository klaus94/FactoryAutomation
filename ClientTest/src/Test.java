import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

import ch.ethz.iks.r_osgi.RemoteOSGiService;
import ch.ethz.iks.r_osgi.RemoteServiceReference;
import ch.ethz.iks.r_osgi.URI;
import productionManagement.IProductionManagement;

public class Test {
	public Test()
	{
		// get the RemoteOSGiService
		System.out.println("test " + RemoteOSGiService.class.getName());
//		final ServiceReference sref = context.getServiceReference(RemoteOSGiService.class.getSimpleName());
//
//		if (sref == null) {
//			throw new BundleException("No R-OSGi found");
//		}
//
//		RemoteOSGiService remote = (RemoteOSGiService) context.getService(sref);
//
//		// connect
//		remote.connect(new URI("r-osgi://fluidpaq1.inf.ethz.ch:9278"));
//
//		final RemoteServiceReference[] srefs = remote.getRemoteServiceReferences(new URI("r-osgi://fluidpaq1.inf.ethz.ch:9278"), IProductionManagement.class.getName(), null);
//
//		ipm = (IProductionManagement) remote.getRemoteService(srefs[0]);
//
//		System.out.println(ipm);
//		System.out.println("Test Activator started");
	}
}
