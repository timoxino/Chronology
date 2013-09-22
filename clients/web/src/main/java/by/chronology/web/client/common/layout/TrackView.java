package by.chronology.web.client.common.layout;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Panel that serves to fill time tag info and save it.
 *
 * @author Tsimafei_Shchytkavets
 */
public class TrackView extends Composite
{
    @UiField
    TextBox actionDescriptionField;
    @UiField
    Button trackButton;

    interface MyUiBinder extends UiBinder<FlowPanel, TrackView>
    {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public TrackView()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("trackButton")
    public void onTrackClicked(ClickEvent event)
    {
        //TODO: need to be implemented later
    }
}
