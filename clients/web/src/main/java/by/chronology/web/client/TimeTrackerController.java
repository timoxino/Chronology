package by.chronology.web.client;

import by.chronology.web.client.common.layout.*;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.sencha.gxt.widget.core.client.container.Viewport;

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
    ActivityManager activityManager;
    @Inject
    PlaceHistoryHandler historyHandler;
    @Inject
    MainLayoutDisplay mainLayout;
    @Inject
    LoginPlace defaultPlace;

    public void go()
    {
        addMainLayout();
        goToDefaultPlace();
    }

    private void addMainLayout()
    {
        Viewport viewport = new Viewport();
        viewport.add(mainLayout);
        RootPanel.get().add(viewport);
    }

    private void goToDefaultPlace()
    {
        activityManager.setDisplay(mainLayout.getNavigationPanel());
        historyHandler.register(placeController, eventBus, defaultPlace);
        historyHandler.handleCurrentHistory();
    }
}