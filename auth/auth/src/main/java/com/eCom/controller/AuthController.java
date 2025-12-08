package com.eCom.controller;

import com.eCom.entity.AuthEntity;
import com.eCom.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody AuthEntity user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthEntity user) {
        return authService.login(user);
    }
}
