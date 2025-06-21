package org.capaciti.Factory;

import org.capaciti.DTO.ContactRequest;
import org.capaciti.DTO.EmailToken;

public class EmailTokenFactory {

    public static EmailToken createEmail(String token, String userEmail){
        return new EmailToken.Builder()
                .setToken(token)
                .setUserEmail(userEmail)
                .build();
    }
}
