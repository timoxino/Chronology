package by.chronology.web.client.common.layout;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

/**
 * Control 'Track panel' with a life cycle managed by an ActivityManager.
 * 
 * @author Tsimafei Shchytkavets
 */
public class TrackActivity extends AbstractActivity
{
    @Inject
    TrackView trackView;
    @Inject
    PlaceController placeController;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        panel.setWidget(trackView.asWidget());
    }

    public void goTo(Place place)
    {
        placeController.goTo(place);
    }
}
