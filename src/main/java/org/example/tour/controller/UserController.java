package org.example.tour.controller;

import lombok.RequiredArgsConstructor;

import org.example.tour.services.userService.UserService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;




}
