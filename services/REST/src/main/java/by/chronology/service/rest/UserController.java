package by.chronology.service.rest;

import by.chronology.core.model.User;
import by.chronology.core.service.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * RESTful service that provides <code>CRUD</code> functionality related to {@link by.chronology.core.model.User} entity.
 *
 * @author Tsimafei_Shchytkavets
 */
@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserBusinessService userBusinessService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user)
    {
        return userBusinessService.createUser(user);
    }
}
