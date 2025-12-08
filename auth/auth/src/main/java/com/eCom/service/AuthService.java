package com.eCom.service;

import com.eCom.entity.AuthEntity;
import com.eCom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(AuthEntity user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            return "User already exists!";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return "User registered successfully!";

    }

    public String login(AuthEntity user) {

        AuthEntity existingUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // validate password
        if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // generate JWT token
        String token = jwtService.generateToken(existingUser.getEmail());

        return "Login successful! TOKEN: " + token;
    }

}
