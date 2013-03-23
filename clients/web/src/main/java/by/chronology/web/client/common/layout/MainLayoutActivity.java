package by.chronology.web.client.common.layout;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

/**
 * Control main layout with a life cycle managed by an ActivityManager.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class MainLayoutActivity extends AbstractActivity implements MainLayoutDisplay.Presenter
{
    @Inject
    MainLayoutDisplay mainLayoutView;
    @Inject
    PlaceController placeController;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        mainLayoutView.setPresenter(this);
        panel.setWidget(mainLayoutView.asWidget());
    }

    @Override
    public void goTo(Place place)
    {
        placeController.goTo(place);
    }
}
