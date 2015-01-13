package by.chronology.web.client.track;

import by.chronology.web.client.model.TimeTag;
import by.chronology.web.client.model.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Form;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;

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

    interface MyUiBinder extends UiBinder<Form, TrackView>
    {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public TrackView()
    {
        initWidget(uiBinder.createAndBindUi(this));
        trackButton.setSize(ButtonSize.SMALL);
        trackButton.setType(ButtonType.INFO);
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
        timeTag.setTagTimestamp(currentTimestamp);
        timeTag.setTagName("test name");
        final User user = new User();
        user.setId(1L);
        user.setEmail("test");
        user.setPassword("testp");
        timeTag.setUser(user);
        return timeTag;
    }
}
