package by.chronology.web.client.mapper;

import by.chronology.web.client.place.StartPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * Maps Places to/from tokens, used to configure a PlaceHistoryHandler.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
@WithTokenizers({StartPlace.Tokenizer.class})
public interface TimeTrackerPlaceHistoryMapper extends PlaceHistoryMapper
{
}
