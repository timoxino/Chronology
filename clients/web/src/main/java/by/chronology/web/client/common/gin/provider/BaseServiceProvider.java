package by.chronology.web.client.common.gin.provider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.inject.Provider;

/**
 * Custom service provider which re-configures service URL.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
public abstract class BaseServiceProvider<T> implements Provider<T>
{
    @Override
    public T get()
    {
        T providedService = provide();
        final ServiceDefTarget serviceDefTarget = (ServiceDefTarget) providedService;
        final String serviceEntryPoint = serviceDefTarget.getServiceEntryPoint();
        final String moduleBaseURL = GWT.getModuleBaseURL();
        final String serviceUrl = calculateServiceUrl(moduleBaseURL, serviceEntryPoint);
        serviceDefTarget.setServiceEntryPoint(serviceUrl);
        return providedService;
    }

    /**
     * Remove module name from service path.
     */
    String calculateServiceUrl(String baseUrl, String entryPoint)
    {
        final String servicePath = entryPoint.substring(baseUrl.length());
        final StringBuilder applicationPath = new StringBuilder();
        final String[] split = baseUrl.split("/");
        for (int i = 0; i < split.length - 1; i++)
        {
            applicationPath.append(split[i]).append("/");
        }
        final String result = applicationPath.toString() + servicePath;
        return result;
    }

    protected abstract T provide();
}
