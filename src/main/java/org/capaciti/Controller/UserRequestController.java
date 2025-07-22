package org.capaciti.Controller;

import org.capaciti.DTO.JwtAuthenticationResponse;
import org.capaciti.DTO.SignInRequest;
import org.capaciti.Domain.EmailToken;
import org.capaciti.Domain.User;
import org.capaciti.Factory.EmailTokenFactory;
import org.capaciti.Services.AuthenticationService;
import org.capaciti.Services.EmailTokenService;
import org.capaciti.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/send")
@CrossOrigin(origins = "https://dropform-kappa.vercel.app", allowCredentials = "true")
public class UserRequestController {

    private UserService userService;
    private EmailTokenService emailTokenService;
    private AuthenticationService authenticationService;
    @Autowired
    UserRequestController(UserService service, EmailTokenService emailTokenService, AuthenticationService authenticationService) {
        this.userService = service;
        this.emailTokenService = emailTokenService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        User savedUser = userService.save(user);
        EmailToken token = EmailTokenFactory.createEmail(savedUser);
        emailTokenService.save(token);
        return savedUser;
    }

    @GetMapping("/read/{email}")
    public User read(@PathVariable String email){
        return userService.read(email);
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse signin(@RequestBody SignInRequest request) {
        System.out.println("signin triggered");
        return authenticationService.signin(request);
    }

    @GetMapping("/retrieveToken/{email}")
    public EmailToken readToken(@PathVariable String email){
        System.out.println("retrieveToken triggered");
        return emailTokenService.readByEmail(email);
    }


}
