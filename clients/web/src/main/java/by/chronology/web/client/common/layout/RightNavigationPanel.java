package by.chronology.web.client.common.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Vertical panel on the right with navigation links.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/23/12
 */
public class RightNavigationPanel extends Composite
{
    interface RightNavigationPanelUiBinder extends UiBinder<Widget, RightNavigationPanel>
    {
    }

    private static RightNavigationPanelUiBinder uiBinder = GWT.create(RightNavigationPanelUiBinder.class);

    public RightNavigationPanel()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
