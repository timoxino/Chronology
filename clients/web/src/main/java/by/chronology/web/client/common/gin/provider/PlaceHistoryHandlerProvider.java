package by.chronology.web.client.common.gin.provider;

import by.chronology.web.client.mapper.TimeTrackerPlaceHistoryMapper;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Creates instance of PlaceHistoryHandler with pre-configured place history mapper.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class PlaceHistoryHandlerProvider implements Provider<PlaceHistoryHandler>
{
    @Inject
    TimeTrackerPlaceHistoryMapper placeHistoryMapper;

    @Override
    public PlaceHistoryHandler get()
    {
        return new PlaceHistoryHandler(placeHistoryMapper);
    }
}
