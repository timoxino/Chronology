package by.chronology.service.rest;

import by.chronology.core.model.User;
import by.chronology.core.service.UserBusinessService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserControllerTest
{
    private UserController controller;

    @Before
    public void setUp()
    {
        controller = new UserController();
        controller.userBusinessService = mock(UserBusinessService.class);
    }

    @Test
    public void createUser()
    {
        //given
        final User user = new User();

        //when
        controller.createUser(user);

        //then
        verify(controller.userBusinessService).createUser(user);
    }
}