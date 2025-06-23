package org.capaciti.Services;

import org.capaciti.DTO.User;
import org.capaciti.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User read(String email) {
        return userRepository.findUserByEmailUser(email);
    }
}
