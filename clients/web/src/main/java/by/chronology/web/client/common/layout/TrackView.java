package by.chronology.web.client.common.layout;

import by.chronology.web.client.model.TimeTag;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

import java.sql.Timestamp;
import java.util.Date;

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

    TrackActivity trackActivity;

    interface MyUiBinder extends UiBinder<FlowPanel, TrackView>
    {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public TrackView()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(TrackActivity activity)
    {
        trackActivity = activity;
    }

    @UiHandler("trackButton")
    public void onTrackClicked(ClickEvent event)
    {
        trackActivity.onTrack();
    }

    public TimeTag getTimeTag()
    {
        final TimeTag timeTag = new TimeTag();
        timeTag.setTagDescription(actionDescriptionField.getValue());
        final Timestamp currentTimestamp = new Timestamp(new Date().getTime());
        timeTag.setLastUpdateTimestamp(currentTimestamp);
        timeTag.setTagTimestamp(currentTimestamp);
        timeTag.setTagName("test name");
        return timeTag;
    }
}
