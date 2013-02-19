package by.chronology.web.client.common.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Horizontal panel with navigation links like 'Home', 'Time Tags' etc.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/23/12
 */
@Deprecated
public class NavigationHeader extends Composite
{
    @UiField
    Anchor homeLink;
    @UiField
    Anchor timeTagsLink;
    @UiField
    Anchor timeLineLink;
    @UiField
    Anchor calculationsLink;
    @UiField
    Anchor visualizationsLink;

    interface NavigationHeaderUiBinder extends UiBinder<Widget, NavigationHeader>
    {
    }

    private static NavigationHeaderUiBinder uiBinder = GWT.create(NavigationHeaderUiBinder.class);

    public NavigationHeader()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("homeLink")
    public void onHomeLinkClicked(ClickEvent event)
    {
        GWT.log("on home clicked");
    }

    @UiHandler("timeTagsLink")
    public void onTimeTagsLinkClicked(ClickEvent event)
    {
        GWT.log("on time tags clicked");
    }

    @UiHandler("timeLineLink")
    public void onTimeLineLinkClicked(ClickEvent event)
    {
        GWT.log("on time line clicked");
    }

    @UiHandler("calculationsLink")
    public void onCalculationsLinkClicked(ClickEvent event)
    {
        GWT.log("on calculations clicked");
    }

    @UiHandler("visualizationsLink")
    public void onVisualizationsLinkClicked(ClickEvent event)
    {
        GWT.log("on visualizations clicked");
    }
}
