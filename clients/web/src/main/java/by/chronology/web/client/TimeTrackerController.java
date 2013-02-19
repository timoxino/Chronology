package by.chronology.web.client;

import by.chronology.web.client.common.Constants;
import by.chronology.web.client.common.Presenter;
import by.chronology.web.client.common.layout.*;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Class responsible for handling application events and view navigation.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/22/12
 */
@Singleton
public class TimeTrackerController implements Presenter
{
    @Inject
    FunctionalButtonsPanel functionalButtonsPanel;

    @Inject
    NavigationHeader navigationHeader;

    @Inject
    EventsPanel eventsPanel;

    @Inject
    MainContentPanel mainContentPanel;

    @Inject
    RightNavigationPanel rightNavigationPanel;

    @Inject
    Footer footer;

    @Override
    public void go(HasWidgets container)
    {

    }
}