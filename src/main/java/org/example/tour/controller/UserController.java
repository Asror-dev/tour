package org.example.tour.controller;

import lombok.RequiredArgsConstructor;

import org.example.tour.entity.enums.Language;
import org.example.tour.services.userService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PutMapping
    private ResponseEntity<?> changeLanguage(@RequestParam Language lan,@RequestHeader(value = "userId") UUID userId){
        try {
            userService.changeUserLanguage(lan,userId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }



}
