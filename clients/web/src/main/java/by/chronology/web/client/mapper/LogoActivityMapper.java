package by.chronology.web.client.mapper;

import by.chronology.web.client.logo.LogoActivity;
import by.chronology.web.client.place.StartPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

/**
 * Finds the activities to run for a logo area.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class LogoActivityMapper implements ActivityMapper
{
    @Inject
    LogoActivity logoActivity;

    @Override
    public Activity getActivity(Place place)
    {
        if (place instanceof StartPlace)
        {
            return logoActivity;
        }
        return null;
    }
}
