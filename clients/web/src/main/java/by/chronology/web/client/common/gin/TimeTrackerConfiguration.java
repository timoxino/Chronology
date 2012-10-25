package by.chronology.web.client.common.gin;

import by.chronology.web.client.TimeTrackerController;
import by.chronology.web.client.common.Presenter;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * TimeTracker injection configuration class.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/22/12
 */
public class TimeTrackerConfiguration extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        bind(Presenter.class).to(TimeTrackerController.class).in(Singleton.class);
    }
}
