package by.chronology.web.client;

import by.chronology.web.client.event.ShowAlertEvent;

import by.chronology.web.client.notification.NotificationActivity;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Takes a responsibility for initializing of main layout and configuring Activities/Places stuff.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/22/12
 */
@Singleton
public class TimeTrackerController
{
    @Inject
    EventBus eventBus;
    @Inject
    NotificationActivity notificationActivity;
    @Inject
    NavigationConfigurer navigationConfigurer;

    public void go()
    {
        eventBus.addHandler(ShowAlertEvent.TYPE, notificationActivity);

        navigationConfigurer.navigate();
    }
}
