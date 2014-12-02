package org.slf4j.impl;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * Our OSGI LogFactory
 */
public class OSGILogFactory implements ILoggerFactory {

    private static volatile BundleContext bundleContext;
    private static final ServiceListener SERVICE_LISTENER = new ServiceListener() {

        @Override
        public void serviceChanged(ServiceEvent se) {
            switch (se.getType()) {
                case ServiceEvent.REGISTERED:
                    onServiceAvailable((LogService) bundleContext.getService(se.getServiceReference()));
                    break;
                case ServiceEvent.UNREGISTERING:
                    onServiceLost();
                    break;
                default:
                    break;
            }
        }

    };

    static volatile LogService currentLogService;

    @Override
    public Logger getLogger(String name) {
        return new OSGILogger();
    }

    public static void init(BundleContext context) {
        bundleContext = context;
        final String serviceName = LogService.class.getName();
        ServiceReference controlReference = context.getServiceReference(serviceName);
        if (controlReference != null) {
            onServiceAvailable((LogService) context.getService(controlReference));
        }

        try {
            context.addServiceListener(SERVICE_LISTENER, "(objectclass=" + serviceName + ")");
        } catch (InvalidSyntaxException ex) {
            throw new IllegalStateException(ex);
        }
    }

    private static void onServiceAvailable(LogService logService) {
		currentLogService = logService;
    }

    private static void onServiceLost() {
		currentLogService = null;
    }

}
