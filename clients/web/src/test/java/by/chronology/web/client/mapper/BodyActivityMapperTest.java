package by.chronology.web.client.mapper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import by.chronology.web.client.place.StartPlace;
import by.chronology.web.client.track.TrackActivity;

import com.google.gwt.activity.shared.Activity;

/**
 * @author Tsimafei_Shchytkavets
 */
@RunWith(MockitoJUnitRunner.class)
public class BodyActivityMapperTest
{
    @Mock
    TrackActivity trackActivity;
    private BodyActivityMapper mapper;

    @Before
    public void setUp() throws Exception
    {
        mapper = new BodyActivityMapper();
        mapper.trackActivity = trackActivity;
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
        final TrackActivity activity = (TrackActivity) mapper.getActivity(new StartPlace());
        Assert.assertThat("Invalid activity was returned", activity, is(trackActivity));
    }
}
