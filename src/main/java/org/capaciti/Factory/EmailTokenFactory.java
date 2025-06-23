package org.capaciti.Factory;

import org.capaciti.DTO.ContactRequest;
import org.capaciti.DTO.EmailToken;
import org.capaciti.DTO.User;

public class EmailTokenFactory {

    public static EmailToken createEmail(User userEmail){
        return new EmailToken.Builder()
                .setUserEmail(userEmail)
                .build();
    }
}
