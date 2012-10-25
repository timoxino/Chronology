package by.chronology.web.client.common.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Horizontal panel with short textual clickable topics.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/23/12
 */
public class EventsPanel extends Composite
{
    interface EventsPanelUiBinder extends UiBinder<Widget, EventsPanel>
    {
    }

    private static EventsPanelUiBinder uiBinder = GWT.create(EventsPanelUiBinder.class);

    public EventsPanel()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
