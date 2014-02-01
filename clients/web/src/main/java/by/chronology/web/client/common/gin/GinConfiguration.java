package by.chronology.web.client.common.gin;

import by.chronology.web.client.mapper.TimeTrackerPlaceHistoryMapper;
import by.chronology.web.client.common.gin.provider.*;
import by.chronology.web.client.service.rpc.TimeTagServiceAsync;
import by.chronology.web.client.service.rpc.UserServiceAsync;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * TimeTracker injection configuration class.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/22/12
 */
public class GinConfiguration extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        bind(TimeTagServiceAsync.class).toProvider(TimeTagServiceProvider.class).in(Singleton.class);
        bind(UserServiceAsync.class).toProvider(UserServiceProvider.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        configureActivities();
    }

    private void configureActivities()
    {
        bind(PlaceController.class).toProvider(PlaceControllerProvider.class).in(Singleton.class);
        bind(TimeTrackerPlaceHistoryMapper.class).toProvider(TimeTrackerPlaceHistoryMapperProvider.class).in(Singleton.class);
        bind(PlaceHistoryHandler.class).toProvider(PlaceHistoryHandlerProvider.class).in(Singleton.class);
    }
}
