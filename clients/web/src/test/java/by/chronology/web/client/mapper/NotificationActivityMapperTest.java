package by.chronology.web.client.mapper;

import by.chronology.web.client.notification.NotificationActivity;
import by.chronology.web.client.place.StartPlace;
import com.google.gwt.activity.shared.Activity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;

/**
 * @author Tsimafei_Shchytkavets
 */
@RunWith(MockitoJUnitRunner.class)
public class NotificationActivityMapperTest
{
    @Mock
    NotificationActivity notificationActivity;
    private NotificationActivityMapper mapper;

    @Before
    public void setUp() throws Exception
    {
        mapper = new NotificationActivityMapper();
        mapper.notificationActivity = notificationActivity;
    }

    @Test
    public void getActivityNull() throws Exception
    {
        final Activity activity = mapper.getActivity(null);
        assertNull("Expected null activity", activity);
    }

    @Test
    public void getActivity() throws Exception
    {
        final NotificationActivity activity = (NotificationActivity) mapper.getActivity(new StartPlace());
        Assert.assertThat("Invalid activity was returned", activity, is(notificationActivity));
    }
}
