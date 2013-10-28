package by.chronology.web.client.logo;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Control 'Logo area' with a life cycle managed by an ActivityManager.
 * 
 * @author Tsimafei Shchytkavets
 */
@Singleton
public class LogoActivity extends AbstractActivity
{
    PlaceController placeController;
    LogoView view;

    @Inject
    public LogoActivity(PlaceController controller, LogoView logoView)
    {
        placeController = controller;
        view = logoView;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        panel.setWidget(view);
    }
}
