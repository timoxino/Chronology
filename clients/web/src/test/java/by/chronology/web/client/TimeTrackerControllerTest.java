package by.chronology.web.client;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import by.chronology.web.client.event.ShowAlertEvent;
import by.chronology.web.client.notification.NotificationActivity;

import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Tsimafei_Shchytkavets
 */
@RunWith(MockitoJUnitRunner.class)
public class TimeTrackerControllerTest
{
    @Mock
    NavigationConfigurer navigationConfigurer;
    @Mock
    NotificationActivity notificationActivity;
    @Mock
    EventBus eventBus;

    private TimeTrackerController controller;

    @Before
    public void setUp() throws Exception
    {
        // service initialization
        controller = new TimeTrackerController();
        controller.notificationActivity = notificationActivity;
        controller.navigationConfigurer = navigationConfigurer;
        controller.eventBus = eventBus;
    }

    @Test
    public void go() throws Exception
    {
        // service invocation
        controller.go();

        // check expectations
        verify(eventBus).addHandler(any(ShowAlertEvent.TYPE.getClass()), eq(notificationActivity));
        verify(navigationConfigurer).navigate();
    }
}
