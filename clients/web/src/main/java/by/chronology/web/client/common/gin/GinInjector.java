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
@GinModules(GinConfiguration.class)
public interface GinInjector extends Ginjector
{
    /**
     * Returns main application controller.
     */
    TimeTrackerController getTimeTrackerController();
}
