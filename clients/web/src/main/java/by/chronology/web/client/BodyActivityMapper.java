package by.chronology.web.client;

import by.chronology.web.client.place.StartPlace;
import by.chronology.web.client.common.layout.TrackActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

/**
 * Finds the activities to run for a body.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class BodyActivityMapper implements ActivityMapper
{
    @Inject
    TrackActivity trackActivity;

    @Override
    public Activity getActivity(Place place)
    {
        if (place instanceof StartPlace)
        {
            return trackActivity;
        }
        return null;
    }
}
