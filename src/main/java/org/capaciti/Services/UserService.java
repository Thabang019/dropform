package org.capaciti.Services;

import org.capaciti.Domain.User;
import org.capaciti.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return userRepository.findUserByEmailUser(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("Invalid employee ID format");
        }
    }

    public User save(User user) {
        String encodePass = passwordEncoder.encode(user.getPassword());
        User updateUser = new User.Builder().copy(user).setPassword(encodePass).build();
        return userRepository.save(updateUser);
    }

    public User read(String email) {
        return userRepository.findUserByEmailUser(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
