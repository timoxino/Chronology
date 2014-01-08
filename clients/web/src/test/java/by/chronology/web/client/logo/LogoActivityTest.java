package by.chronology.web.client.logo;

import com.google.gwt.junit.GWTMockUtilities;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Tsimafei_Shchytkavets
 */
public class LogoActivityTest
{
    private PlaceController placeController;
    private LogoActivity logoActivity;
    private LogoView logoView;

    @Before
    public void setUp()
    {
        GWTMockUtilities.disarm();

        logoView = mock(LogoView.class);
        placeController = mock(PlaceController.class);
        logoActivity = new LogoActivity(placeController, logoView);
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
        final AcceptsOneWidget panel = mock(AcceptsOneWidget.class);

        //when
        logoActivity.start(panel, null);

        //then
        verify(panel).setWidget(logoView);
    }
}
