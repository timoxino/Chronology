package by.chronology.web.client.logo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Tsimafei_Shchytkavets
 */
public class LogoView implements IsWidget
{
    @UiField
    HTMLPanel panel;

    interface MyUiBinder extends UiBinder<HTMLPanel, LogoView>
    {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public LogoView()
    {
        uiBinder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget()
    {
        return panel;
    }
}
