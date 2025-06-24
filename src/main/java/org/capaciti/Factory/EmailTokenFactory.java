package org.capaciti.Factory;

import org.capaciti.Domain.EmailToken;
import org.capaciti.Domain.User;

public class EmailTokenFactory {

    public static EmailToken createEmail(User userEmail){
        return new EmailToken.Builder()
                .setUserEmail(userEmail)
                .build();
    }
}
