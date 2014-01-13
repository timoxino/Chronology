package by.chronology.service.rest;

import by.chronology.core.model.TimeTag;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * RESTful service that provides CRUD functionality related to <code>TimeTag</code> entity.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 6/9/13
 */
@RestController
@RequestMapping("/timeTags")
public class TimeTagController
{
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = {"Accept=application/json"})
    public TimeTag getTimeTags(@PathVariable long id)
    {
        // TODO: stub implementation
        return new TimeTag();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putTimeTag(@PathVariable long id, @RequestBody TimeTag timeTag)
    {
        // TODO: stub implementation
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTimeTag(@PathVariable long id)
    {
        // TODO: stub implementation
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TimeTag createTimeTag(@RequestBody TimeTag timeTag)
    {
        // TODO: stub implementation
        return new TimeTag();
    }
}
