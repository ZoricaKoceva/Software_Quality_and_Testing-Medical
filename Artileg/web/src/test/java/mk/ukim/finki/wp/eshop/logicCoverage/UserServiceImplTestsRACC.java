

package mk.ukim.finki.wp.eshop.logicCoverage;

import mk.ukim.finki.wp.eshop.model.Role;
import mk.ukim.finki.wp.eshop.model.User;
import mk.ukim.finki.wp.eshop.repository.jpa.UserRepository;
import mk.ukim.finki.wp.eshop.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImplTestsRACC {
    UserServiceImpl userService;
    public UserRepository userRepository;
    public PasswordEncoder passwordEncoder;

    public UserServiceImplTestsRACC() {}

//    public UserServiceImplTestsRACC(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userRepository, passwordEncoder);
    }

    // Tests for table where predicate is (username==null || username.isEmpty()  || password==null || password.isEmpty())

    // firstClause: T  secondClause: F  thirdClause: F  fourthClause: F  => P: T
    @Test
    public void testUsernameNull() {
        User user1 = new User(null, "finki", "Petko", "Petkovski", Role.ROLE_USER);
        if(user1.getUsername()==null) {
            assertTrue("InvalidUsername - null", true);
        }
    }

    // firstClause: F  secondClause: T  thirdClause: F  fourthClause: F  => P: T
    @Test
    public void testInvalidEmptyUsername() {

        User user2 = new User("", "finki", "Bojana", "Koteska", Role.ROLE_ADMIN);
        if(user2.getUsername().isEmpty()) {
            assertTrue("InvalidUsername - empty", true);
        }
    }

    // firstClause: F  secondClause: F  thirdClause: T  fourthClause: F  => P: T
    @Test
    public void testPasswordNull() {
        //logicCoverageClass.cal(0,15,10,9,2012);
        User user3 = new User("Skit99", null, "Softverski kvalitet", "Testiranje", Role.ROLE_USER);
        if(user3.getPassword()==null) {
            assertTrue("InvalidPassword - null", true);
        }
    }

    // firstClause: F  secondClause: F  thirdClause: F  fourthClause: T  => P: T
    @Test
    public void testInvalidEmptyPassword() {

        User user4 = new User("Zorche", "", "Zorica", "Koceva", Role.ROLE_USER);
        if(user4.getPassword().isEmpty()){
            assertTrue("InvalidPassword - empty", true);
        }
    }

    @Test
    public void testCorrectUser() {

        User user5 = new User("Marko7", "youtube", "Marko", "Markovikj", Role.ROLE_ADMIN);
        if (!(user5.getUsername()==null || user5.getUsername().isEmpty() || user5.getPassword()==null || user5.getPassword().isEmpty())){
            assertFalse("User with correct and valid info", false);
        }
    }

    //check if two users with same informations are equal
    @Test
    public void testEqualUsers() {
        User user6 = new User("Andrej7", "skit", "Andrej", "Petrushev", Role.ROLE_ADMIN);
        User user7 = new User("Andrej7", "skit", "Andrej", "Petrushev", Role.ROLE_ADMIN);
        assertEquals(user6, user7);
    }

    //check if two users with different informations are not equal
    @Test
    public void testNotEqualUsers() {
        User user8 = new User("Andrej7", "skit", "Andrej", "Petrushev", Role.ROLE_ADMIN);
        User user9 = new User("Zorica7", "emt", "Zorica", "Koceva", Role.ROLE_USER);
        assertNotEquals(user8, user9);
    }

}
