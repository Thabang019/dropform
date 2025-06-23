package org.capaciti.Factory;

import org.capaciti.DTO.User;

public class UserFactory {

    public static User createUser(String email, String name, String lastName, String password){
        return new User.Builder()
                .setEmailUser(email)
                .setNameUser(name)
                .setLastNameUser(lastName)
                .setPassword(password)
                .build();
    }
}
