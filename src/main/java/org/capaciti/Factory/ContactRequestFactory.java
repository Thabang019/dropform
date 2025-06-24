package org.capaciti.Factory;

import org.capaciti.Domain.ContactRequest;

public class ContactRequestFactory {

    public static ContactRequest createContactRequest(String name, String email, String subject, String message, String token){
        return new ContactRequest.Builder()
                .setName(name)
                .setEmail(email)
                .setSubject(subject)
                .setMessage(message)
                .setToken(token)
                .build();
    }
}
