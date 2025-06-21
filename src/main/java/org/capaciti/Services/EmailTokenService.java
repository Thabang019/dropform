package org.capaciti.Services;

import jakarta.transaction.Transactional;
import org.capaciti.DTO.EmailToken;
import org.capaciti.Repository.EmailTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailTokenService {

    private final EmailTokenRepository emailTokenRepository;

    @Autowired
    EmailTokenService(EmailTokenRepository emailTokenRepository) {
        this.emailTokenRepository = emailTokenRepository;
    }

    @Transactional
    public EmailToken save(EmailToken emailToken) {
        EmailToken token = emailToken;
        if (emailToken.getToken() == null || emailToken.getToken().isBlank()) {
            token = new EmailToken.Builder().copy(emailToken).setToken(UUID.randomUUID().toString()).build();
        }
        return emailTokenRepository.save(token);
    }


    public EmailToken read(String token) {
        return emailTokenRepository.findEmailTokenByToken(token);
    }
}


