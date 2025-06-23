package org.capaciti.Controller;


import org.capaciti.DTO.EmailToken;
import org.capaciti.Repository.EmailTokenRepository;
import org.capaciti.Services.EmailTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.capaciti.DTO.ContactRequest;
import org.capaciti.Services.EmailSender;

import java.util.Optional;


@RestController
@RequestMapping("/api/email/send")
@CrossOrigin(origins = "*")
public class ContactRequestController {

    @Autowired
    private EmailSender emailService;

    @Autowired
    private EmailTokenService emailTokenService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody ContactRequest contactRequest) {
        try {
            EmailToken token = emailTokenService.read(contactRequest.getToken());

            if (token == null) {
                return ResponseEntity.badRequest().body("Invalid or missing token.");
            }
            emailService.sendEmail(token.getUserEmail().getEmailUser(), contactRequest);
            return ResponseEntity.ok("Message sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to send message.");
        }
    }
}
