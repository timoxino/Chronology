package by.chronology.core.model.util;

import java.sql.Timestamp;

/**
 * Provides util functionality and constants for unit tests.
 *
 * @author Tsimafei_Shchytkavets
 */
public class CoreModelTestUtil
{
    public static final Long ID = 123L;
    public static final String NAME = "simple name";
    public static final String DESCRIPTION = "simple desc";
    public static final String EMAIL = "simple email";
    public static final String PASSWORD = "simple password";
    public static final Timestamp LAST_UPDATE_TIMESTAMP = new Timestamp(234L);
    public static final Timestamp TAG_TIMESTAMP = new Timestamp(345L);

    public static by.chronology.core.model.TimeTag createTimeTagModel(Long id, String name, String description)
    {
        final by.chronology.core.model.TimeTag timeTagModel = new by.chronology.core.model.TimeTag();
        timeTagModel.setId(id);
        timeTagModel.setTagName(name);
        timeTagModel.setTagDescription(description);
        timeTagModel.setTagTimestamp(TAG_TIMESTAMP);
        return timeTagModel;
    }

    public static by.chronology.core.model.User createUserModel(Long id, String email, String password)
    {
        final by.chronology.core.model.User userModel = new by.chronology.core.model.User();
        userModel.setId(id);
        userModel.setEmail(email);
        userModel.setPassword(password);
        return userModel;
    }
}
