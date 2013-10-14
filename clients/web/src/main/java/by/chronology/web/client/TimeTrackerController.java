package by.chronology.web.client;

import by.chronology.web.client.common.layout.*;
import by.chronology.web.client.event.ShowAlertEvent;
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
    NotificationActivity notificationActivity;

    @Inject
    LogoActivityMapper logoActivityMapper;
    @Inject
    NotificationActivityMapper notificationActivityMapper;
    @Inject
    LoginActivityMapper loginActivityMapper;
    @Inject
    ActionsActivityMapper actionsActivityMapper;
    @Inject
    BodyActivityMapper bodyActivityMapper;

    public void go()
    {
        eventBus.addHandler(ShowAlertEvent.TYPE, notificationActivity);
        addMainLayout();
        goToDefaultPlace();
    }

    private void addMainLayout()
    {
        RootPanel.get().add(layoutView);
    }

    private void goToDefaultPlace()
    {
        createActivityManager(logoActivityMapper).setDisplay(layoutView.getLogoPanel());
        createActivityManager(notificationActivityMapper).setDisplay(layoutView.getNotificationPanel());
        createActivityManager(loginActivityMapper).setDisplay(layoutView.getLoginPanel());
        createActivityManager(actionsActivityMapper).setDisplay(layoutView.getActionsPanel());
        createActivityManager(bodyActivityMapper).setDisplay(layoutView.getBodyPanel());

        historyHandler.register(placeController, eventBus, startPlace);
        historyHandler.handleCurrentHistory();
    }

    private ActivityManager createActivityManager(ActivityMapper activityMapper)
    {
        return new ActivityManager(activityMapper, eventBus);
    }
}