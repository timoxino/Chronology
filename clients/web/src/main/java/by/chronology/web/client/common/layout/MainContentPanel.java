package by.chronology.web.client.common.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Panel that holds main content.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/23/12
 */
public class MainContentPanel extends Composite
{
    interface MainContentPanelUiBinder extends UiBinder<Widget, MainContentPanel>
    {
    }

    private static MainContentPanelUiBinder uiBinder = GWT.create(MainContentPanelUiBinder.class);

    public MainContentPanel()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
