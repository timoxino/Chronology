package by.chronology.web.client.login;

import by.chronology.web.client.service.rpc.UserServiceAsync;

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
public class LoginActivity extends AbstractActivity// implements LoginDisplay.Presenter
{
    //@Inject
    //LoginDisplay trackView;
    @Inject
    PlaceController placeController;
    @Inject
    UserServiceAsync userService;

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        //trackView.setPresenter(this);
        //panel.setWidget(trackView.asWidget());
    }

    //@Override
    public void goTo(Place place)
    {
        placeController.goTo(place);
    }

    /*@Override
    public void onLogin(UserAccount userAccount)
    {
        userService.login(userAccount, new AsyncCallback<UserContext>()
        {
            @Override
            public void onFailure(Throwable caught)
            {
                GWT.log("login failed", caught);
            }

            @Override
            public void onSuccess(UserContext result)
            {
                GWT.log("Hello " + result.getUserAccount().getFirstName());
            }
        });
    }

    @Override
    public void onSignup()
    {
        // TODO: need to be implemented
    }*/
}
