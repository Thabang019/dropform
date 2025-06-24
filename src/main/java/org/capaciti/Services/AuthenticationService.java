package org.capaciti.Services;

import org.capaciti.DTO.JwtAuthenticationResponse;
import org.capaciti.DTO.SignInRequest;
import org.capaciti.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    AuthenticationService(UserRepository userRepository, UserService userService, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLoginEmail(), request.getLoginPassword()));
        var user = userRepository.findUserByEmailUser(request.getLoginEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        System.out.println(user);
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse.Builder().setToken(jwt).build();
    }
}
