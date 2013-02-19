package by.chronology.web.client.common.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Horizontal panel with several buttons like 'Home', 'Send email' etc.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/23/12
 */
@Deprecated
public class FunctionalButtonsPanel extends Composite
{
    interface FunctionalButtonsPanelUiBinder extends UiBinder<Widget, FunctionalButtonsPanel>
    {
    }

    private static FunctionalButtonsPanelUiBinder uiBinder = GWT.create(FunctionalButtonsPanelUiBinder.class);

    public FunctionalButtonsPanel()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
