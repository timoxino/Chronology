package by.chronology.web.client;

import by.chronology.web.client.common.layout.LayoutView;
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
 * Helper class that configures initial navigation flow.
 *
 * @author Tsimafei_Shchytkavets
 */
@Singleton
public class NavigationConfigurer
{
    @Inject
    EventBus eventBus;
    @Inject
    PlaceController placeController;
    @Inject
    PlaceHistoryHandler historyHandler;
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
    @Inject
    LayoutView layoutView;

    public void navigate()
    {
        RootPanel.get().add(layoutView);
        createActivityManager(logoActivityMapper).setDisplay(layoutView.getLogoPanel());
        createActivityManager(notificationActivityMapper).setDisplay(layoutView.getNotificationPanel());
        createActivityManager(loginActivityMapper).setDisplay(layoutView.getLoginPanel());
        createActivityManager(actionsActivityMapper).setDisplay(layoutView.getActionsPanel());
        createActivityManager(bodyActivityMapper).setDisplay(layoutView.getBodyPanel());

        historyHandler.register(placeController, eventBus, new StartPlace());
        historyHandler.handleCurrentHistory();
    }

    private ActivityManager createActivityManager(ActivityMapper activityMapper)
    {
        return new ActivityManager(activityMapper, eventBus);
    }
}
