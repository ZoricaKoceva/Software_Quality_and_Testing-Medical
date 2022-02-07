package mk.ukim.finki.wp.eshop.SpringFramework_Integration_Tests.Services;

import mk.ukim.finki.wp.eshop.repository.jpa.UserRepository;
import mk.ukim.finki.wp.eshop.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import mk.ukim.finki.wp.eshop.model.Role;

import static junit.framework.TestCase.assertNotNull;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class LoginAuthenticationTests {

    // Login with user authentication service
    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testLoginAuthenticateUserRegistered(){
        String username = "Zorica9";
        String password = "programiranje";
        assertNotNull(userService.register(username, password, password, "Zorica", "Koceva", Role.ROLE_ADMIN));
    }

    @Test
    public void testLoginAuthenticateUserNotRegistered(){
        String username = "User";
        String password = "user";
        assertNotNull(userService.register(username, password, password, "User", "Surname", Role.ROLE_USER));
    }

}
