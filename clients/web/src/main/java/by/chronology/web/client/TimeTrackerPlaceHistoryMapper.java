package by.chronology.web.client;

import by.chronology.web.client.common.layout.StartPlace;
import by.chronology.web.client.common.layout.MainLayoutPlace;
import by.chronology.web.client.common.layout.RegistrationPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * Maps Places to/from tokens, used to configure a PlaceHistoryHandler.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
@WithTokenizers({MainLayoutPlace.Tokenizer.class, StartPlace.Tokenizer.class, RegistrationPlace.Tokenizer.class})
public interface TimeTrackerPlaceHistoryMapper extends PlaceHistoryMapper
{
}
