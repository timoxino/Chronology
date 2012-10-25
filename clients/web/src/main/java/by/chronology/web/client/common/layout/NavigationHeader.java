package by.chronology.web.client.common.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Horizontal panel with navigation links like 'Home', 'About Us' etc.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/23/12
 */
public class NavigationHeader extends Composite
{
    interface NavigationHeaderUiBinder extends UiBinder<Widget, NavigationHeader>
    {
    }

    private static NavigationHeaderUiBinder uiBinder = GWT.create(NavigationHeaderUiBinder.class);

    public NavigationHeader()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
