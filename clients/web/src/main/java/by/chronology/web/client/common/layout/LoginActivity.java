package by.chronology.web.client.common.layout;

import by.chronology.web.client.model.UserAccount;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

/**
 * Control 'Login panel' with a life cycle managed by an ActivityManager.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class LoginActivity extends AbstractActivity implements LoginDisplay.Presenter
{
    @Inject
    LoginDisplay loginView;
    @Inject
    PlaceController placeController;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        loginView.setPresenter(this);
        panel.setWidget(loginView.asWidget());
    }

    @Override
    public void goTo(Place place)
    {
        placeController.goTo(place);
    }

    @Override
    public void onLogin(UserAccount userAccount)
    {
        // TODO: need to be implemented
    }

    @Override
    public void onSignup(UserAccount userAccount)
    {
        // TODO: need to be implemented
    }
}
