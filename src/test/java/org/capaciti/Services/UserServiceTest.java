package org.capaciti.Services;

import org.capaciti.DTO.User;
import org.capaciti.Factory.UserFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    private static User user0;
    @Autowired
    private UserService userService;

    @BeforeEach
    void setup() {
        user0 = UserFactory.createUser("thabangcebo@gmail.com", "Thabang", "Mkhwanazi", "Cape5100");
    }

    @Test
    @Order(1)
    void save() {
        User user = userService.save(user0);
        assertNotNull(user);
    }

    @Test
    @Order(2)
    void read() {
        User user = userService.read(user0.getEmailUser());
        assertNotNull(user);
        assertEquals(user0.getEmailUser(), user.getEmailUser());
    }
}