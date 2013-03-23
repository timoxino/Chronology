package by.chronology.web.client.common.layout;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

/**
 * Control 'Registration form' with a life cycle managed by an ActivityManager.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class RegistrationActivity extends AbstractActivity implements RegistrationDisplay.Presenter
{
    @Inject
    RegistrationDisplay registrationView;
    @Inject
    PlaceController placeController;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        registrationView.setPresenter(this);
        panel.setWidget(registrationView.asWidget());
    }

    @Override
    public void goTo(Place place)
    {
        placeController.goTo(place);
    }
}
