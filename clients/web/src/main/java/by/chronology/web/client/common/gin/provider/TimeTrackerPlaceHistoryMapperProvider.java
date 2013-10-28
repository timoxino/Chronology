package by.chronology.web.client.common.gin.provider;

import by.chronology.web.client.mapper.TimeTrackerPlaceHistoryMapper;
import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

/**
 * Provider for place history mapper.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
public class TimeTrackerPlaceHistoryMapperProvider implements Provider<TimeTrackerPlaceHistoryMapper>
{
    @Override
    public TimeTrackerPlaceHistoryMapper get()
    {
        return GWT.create(TimeTrackerPlaceHistoryMapper.class);
    }
}
