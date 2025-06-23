package org.capaciti.Services;

import org.capaciti.DTO.EmailToken;
import org.capaciti.DTO.User;
import org.capaciti.Factory.EmailTokenFactory;
import org.capaciti.Factory.UserFactory;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmailTokenServiceTest {


    private static EmailToken emailToken;
    private static User user0;

    @Autowired
    private  EmailTokenService emailTokenService;

    @BeforeEach
    void setUp() {
        user0 = UserFactory.createUser("thabangcebo@gmail.com", "Thabang", "Mkhwanazi", "Cape5100");
        emailToken = EmailTokenFactory.createEmail(user0);
    }
    @Test
    void save() {
        EmailToken token = emailTokenService.save(emailToken);
        assertNotNull(token);
        System.out.println(token);
    }

    @Test
    void read() {
        EmailToken token = emailTokenService.read(emailToken.getToken());
        assertNotNull(token);
        assertEquals(emailToken.getToken(), token.getToken());
    }
}