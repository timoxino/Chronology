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
public class RegistrationPlace extends Place
{
    public final static String REGISTRATION_FORM_TOKEN = "registration_form";

    @Prefix(REGISTRATION_FORM_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<RegistrationPlace>
    {

        @Override
        public RegistrationPlace getPlace(String token)
        {
            return new RegistrationPlace();
        }

        @Override
        public String getToken(RegistrationPlace place)
        {
            return "";
        }
    }
}
