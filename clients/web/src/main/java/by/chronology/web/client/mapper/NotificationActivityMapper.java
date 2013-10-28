package by.chronology.web.client.mapper;

import by.chronology.web.client.notification.NotificationActivity;
import by.chronology.web.client.place.StartPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

/**
 * Finds the activities to run for a notification area.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class NotificationActivityMapper implements ActivityMapper
{
    @Inject
    NotificationActivity notificationActivity;

    @Override
    public Activity getActivity(Place place)
    {
        if (place instanceof StartPlace)
        {
            return notificationActivity;
        }
        return null;
    }
}
