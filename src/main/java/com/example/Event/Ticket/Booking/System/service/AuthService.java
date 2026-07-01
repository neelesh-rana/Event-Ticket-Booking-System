package com.example.Event.Ticket.Booking.System.service;

import com.example.Event.Ticket.Booking.System.dto.AuthResponse;
import com.example.Event.Ticket.Booking.System.dto.LoginRequest;
import com.example.Event.Ticket.Booking.System.dto.RegisterRequest;
import com.example.Event.Ticket.Booking.System.entity.User;
import com.example.Event.Ticket.Booking.System.enums.Role;
import com.example.Event.Ticket.Booking.System.exception.ResourceNotFoundException;
import com.example.Event.Ticket.Booking.System.repository.UserRepository;
import com.example.Event.Ticket.Booking.System.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final ModelMapper modelMapper;

    // register user
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = modelMapper.map(request, User.class);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(Role.USER);

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .message("User Registered Successfully")
                .build();

    }

    // login   User
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        String token = jwtUtil.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .message("Login Successful")
                .build();

    }

}