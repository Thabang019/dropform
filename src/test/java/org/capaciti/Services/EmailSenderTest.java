package org.capaciti.Services;

import org.capaciti.DTO.ContactRequest;
import org.capaciti.DTO.EmailToken;
import org.capaciti.Factory.ContactRequestFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmailSenderTest {

    private static ContactRequest contactRequest;
    @Autowired
    private static EmailSender emailSenderService;

    @BeforeEach
    void setUp() {
        contactRequest = ContactRequestFactory.createContactRequest("Cole", "cole.lenting@capaciti.org", "Lets Collaborate", "Let's build", "Cape5100");

    }
    @Test
    void sendEmail() {
        emailSenderService.sendEmail(contactRequest.getEmail(), contactRequest);
    }
}