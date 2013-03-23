package by.chronology.web.client;

import by.chronology.web.client.common.layout.*;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

/**
 * Finds the activity to run for a given place.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class TimeTrackerActivityMapper implements ActivityMapper
{
    @Inject
    MainLayoutActivity mainLayoutActivity;
    @Inject
    LoginActivity loginActivity;
    @Inject
    RegistrationActivity registrationActivity;

    @Override
    public Activity getActivity(Place place)
    {
        if (place instanceof MainLayoutPlace)
        {
            //mainLayoutActivity.update(place);
            return mainLayoutActivity;
        }
        else if (place instanceof LoginPlace)
        {
            //loginActivity.update(place);
            return loginActivity;
        }
        else if (place instanceof RegistrationPlace)
        {
            //registrationActivity.update(place);
            return registrationActivity;
        }
        return null;
    }
}
