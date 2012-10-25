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
        populateInitialLayout((RootPanel)container);
    }

    private void populateInitialLayout(RootPanel rootPanel)
    {
        rootPanel.get(Constants.HtmlElementId.BUTTONS_PANEL_ID).add(functionalButtonsPanel);
        rootPanel.get(Constants.HtmlElementId.NAVIGATION_HEADER_ID).add(navigationHeader);
        rootPanel.get(Constants.HtmlElementId.EVENTS_PANEL_ID).add(eventsPanel);
        rootPanel.get(Constants.HtmlElementId.MAIN_CONTENT_ID).add(mainContentPanel);
        rootPanel.get(Constants.HtmlElementId.RIGHT_NAVIGATION_ID).add(rightNavigationPanel);
        rootPanel.get(Constants.HtmlElementId.FOOTER_ID).add(footer);
    }
}