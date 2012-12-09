package by.chronology.web.client.common.gin.provider;

import by.chronology.web.client.service.rpc.TimeTagService;
import by.chronology.web.client.service.rpc.TimeTagServiceAsync;
import com.google.gwt.core.client.GWT;

/**
 * TimeTagService stub provider.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
public class TimeTagServiceProvider extends BaseServiceProvider<TimeTagServiceAsync>
{
    @Override
    protected TimeTagServiceAsync provide()
    {
        return GWT.create(TimeTagService.class);
    }
}
