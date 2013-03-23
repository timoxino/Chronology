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
public class MainLayoutPlace extends Place
{
    public final static String MAIN_LAYOUT_TOKEN = "main_layout";

    @Prefix(MAIN_LAYOUT_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<MainLayoutPlace>
    {

        @Override
        public MainLayoutPlace getPlace(String token)
        {
            return new MainLayoutPlace();
        }

        @Override
        public String getToken(MainLayoutPlace place)
        {
            return "";
        }
    }
}
