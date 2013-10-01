package by.chronology.web.client;

import by.chronology.web.client.common.layout.*;
import by.chronology.web.client.place.StartPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Takes a responsibility for initializing of main layout and configuring Activities/Places stuff.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/22/12
 */
@Singleton
public class TimeTrackerController
{
    @Inject
    EventBus eventBus;
    @Inject
    PlaceController placeController;
    @Inject
    PlaceHistoryHandler historyHandler;
    @Inject
    StartPlace startPlace;
    @Inject
    LayoutView layoutView;

    @Inject
    HeaderActivityMapper headerActivityMapper;
    @Inject
    LoginActivityMapper loginActivityMapper;
    @Inject
    BodyActivityMapper bodyActivityMapper;

    public void go()
    {
        addMainLayout();
        goToDefaultPlace();
    }

    private void addMainLayout()
    {
        RootPanel.get().add(layoutView);
    }

    private void goToDefaultPlace()
    {
        createActivityManager(headerActivityMapper).setDisplay(layoutView.getLogoPanel());
        createActivityManager(loginActivityMapper).setDisplay(layoutView.getLoginPanel());
        createActivityManager(bodyActivityMapper).setDisplay(layoutView.getBodyPanel());

        historyHandler.register(placeController, eventBus, startPlace);
        historyHandler.handleCurrentHistory();
    }

    private ActivityManager createActivityManager(ActivityMapper activityMapper)
    {
        return new ActivityManager(activityMapper, eventBus);
    }
}