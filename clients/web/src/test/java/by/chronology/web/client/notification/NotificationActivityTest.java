package by.chronology.web.client.notification;

import by.chronology.web.client.component.AlertComponent;
import by.chronology.web.client.event.ShowAlertEvent;
import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.google.gwt.junit.GWTMockUtilities;
import com.google.gwt.place.shared.PlaceController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Tsimafei_Shchytkavets
 */
@RunWith(MockitoJUnitRunner.class)
public class NotificationActivityTest
{
    private NotificationActivity activity;
    private AlertComponent alertComponent;
    @Mock
    PlaceController placeController;

    @Before
    public void setUp() throws Exception
    {
        GWTMockUtilities.disarm();
        alertComponent = mock(AlertComponent.class);
        activity = new NotificationActivity(placeController, alertComponent);
    }

    @After
    public void tearDown()
    {
        GWTMockUtilities.restore();
    }

    @Test
    public void handleEvent()
    {
        final ShowAlertEvent event = new ShowAlertEvent(AlertType.SUCCESS, "Heading", "Message");
        activity.handleEvent(event);

        verify(alertComponent).show(AlertType.SUCCESS, "Heading", "Message");
    }
}
