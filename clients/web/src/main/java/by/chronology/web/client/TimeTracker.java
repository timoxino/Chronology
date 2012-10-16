package by.chronology.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/8/12
 */
public class TimeTracker implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get();
        rootPanel.add(new Button("Do nothing!!!"));
    }
}
