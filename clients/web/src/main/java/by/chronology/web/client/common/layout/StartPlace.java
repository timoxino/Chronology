package by.chronology.web.client.common.layout;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * Auxiliary class that represents a bookmarkable location in an app.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class StartPlace extends Place
{
    public final static String LOGIN_PANEL_TOKEN = "start";

    @Prefix(LOGIN_PANEL_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<StartPlace>
    {

        @Override
        public StartPlace getPlace(String token)
        {
            return new StartPlace();
        }

        @Override
        public String getToken(StartPlace place)
        {
            return "";
        }
    }
}
