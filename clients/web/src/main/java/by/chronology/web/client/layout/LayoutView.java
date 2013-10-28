package by.chronology.web.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Base markup for web application.
 *
 * @author Tsimafei_Shchytkavets
 */
public class LayoutView extends Composite
{
    @UiField
    SimplePanel logoPanel;
    @UiField
    SimplePanel notificationPanel;
    @UiField
    SimplePanel loginPanel;
    @UiField
    SimplePanel actionsPanel;
    @UiField
    SimplePanel bodyPanel;

    interface MyUiBinder extends UiBinder<FlowPanel, LayoutView>
    {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public LayoutView()
    {
        initWidget(uiBinder.createAndBindUi(this));

    }

    public SimplePanel getLogoPanel()
    {
        return logoPanel;
    }

    public SimplePanel getNotificationPanel()
    {
        return notificationPanel;
    }

    public SimplePanel getLoginPanel()
    {
        return loginPanel;
    }

    public SimplePanel getActionsPanel()
    {
        return actionsPanel;
    }

    public SimplePanel getBodyPanel()
    {
        return bodyPanel;
    }
}
