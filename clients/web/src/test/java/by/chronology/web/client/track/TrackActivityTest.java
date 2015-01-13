package by.chronology.web.client.track;

import by.chronology.web.client.event.ShowAlertEvent;
import by.chronology.web.client.model.TimeTag;
import by.chronology.web.client.notification.NotificationMessages;
import by.chronology.web.client.service.rpc.TimeTagServiceAsync;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.junit.GWTMockUtilities;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.constants.AlertType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Tsimafei_Shchytkavets
 */
@RunWith(MockitoJUnitRunner.class)
public class TrackActivityTest
{
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private final static String SAVED = "saved";
    private final static String NOT_SAVED = "not saved";

    private TrackActivity activity;
    private TrackView trackView;
    private TimeTag timeTag;
    @Mock
    NotificationMessages messages;
    @Mock
    PlaceController placeController;
    @Mock
    TimeTagServiceAsync timeTagService;
    @Mock
    EventBus eventBus;

    @Before
    public void setUp() throws Exception
    {
        GWTMockUtilities.disarm();
        trackView = mock(TrackView.class);
        activity = new TrackActivity(trackView, placeController, timeTagService);
        activity.eventBus = eventBus;
        activity.messages = messages;

        timeTag = new TimeTag();
        when(trackView.getTimeTag()).thenReturn(timeTag);
        when(messages.success()).thenReturn(SUCCESS);
        when(messages.failure()).thenReturn(FAILURE);
        when(messages.timeTagWasSaved()).thenReturn(SAVED);
        when(messages.timeTagWasNotSaved()).thenReturn(NOT_SAVED);
    }

    @After
    public void tearDown()
    {
        GWTMockUtilities.restore();
    }

    @Test
    public void start()
    {
        //given
        final EventBus eventBusMock = mock(EventBus.class);
        final AcceptsOneWidget panel = mock(AcceptsOneWidget.class);
        final Widget trackViewAsWidget = mock(Widget.class);
        when(trackView.asWidget()).thenReturn(trackViewAsWidget);

        //when
        activity.start(panel, eventBusMock);

        //then
        verify(trackView).asWidget();
        verify(panel).setWidget(trackViewAsWidget);
        Assert.assertThat("Event bus should be populated", activity.eventBus, is(eventBusMock));
    }

    @Test
    public void onTrack()
    {
        activity.onTrack();

        verify(trackView).getTimeTag();
        verify(timeTagService).updateTimeTag(timeTag, activity.fireShowAlertEventCallback);
    }

    @Test
    public void onSuccess()
    {
        activity.fireShowAlertEventCallback.onSuccess(null);

        verify(messages).success();
        verify(messages).timeTagWasSaved();
        ArgumentCaptor<ShowAlertEvent> captor = ArgumentCaptor.forClass(ShowAlertEvent.class);
        verify(eventBus).fireEvent(captor.capture());

        checkEvent(captor, AlertType.INFO, SUCCESS, SAVED);
    }

    @Test
    public void onFailure()
    {
        activity.fireShowAlertEventCallback.onFailure(null);

        verify(messages).failure();
        verify(messages).timeTagWasNotSaved();
        ArgumentCaptor<ShowAlertEvent> captor = ArgumentCaptor.forClass(ShowAlertEvent.class);
        verify(eventBus).fireEvent(captor.capture());

        checkEvent(captor, AlertType.DANGER, FAILURE, NOT_SAVED);
    }

    private void checkEvent(ArgumentCaptor<ShowAlertEvent> captor, AlertType alertType, String heading, String message)
    {
        Assert.assertThat("Incorrect alert type", captor.getValue().getAlertType(), is(alertType));
        Assert.assertThat("Incorrect message", captor.getValue().getHeading(), is(heading));
        Assert.assertThat("Incorrect message", captor.getValue().getMessage(), is(message));
    }
}
