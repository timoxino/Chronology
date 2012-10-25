package by.chronology.web.client.common.gin;

import by.chronology.web.client.TimeTrackerController;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Interface describes what GIN injector can return.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/22/12
 */
@GinModules(TimeTrackerConfiguration.class)
public interface TimeTrackerInjector extends Ginjector
{
    /**
     * Returns main application controller.
     */
    TimeTrackerController getTimeTrackerController();
}
