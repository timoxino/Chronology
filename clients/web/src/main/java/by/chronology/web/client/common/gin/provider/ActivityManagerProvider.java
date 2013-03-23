package by.chronology.web.client.common.gin.provider;

import by.chronology.web.client.TimeTrackerActivityMapper;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Creates instance of ActivityManager with pre-configured event bus and activity mapper.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class ActivityManagerProvider implements Provider<ActivityManager>
{
    @Inject
    EventBus eventBus;
    @Inject
    TimeTrackerActivityMapper activityMapper;

    @Override
    public ActivityManager get()
    {
        return new ActivityManager(activityMapper, eventBus);
    }
}
