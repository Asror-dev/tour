package org.example.tour.controller;


import lombok.RequiredArgsConstructor;

import org.example.tour.dto.LoginDto;
import org.example.tour.dto.RegisterDto;
import org.example.tour.security.service.JwtService;
import org.example.tour.services.userService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/x")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            Map<?, ?> login = userService.login(loginDto);
            return ResponseEntity.ok(login);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto dto) {
        try {
            userService.addUser(dto);
            return ResponseEntity.ok("registered");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("key") String refreshToken){
        return   jwtService.refreshToken(refreshToken);
    }
}
