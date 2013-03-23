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
public class LoginPlace extends Place
{
    public final static String LOGIN_PANEL_TOKEN = "login_panel";

    @Prefix(LOGIN_PANEL_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<LoginPlace>
    {

        @Override
        public LoginPlace getPlace(String token)
        {
            return new LoginPlace();
        }

        @Override
        public String getToken(LoginPlace place)
        {
            return "";
        }
    }
}
