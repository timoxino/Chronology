package by.chronology.core.service;

import by.chronology.core.dao.UserDao;
import by.chronology.core.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserBusinessServiceImplTest
{
    private UserBusinessServiceImpl userBusinessService;

    @Before
    public void setUp()
    {
        userBusinessService = new UserBusinessServiceImpl();
        userBusinessService.userDao = mock(UserDao.class);
    }

    @Test
    public void createUser()
    {
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        final User user = new User();
        user.setPassword("PSWD");

        // target service invocation
        final User resultUser = userBusinessService.createUser(user);

        // check expectations
        verify(userBusinessService.userDao).save(captor.capture());

        // check result values
        assertThat("Unexpected instance in result", resultUser, sameInstance(captor.getValue()));
        assertThat("Unexpected instance to be saved", user, sameInstance(captor.getValue()));
        assertThat("Password should be hashed", captor.getValue().getPassword(), not("PSWD"));
    }
}