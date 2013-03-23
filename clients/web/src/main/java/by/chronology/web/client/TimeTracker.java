package by.chronology.web.client;

import by.chronology.web.client.common.gin.TimeTrackerInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

/**
 * TimeTracker Web application entry point.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/8/12
 */
public class TimeTracker implements EntryPoint
{
    private final TimeTrackerInjector injector = GWT.create(TimeTrackerInjector.class);

    @Override
    public void onModuleLoad()
    {
        injector.getTimeTrackerController().go();
    }
}
