package mk.ukim.finki.wp.eshop.SpringFramework_Integration_Tests.Repository;

import mk.ukim.finki.wp.eshop.EShopApplication;
import mk.ukim.finki.wp.eshop.model.Role;
import mk.ukim.finki.wp.eshop.model.User;
import mk.ukim.finki.wp.eshop.repository.jpa.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest(classes= EShopApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserByUsernameTest(){
        String username = "Zorche99" + "_skit";
        User user = userRepository.save(new User(username, "skit", "Zorche", "Koceva", Role.ROLE_ADMIN));

        assertEquals(userRepository.findByUsername(user.getUsername()).get(),user);
    }

    @Test
    public void findUserByUsernameAndPasswordTest(){
        String username = "Zorche99" + "_skit";
        User user = userRepository.save(new User(username, "skit", "Zorche", "Koceva", Role.ROLE_ADMIN));

        assertEquals(userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword()).get(),user);
    }
}