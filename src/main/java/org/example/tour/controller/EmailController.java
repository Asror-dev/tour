package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.EmailDto;
import org.example.tour.services.emailService.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {


    private final EmailService emailService;
    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(
            @RequestBody EmailDto emailDto) {
       try {
           emailService.sendSimpleEmail(emailDto.getSubject(), emailDto.getText(), emailDto.getEnquiryId());
           return ResponseEntity.ok("Send email successfully");
       }catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
