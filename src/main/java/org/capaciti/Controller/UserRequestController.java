package org.capaciti.Controller;

import org.capaciti.DTO.EmailToken;
import org.capaciti.DTO.User;
import org.capaciti.Factory.EmailTokenFactory;
import org.capaciti.Services.EmailTokenService;
import org.capaciti.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/send")
@CrossOrigin(origins = "*")
public class UserRequestController {

    private UserService userService;
    private EmailTokenService emailTokenService;
    @Autowired
    UserRequestController(UserService service, EmailTokenService emailTokenService) {
        this.userService = service;
        this.emailTokenService = emailTokenService;
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

}
