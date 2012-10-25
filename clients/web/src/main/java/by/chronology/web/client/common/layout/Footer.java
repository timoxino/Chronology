package by.chronology.web.client.common.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Horizontal panel with information about copyright and some links.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/23/12
 */
public class Footer extends Composite
{
    interface FooterUiBinder extends UiBinder<Widget, Footer>
    {
    }

    private static FooterUiBinder uiBinder = GWT.create(FooterUiBinder.class);

    public Footer()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
