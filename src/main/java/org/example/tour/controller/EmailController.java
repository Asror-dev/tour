package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.services.emailService.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {


    private final EmailService emailService;

    @GetMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(
            @RequestParam String subject,
            @RequestParam String text,
            @RequestParam UUID enquiryId) {

       try {
           emailService.sendSimpleEmail( subject, text,enquiryId);
           return ResponseEntity.ok("Send email successfully");
       }catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
