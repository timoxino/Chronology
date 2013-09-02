package by.chronology.web.client;

import by.chronology.web.client.common.layout.LoginActivity;
import by.chronology.web.client.common.layout.LoginPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

/**
 * Finds the activities to run for a navigation panel.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class NavigationActivityMapper implements ActivityMapper
{
    @Inject
    LoginActivity loginActivity;

    @Override
    public Activity getActivity(Place place)
    {
        if (place instanceof LoginPlace)
        {
            return loginActivity;
        }
        return null;
    }
}
