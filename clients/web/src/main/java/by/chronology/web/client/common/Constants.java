package by.chronology.web.client.common;

/**
 * Storage for cross-application constants.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/23/12
 */
public interface Constants
{
    public interface Layout
    {
        public interface Main
        {
            public final static String HEADER_PANEL_LABEL = "Header";
            public final static String NAVIGATION_PANEL_LABEL = "Navigation";
            public final static String BODY_PANEL_LABEL = "Body";
            public final static String FOOTER_LABEL = "Footer";
        }
    }

    public interface ErrorMessage
    {
        public interface Validation
        {
            public final static String EMAIL_INVALID = "Bad e-mail address";
        }
    }

    public interface RegExp
    {
        public final static String EMAIL_FORMAT = "^(\\w+)([-+.][\\w]+)*@(\\w[-\\w]*\\.){1,5}([A-Za-z]){2,4}$";
    }
}
