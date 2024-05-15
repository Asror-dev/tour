package org.example.tour.services.emailService;

import jakarta.mail.MessagingException;

import java.util.UUID;

public interface EmailService {
    void sendSimpleEmail(String subject, String text, UUID enquiryId) throws MessagingException;
}
